package mx.udg.cucea.graficos;

import java.awt.Color;
import java.awt.Image;
import java.awt.Taskbar;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class VentanaPrincipal extends JFrame {
    
    //SideBar Elements
    LeftPanel sideBAR;
    JLabel etiquetaTitle;
    JLabel etiquetaArtist;
    JLabel etiquetaAlbum;
    JLabel etiquetaYear;
    JLabel etiquetaTrackNumber;
    JLabel etiquetaDiscNumber;
    JLabel etiquetaGenre;
    JLabel etiquetaAlbumArtist;
    JLabel etiquetaComposer;
    JLabel imagenIconoMP3;
    JLabel mp3Icon;
    
    JTextField campoDeTextoTitle;
    JTextField campoDeTextoArtist;
    JTextField campoDeTextoAlbum;
    JTextField campoDeTextoYear;
    JTextField campoDeTextoTrackNumber;
    JTextField campoDeTextoDiscNumber;
    JTextField campoDeTextoGenre;
    JTextField campoDeTextoAlbumArtist;
    JTextField campoDeTextoComposer;
    
    //toolBar
    static JToolBar toolBarMP3;
    
    
    //Constructor
    public VentanaPrincipal() {
        //Definicion de Ventana
        setLayout(null);
        setTitle("mp3Tag");             //Titulo
        setIconApp();                   //Icono de App
        setBounds(298, 107, 1200, 870); //Ubicacion y tamaño
        setResizable(false);            //No permite redimensionar
        setBackground(Color.GREEN);     //Pinta Ventana (Solo Header)
        inicializar();                  //Agregar Textos y Campos de Textos
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }

    private void setIconApp() {
        String os = System.getProperty("os.name");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        final Image iconApp = miPantalla.getImage("icons/musicIcon.png");
        if(os.equals("Mac OS X")){
            //this is new since JDK 9
            final Taskbar taskbar = Taskbar.getTaskbar();
            //set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(iconApp); //For macOS dock Icon
        }else if(os.equals("Linux") || os.contains("Windows") ){
            setIconImage(iconApp);
        }
    }
    
    private void inicializar() {
        sideBAR = new LeftPanel();
        inicializarSideBar();
        add(sideBAR);
        toolBarMP3 = new JToolBar();
        inicializarToolBar(toolBarMP3);
        add(toolBarMP3);
    }
    
    private void inicializarSideBar(){
        
        //Crea las etiquetas/campos de texto, define tamaño y los agrega a la ventana
        etiquetaTitle = new JLabel("Title:");
        etiquetaTitle.setForeground(Color.WHITE);
        etiquetaTitle.setBounds(20,130,50,50);
        add(etiquetaTitle);
        
        campoDeTextoTitle = new JTextFieldSB();
        campoDeTextoTitle.setBounds(18,160,310,30);
        add(campoDeTextoTitle);
        
        etiquetaArtist = new JLabel("Artist:");
        etiquetaArtist.setForeground(Color.WHITE);
        etiquetaArtist.setBounds(20,180,50,50);
        add(etiquetaArtist);
        
        campoDeTextoArtist = new JTextFieldSB();
        campoDeTextoArtist.setBounds(18,210,310,30);
        add(campoDeTextoArtist);
        
        etiquetaAlbum = new JLabel("Album:");
        etiquetaAlbum.setForeground(Color.WHITE);
        etiquetaAlbum.setBounds(20,230,50,50);
        add(etiquetaAlbum);
        
        campoDeTextoAlbum = new JTextFieldSB();
        campoDeTextoAlbum.setBounds(18,260,310,30);
        add(campoDeTextoAlbum);
        
        etiquetaYear = new JLabel("Year:");
        etiquetaYear.setForeground(Color.WHITE);
        etiquetaYear.setBounds(20,285,50,50);
        add(etiquetaYear);
        
        campoDeTextoYear = new JTextFieldSB();
        campoDeTextoYear.setBounds(52,295,50,30);
        add(campoDeTextoYear);
        
        etiquetaTrackNumber = new JLabel("Track #");
        etiquetaTrackNumber.setForeground(Color.WHITE);
        etiquetaTrackNumber.setBounds(128,285,100,50);
        add(etiquetaTrackNumber);
        
        campoDeTextoTrackNumber = new JTextFieldSB();
        campoDeTextoTrackNumber.setBounds(175,295,40,30);
        add(campoDeTextoTrackNumber);
        
        etiquetaDiscNumber = new JLabel("Disc #");
        etiquetaDiscNumber.setForeground(Color.WHITE);
        etiquetaDiscNumber.setBounds(248,285,100,50);
        add(etiquetaDiscNumber);
        
        campoDeTextoDiscNumber = new JTextFieldSB();
        campoDeTextoDiscNumber.setBounds(288,295,40,30);
        add(campoDeTextoDiscNumber);
        
        etiquetaGenre = new JLabel("Genre:");
        etiquetaGenre.setForeground(Color.WHITE);
        etiquetaGenre.setBounds(20,315,50,50);
        add(etiquetaGenre);
        
        campoDeTextoGenre = new JTextFieldSB();
        campoDeTextoGenre.setBounds(18,345,310,30);
        add(campoDeTextoGenre);
        
        etiquetaAlbumArtist = new JLabel("Album Artist:");
        etiquetaAlbumArtist.setForeground(Color.WHITE);
        etiquetaAlbumArtist.setBounds(20,365,150,50);
        add(etiquetaAlbumArtist);
        
        campoDeTextoAlbumArtist = new JTextFieldSB();
        campoDeTextoAlbumArtist.setBounds(18,395,310,30);
        add(campoDeTextoAlbumArtist);
        
        etiquetaComposer = new JLabel("Composer:");
        etiquetaComposer.setForeground(Color.WHITE);
        etiquetaComposer.setBounds(20,415,150,50);
        add(etiquetaComposer);
        
        campoDeTextoComposer = new JTextFieldSB();
        campoDeTextoComposer.setBounds(18,445,310,30);
        add(campoDeTextoComposer);
    }

    private void inicializarToolBar(JToolBar toolBarMP3){
        toolBarMP3.setBounds(340, 0, 860, 40);
        toolBarMP3.setRollover(true);
        toolBarMP3.setBackground(new Color(52, 72, 59));
    }
    
    public static void main(String[] args) {
        VentanaPrincipal mainWindow =  new VentanaPrincipal();
    }   

}



