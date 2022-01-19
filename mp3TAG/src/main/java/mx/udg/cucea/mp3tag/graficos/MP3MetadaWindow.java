package mx.udg.cucea.mp3tag.graficos;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mx.udg.cucea.mp3tag.CustomFrame.JLabelMP3;
import mx.udg.cucea.mp3tag.CustomFrame.JTextFieldMP3;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.ID3v11Tag;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v22Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;
import org.jaudiotagger.tag.id3.ID3v24Tag;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.ArtworkFactory;

public class MP3MetadaWindow extends JFrame {

    //Elementos de GUI
    private final Color customGreen = new Color(52, 72, 59);
    private JButton botonActualizarDatos, botonCancelar, botonBuscarCoverArt;
    private JLabel logoMP3, coverArtMP3, newCoverArtMP3,
            etiquetaTitle, etiquetaArtist, etiquetaAlbum,
            etiquetaYear, etiquetaTrackNo, etiquetaTrackTotal,
            etiquetaDiscNo, etiquetaDiscTotal, etiquetaGenre,
            etiquetaAlbumArtist, etiquetaComposer;

    private JTextField campoDeTextoTitle, campoDeTextoArtist, campoDeTextoAlbum,
            campoDeTextoYear, campoDeTextoTrackNo, campoDeTextoTrackTotal,
            campoDeTextoDiscNo, campoDeTextoDiscTotal, campoDeTextoGenre,
            campoDeTextoAlbumArtist, campoDeTextoComposer;

    private mp3TAG VentanaPrincipal;

    //Archivos y etiquetas necesarias para leer datos de mp3
    private File archivoSeleccionado, fileNewCoverArt;
    private String newMP3Name = "";
    private Artwork getCoverMP3, setCoverMP3;
    private ImageIcon defaultArt, coverMP3, newCoverArt;
    //Objeto para redimensionar imagenes
    private ResizeCoverArt coverResized = new ResizeCoverArt();
    private AudioFile archivoMP3;
    Tag etiquetaArchivoMP3, etiquetaMP3;
    //private AbstractID3v2Tag etiquetaArchivoMP3;
    private boolean newCoverOK = false;
    
    
    //::Constructor::
    public MP3MetadaWindow(mp3TAG VentanaPrincipal, File archivoSeleccionado) {
        //Asignamos los parametros de entrada
        this.VentanaPrincipal = VentanaPrincipal;
        this.archivoSeleccionado = archivoSeleccionado;

        //Crear archivo de audio y etiquetas para leer y escribir
        try {
            archivoMP3 = AudioFileIO.read(archivoSeleccionado);
            etiquetaArchivoMP3 = archivoMP3.getTagOrCreateAndSetDefault();
            //etiquetaArchivoMP3 = archivoMP3.getID3v2TagAsv24();
            
            /*
            // If there is only a ID3v1 tag, copy data into new ID3v2.3 tag
            if(!(etiquetaMP3 instanceof ID3v24Tag || etiquetaMP3 instanceof ID3v24Tag)){
                etiquetaArchivoMP3 = null;
                if(etiquetaMP3 instanceof ID3v1Tag){
                    etiquetaArchivoMP3 = new ID3v23Tag((ID3v1Tag)archivoMP3.getTag()); // Copy old tag data               
                }
                if(etiquetaMP3 instanceof ID3v22Tag){
                    etiquetaArchivoMP3 = new ID3v23Tag((ID3v11Tag)archivoMP3.getTag()); // Copy old tag data              
                }           
                archivoMP3.setTag(etiquetaArchivoMP3);
            }
            */
        } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            System.out.println("No pude leer los metadatos");
            Logger.getLogger(MP3MetadaWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Definicion de Ventana
        setLayout(null);
        setTitle("Editar Metadatos");
        setBounds(600, 109, 600, 870);              //Ubicacion y tamaño
        setResizable(false);                        //No permite redimensionar
        setBackground(customGreen);
        getContentPane().setBackground(customGreen);//Pinta Ventana
        setGUIMetadata();                           //Agregar Textos y Campos de Textos
        getMP3Data();                               //Obtiene metadatos de mp3
        actionButtons();                            //Funcionamiento botones
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Inicializar elementos de UI
    private void setGUIMetadata() {
        //LogoApp
        Icon mp3Logo = new ImageIcon("icons/Icon-mp3Tag.png");
        logoMP3 = new JLabel(mp3Logo);
        logoMP3.setBounds(125, 25, 350, 100);
        add(logoMP3);

        //Crea las etiquetas/campos de texto, define tamaño y los agrega a la ventana
        etiquetaTitle = new JLabelMP3("Title:", 0);
        etiquetaTitle.setLocation(100, 130);
        add(etiquetaTitle);

        campoDeTextoTitle = new JTextFieldMP3(0);
        campoDeTextoTitle.setToolTipText("Nombre de la canción");
        campoDeTextoTitle.setLocation(140, 141);
        add(campoDeTextoTitle);

        etiquetaArtist = new JLabelMP3("Artist:", 1);
        etiquetaArtist.setLocation(92, 180);
        add(etiquetaArtist);

        campoDeTextoArtist = new JTextFieldMP3(0);
        campoDeTextoArtist.setToolTipText("Nombre del Artista");
        campoDeTextoArtist.setLocation(140, 191);
        add(campoDeTextoArtist);

        etiquetaAlbum = new JLabelMP3("Album:", 1);
        etiquetaAlbum.setLocation(85, 230);
        add(etiquetaAlbum);

        campoDeTextoAlbum = new JTextFieldMP3(0);
        campoDeTextoAlbum.setToolTipText("Nombre del Album");
        campoDeTextoAlbum.setLocation(140, 241);
        add(campoDeTextoAlbum);

        etiquetaYear = new JLabelMP3("Year:", 0);
        etiquetaYear.setLocation(100, 281);
        add(etiquetaYear);

        campoDeTextoYear = new JTextFieldMP3(1);
        campoDeTextoYear.setToolTipText("Año ejemplo: 2020");
        campoDeTextoYear.setLocation(140, 292);
        campoDeTextoYear.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTextoYear);

        etiquetaTrackNo = new JLabelMP3("Track #", 1);
        etiquetaTrackNo.setLocation(221, 281);
        add(etiquetaTrackNo);

        campoDeTextoTrackNo = new JTextFieldMP3(2);
        campoDeTextoTrackNo.setToolTipText("# de canción: 1/12");
        campoDeTextoTrackNo.setLocation(280, 292);
        campoDeTextoTrackNo.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTextoTrackNo);

        etiquetaTrackTotal = new JLabelMP3("/", 1);
        etiquetaTrackTotal.setLocation(310, 281);
        add(etiquetaTrackTotal);

        campoDeTextoTrackTotal = new JTextFieldMP3(2);
        campoDeTextoTrackTotal.setToolTipText("# de canción: 1/12");
        campoDeTextoTrackTotal.setLocation(320, 292);
        campoDeTextoTrackTotal.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTextoTrackTotal);

