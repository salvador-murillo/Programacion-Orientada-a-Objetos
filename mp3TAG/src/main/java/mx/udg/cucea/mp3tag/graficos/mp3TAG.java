package mx.udg.cucea.mp3tag.graficos;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class mp3TAG extends JFrame {

    private final Color customGreen = new Color(52, 72, 59);
    private final String os = System.getProperty("os.name");
    private JButton botonBuscar, botonEditar, botonBorrar;
    private JLabel logoMP3, rutaArchivos;
    private DefaultListModel<String> modeloDeLista;
    private JList lista;
    private ArrayList<String> nameFiles = new ArrayList<String>();
    private File carpeta, archivoSeleccionado;
    private Boolean itemValid = false, isMacOS = false;

    public mp3TAG() {
        detectedOS();    //Detectar sistema operativo
        setGUIApp();     //Icono Dock, Logo, Colores, Botones
        actionButtons(); //Agregar Textos y Campos de Textos
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void detectedOS(){
        if (os.equals("Mac OS X")) {
            isMacOS=true;
        } else if (os.equals("Linux") || os.contains("Windows")) {
            isMacOS=false;
        }
    }
    
    private void setGUIApp() {
        //Definicion de Ventana
        setLayout(null);
        setTitle("mp3Tag");             //Titulo
        setBounds(600, 109, 600, 870); //Ubicacion y tamaño
        setResizable(false);            //No permite redimensionar
        getContentPane().setBackground(customGreen);//Pinta Ventana
        
        //IconApp
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        final Image iconApp = miPantalla.getImage("icons/musicIcon.png");
        if (isMacOS) {
            //this is new since JDK 9
            final Taskbar taskbar = Taskbar.getTaskbar();
            //set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(iconApp); //For macOS dock Icon
        } else {
            setIconImage(iconApp);
        }

        //LogoApp
        Icon mp3Logo = new ImageIcon("icons/Icon-mp3Tag.png");
        logoMP3 = new JLabel(mp3Logo);
        logoMP3.setBounds(125, 25, 350, 100);
        add(logoMP3);

        //Botones
        botonBuscar = new JButton("Buscar Archivos MP3");
        botonBuscar.setBounds(225, 130, 150, 40);
        
        rutaArchivos = new JLabel("");
        rutaArchivos.setBounds(100, 145, 400, 100);
        rutaArchivos.setForeground(Color.WHITE.brighter());
        add(rutaArchivos);
        
        botonEditar = new JButton("Editar");
        botonEditar.setBounds(150, 740, 80, 40);
        botonBorrar = new JButton("Borrar");
        botonBorrar.setBounds(370, 740, 80, 40);
        
        //Lista
        //Crea el modelo de lista de objetos contacto
        modeloDeLista = new DefaultListModel<String>();
        //Crea una lista nueva pasandole el modelo
        lista = new JList(modeloDeLista);
        lista.setBounds(100, 220, 400, 500);
        lista.setBackground(customGreen.brighter());
        lista.setForeground(Color.white);
        add(lista);
    }

    private void actionButtons() {
        //--BUSCAR Archivos
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                
                if(isMacOS){
                    //Only works for macOS (Delete and chose any file in directory to get the path)
                    System.setProperty("apple.awt.fileDialogForDirectories", "true");
                    
                    //Seleccionar carpeta del sistema
                    FileDialog fd = new FileDialog((Frame) null, "Open");
                    fd.setMode(FileDialog.LOAD);
                    fd.setVisible(true);
                    carpeta = new File(fd.getDirectory(),fd.getFile()); //Objeto Carpeta
                    System.setProperty("apple.awt.fileDialogForDirectories", "false");
                }else{
                    
                    //Seleccionar archivo como referencia a carpeta
                    FileDialog fd = new FileDialog((Frame) null, "Open");
                    fd.setMode(FileDialog.LOAD);
                    fd.setVisible(true);
                    carpeta = new File(fd.getDirectory()); //Objeto Carpeta
                }
                
                //Etiqueta para UI
                //System.out.println("\nCarpeta: " + carpeta.getAbsolutePath());
                rutaArchivos.setText(carpeta.getAbsolutePath());
                rutaArchivos.setToolTipText(carpeta.getAbsolutePath());
                actualizarModeloDeLista();
            }
        });
        add(botonBuscar);

        //--EDITAR Archivos
        botonEditar.addActionListener(new ActionListener() {
            @Override
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) { 
                if (lista.getSelectedValue() != null && itemValid==true) {
                    //Creacion de objeto File de acuerdo al item seleccionado
                    archivoSeleccionado = new File(carpeta, (String) lista.getSelectedValue());
                    //Al presionar el boton agregar, llama la ventana metadatos, y oculta la actual
                    new MP3MetadaWindow(mp3TAG.this, archivoSeleccionado);
                    setVisible(false);
                }else if (lista.getSelectedValue() == null && itemValid==false){
                    JOptionPane.showMessageDialog(mp3TAG.this, "Busca un directorio que contenga archivos .mp3");
                }else {
                    JOptionPane.showMessageDialog(mp3TAG.this, "Selecciona un item que editar");
                }
            }
        });
        add(botonEditar);

        //--BORRAR Archivos
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                //Al presionar el boton agregar, llama la ventana metadatos, y oculta la actual
                if (lista.getSelectedValue() != null) {
                    //Creacion de objeto File de acuerdo al item seleccionado
                    archivoSeleccionado = new File(carpeta, (String) lista.getSelectedValue());
                    archivoSeleccionado.delete(); //Borra archivo
                    actualizarModeloDeLista(); //Actualiza modelo
                }else if (lista.getSelectedValue() == null && itemValid==false){
                    JOptionPane.showMessageDialog(mp3TAG.this, "Busca un directorio que contenga archivos .mp3");
                }else {
                    JOptionPane.showMessageDialog(mp3TAG.this, "Selecciona un item que borrar.");
                }
            }
        });
        add(botonBorrar);
    }

    public void actualizarModeloDeLista() {
        //Limpia modelo y arreglo nameFiles
        modeloDeLista.clear();
        nameFiles.clear();
        
        //Crear filtro que acepte mp3 || file.getName().endsWith(".flac")
        FileFilter mp3Filefilter = (File file) -> file.getName().endsWith(".mp3");
        
        //Arreglo de objetos file (filtrados por MP3)
        File[] mp3Files = carpeta.listFiles(mp3Filefilter);
        if(mp3Files.length>0){
            itemValid=true;
        } else {
            JOptionPane.showMessageDialog(mp3TAG.this, "No existen archivos .mp3 en esta ubicación");
        }
        
        //Agrega los nombres de archivos de la lista de archivos
        for(File mp3File: mp3Files){
            //Agregar archivos al Arreglo de Strings
            nameFiles.add(mp3File.getName());
        }

        //Ordenar Nombre de Archivos (para mostrar en Modelo)
        Collections.sort(nameFiles);
        
        //Agrega al modelo
        modeloDeLista.addAll(nameFiles);
    }

    public static void main(String[] args) {
        new mp3TAG();
    }
}
