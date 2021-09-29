package mx.udg.cucea.graficos;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Graficos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creacion de objeto tipo Frame
        JFrame ventana = new JFrame("Mi primer ventana");
        
        //FlowLayout acomoda en automatico lo que se asigne dentro de la ventana
        //FlowLayout flowLayout = new FlowLayout();
        ventana.setLayout(null); //flowLayout - null: No define un acomodo
        
        //Termina la ejecucion en netbeans al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar mb = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        mb.add(archivo);
        
        JMenuItem newProject = new JMenuItem("New Project...");
        JMenuItem newFile = new JMenuItem("New File...");
        JMenuItem salir = new JMenuItem("Salir");
        archivo.add(newProject);
        archivo.add(newFile);
        archivo.add(salir);
        
        ventana.setJMenuBar(mb);
        
        
        JButton boton = new JButton();
        boton.setText("Opcion 1");
        boton.setBounds(10, 30, 100, 200);
        ventana.add(boton);
        
        //Recomendacion como valor inicial se pone en el constructor
        //JButton boton2 = new JButton("Opcion 2");
        //ventana.add(boton2);
        
        JLabel etiqueta = new JLabel("Soy una etiqueta");
        etiqueta.setBounds(120, 30, 100, 50);
        ventana.add(etiqueta);
        
        JTextField campoDeTexto = new JTextField();
        campoDeTexto.setBounds(120, 90, 100, 50);
        ventana.add(campoDeTexto);
        
        //Siempre colocar al final por cuestiones de integracion con elementos
        ventana.setSize(1000, 700);
        ventana.setVisible(true);
    }
    
}