        etiquetaDiscNo = new JLabelMP3("Disc #", 1);
        etiquetaDiscNo.setLocation(370, 281);
        add(etiquetaDiscNo);

        campoDeTextoDiscNo = new JTextFieldMP3(2);
        campoDeTextoDiscNo.setToolTipText("# de disco: 1/2");
        campoDeTextoDiscNo.setLocation(419, 292);
        campoDeTextoDiscNo.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTextoDiscNo);

        etiquetaDiscTotal = new JLabelMP3("/", 1);
        etiquetaDiscTotal.setLocation(449, 281);
        add(etiquetaDiscTotal);

        campoDeTextoDiscTotal = new JTextFieldMP3(2);
        campoDeTextoDiscTotal.setToolTipText("# de disco: 1/2");
        campoDeTextoDiscTotal.setLocation(459, 292);
        campoDeTextoDiscTotal.setHorizontalAlignment(JTextField.CENTER);
        add(campoDeTextoDiscTotal);

        etiquetaGenre = new JLabelMP3("Genre:", 0);
        etiquetaGenre.setLocation(89, 331);
        add(etiquetaGenre);

        campoDeTextoGenre = new JTextFieldMP3(0);
        campoDeTextoGenre.setToolTipText("Genero");
        campoDeTextoGenre.setLocation(140, 342);
        add(campoDeTextoGenre);

        etiquetaAlbumArtist = new JLabelMP3("Album Artist:", 1);
        etiquetaAlbumArtist.setLocation(37, 381);
        add(etiquetaAlbumArtist);

        campoDeTextoAlbumArtist = new JTextFieldMP3(0);
        campoDeTextoAlbumArtist.setToolTipText("Artista del Album");
        campoDeTextoAlbumArtist.setLocation(140, 392);
        add(campoDeTextoAlbumArtist);

        etiquetaComposer = new JLabelMP3("Composer:", 1);
        etiquetaComposer.setLocation(56, 431);
        add(etiquetaComposer);

        campoDeTextoComposer = new JTextFieldMP3(0);
        campoDeTextoComposer.setToolTipText("Compositor");
        campoDeTextoComposer.setLocation(140, 442);
        add(campoDeTextoComposer);

        getCoverArt();

        //Botones
        botonBuscarCoverArt = new JButton("Cambiar Imagen del Album");
        botonBuscarCoverArt.setBounds(85, 760, 200, 35);

        botonActualizarDatos = new JButton("Actualizar Metadatos");
        botonActualizarDatos.setBounds(335, 580, 150, 35);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(335, 630, 150, 35);
    }

    //Obtener metadatos de la canción
    private void getMP3Data() {
        //Obtencion de datos en mp3
        campoDeTextoTitle.setText(etiquetaArchivoMP3.getFirst(FieldKey.TITLE));
        campoDeTextoArtist.setText(etiquetaArchivoMP3.getFirst(FieldKey.ARTIST));
        campoDeTextoAlbum.setText(etiquetaArchivoMP3.getFirst(FieldKey.ALBUM));
        campoDeTextoYear.setText(etiquetaArchivoMP3.getFirst(FieldKey.YEAR));
        campoDeTextoTrackNo.setText(etiquetaArchivoMP3.getFirst(FieldKey.TRACK));
        campoDeTextoTrackTotal.setText(etiquetaArchivoMP3.getFirst(FieldKey.TRACK_TOTAL));
        campoDeTextoDiscNo.setText(etiquetaArchivoMP3.getFirst(FieldKey.DISC_NO));
        campoDeTextoDiscTotal.setText(etiquetaArchivoMP3.getFirst(FieldKey.DISC_TOTAL));
        campoDeTextoGenre.setText(etiquetaArchivoMP3.getFirst(FieldKey.GENRE));
        campoDeTextoAlbumArtist.setText(etiquetaArchivoMP3.getFirst(FieldKey.ALBUM_ARTIST));
        campoDeTextoComposer.setText(etiquetaArchivoMP3.getFirst(FieldKey.COMPOSER));
    }

    //Guardar metadatos de la canción
    private void setMP3Data() {
        try {
            //Guardar datos en mp3
            etiquetaArchivoMP3.setField(FieldKey.TITLE, campoDeTextoTitle.getText());
            etiquetaArchivoMP3.setField(FieldKey.ARTIST, campoDeTextoArtist.getText());
            etiquetaArchivoMP3.setField(FieldKey.ALBUM, campoDeTextoAlbum.getText());
            etiquetaArchivoMP3.setField(FieldKey.YEAR, campoDeTextoYear.getText());
            etiquetaArchivoMP3.setField(FieldKey.TRACK, campoDeTextoTrackNo.getText());
            etiquetaArchivoMP3.setField(FieldKey.TRACK_TOTAL, campoDeTextoTrackTotal.getText());
            etiquetaArchivoMP3.setField(FieldKey.DISC_NO, campoDeTextoDiscNo.getText());
            etiquetaArchivoMP3.setField(FieldKey.DISC_TOTAL, campoDeTextoDiscTotal.getText());
            etiquetaArchivoMP3.setField(FieldKey.GENRE, campoDeTextoGenre.getText());
            etiquetaArchivoMP3.setField(FieldKey.ALBUM_ARTIST, campoDeTextoAlbumArtist.getText());
            etiquetaArchivoMP3.setField(FieldKey.COMPOSER, campoDeTextoComposer.getText());
            if(newCoverOK){
                etiquetaArchivoMP3.deleteArtworkField();
                etiquetaArchivoMP3.addField(setCoverMP3);
            }
            archivoMP3.commit();
            //System.out.println("Ruta Carpeta: " + archivoSeleccionado.getParent());
            setNewFilename();
            archivoSeleccionado.renameTo(new File(archivoSeleccionado.getParent() + "/" + newMP3Name));
        } catch (KeyNotFoundException | FieldDataInvalidException | CannotWriteException ex) {
            System.out.println("No pude guardar los metadatos");
            Logger.getLogger(MP3MetadaWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Definir nuevo nombre de archivo (Estilo iTunes)
    private void setNewFilename() {
        //Colocar # disco (Si Disc_Total es mayor a 1)
        if(!etiquetaArchivoMP3.getFirst(FieldKey.DISC_TOTAL).isBlank()){
            int discTotal = Integer.parseInt(etiquetaArchivoMP3.getFirst(FieldKey.DISC_TOTAL));
            if(discTotal>1){
                newMP3Name = String.format("%s-", etiquetaArchivoMP3.getFirst(FieldKey.DISC_NO));
            }
        }
        //Colocar numero de cancion
        if(etiquetaArchivoMP3.getFirst(FieldKey.TRACK) != null){
            int trackNo = Integer.parseInt(etiquetaArchivoMP3.getFirst(FieldKey.TRACK));
            //Si # pista es menor a 10
            if(trackNo >=1 && trackNo <10){
                newMP3Name = String.format("%s0%s ", newMP3Name, etiquetaArchivoMP3.getFirst(FieldKey.TRACK));   
            }else{
                newMP3Name = String.format("%s%s ", newMP3Name, etiquetaArchivoMP3.getFirst(FieldKey.TRACK));   
            }
            newMP3Name = String.format("%s%s.mp3", newMP3Name, etiquetaArchivoMP3.getFirst(FieldKey.TITLE));
        }else{
            newMP3Name = String.format("%s.mp3", etiquetaArchivoMP3.getFirst(FieldKey.TITLE));
        }
        //System.out.println("Nuevo nombre archivo: " + newMP3Name);
    }

    //Inicializar Cover Art
    private void getCoverArt() {
        // Default CoverArt
        defaultArt = new ImageIcon("icons/DefaultCoverArt.jpg");
        // Obtener de mp3
        getCoverMP3 = etiquetaArchivoMP3.getFirstArtwork();

        //Validar si tiene, si no colocar default
        if (getCoverMP3 == null) {
            coverArtMP3 = new JLabel(coverResized.getScaledImage(defaultArt));
        } else {
            coverMP3 = new ImageIcon(getCoverMP3.getBinaryData());
            coverArtMP3 = new JLabel(coverResized.getScaledImage(coverMP3));
        }
        //Definir posicion en GUI y tamaño
        coverArtMP3.setBounds(60, 500, 250, 250);
        add(coverArtMP3);
    }

    // Cambiar portada de disco, de acuerdo a seleccion
    private void setNewCoverArt() {
        
        if (newCoverArtMP3 != null) {
            //Si se busca por 2da vez hay que borrar el elemento cargado
            remove(newCoverArtMP3);
        } else {
            //Si no borrar la imagen cargada al inicio
            remove(coverArtMP3);
        }

        newCoverArt = new ImageIcon(fileNewCoverArt.getAbsolutePath());
        newCoverArtMP3 = new JLabel(coverResized.getScaledImage(newCoverArt));
        newCoverArtMP3.setBounds(60, 500, 250, 250);
        newCoverOK=true;
        add(newCoverArtMP3);
        revalidate();
        repaint();
    }

    //Agregar funcionamiento botones
    private void actionButtons() {
        //CAMBIAR Cover
        botonBuscarCoverArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Seleccionar carpeta del sistema
                FileDialog fd = new FileDialog((Frame) null, "Open");
                fd.setMode(FileDialog.LOAD);

                //Filtro para archivos compatibles
                final FilenameFilter filenameFilter = (dir, name)
                        -> name.endsWith(".jpg")
                        || name.endsWith(".JPG")
                        || name.endsWith(".jpeg")
                        || name.endsWith(".png");
                fd.setFilenameFilter(filenameFilter);
                fd.setFile("*.jpg;*.JPG;*.jpeg;*.png");
                JOptionPane.showMessageDialog(MP3MetadaWindow.this, "Archivos permitidos para imagen de portada:\n                  .jpg  .jpeg  .png");
                fd.setVisible(true);
                fileNewCoverArt = new File(fd.getDirectory(), fd.getFile()); //Objeto Carpeta
                
                try {
                    setCoverMP3 = ArtworkFactory.createArtworkFromFile(fileNewCoverArt);
                } catch (IOException ex) {
                    System.out.println("No se pudo guardar portada nueva: " + ex.getMessage());
                }
                
                setNewCoverArt();
            }
        });
        add(botonBuscarCoverArt);
        
        //ACTUALIZAR Datos
        botonActualizarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMP3Data();
                dispose();
                VentanaPrincipal.setVisible(true);
                VentanaPrincipal.actualizarModeloDeLista();
            }
        });
        add(botonActualizarDatos);
        
        //CANCELAR
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaPrincipal.setVisible(true);
            }
        });
        add(botonCancelar);
    }
}
