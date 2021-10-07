package mx.udg.cucea.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author murillo
 */
public class VentanaConListas extends JFrame { //Paso 1 Heredar JFrame
    
    //Paso 2: Definir como atributos los elementos graficos de la ventana
    private JList listaIzq;
    private JList listaDer;
    private DefaultListModel<String> datosIzq; //Variable que recibe string
    private DefaultListModel<String> datosDer;
    private JButton botonEnviarAIZQ;
    private JButton botonEnviarADER;
    
    public VentanaConListas(){
        //Paso 3: Inicialiazar la ventana por medio de un constructor
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializar(); //Metodo
        setSize(1200, 900);
        setVisible(true);
    }
    
    //Paso 4: Crear metodo inicializar, donde creamos y agregamos 
    //a la ventana todos los elementos gráficos
    private void inicializar(){
        
        datosIzq = new DefaultListModel<>();
        datosIzq.addElement("Guadalajara");
        datosIzq.addElement("Zapopan");
        datosIzq.addElement("Tonala");
        datosIzq.addElement("Tlajomulco");
        datosIzq.addElement("Tlaquepaque");
        datosIzq.addElement("Leon");
        datosIzq.addElement("Tepic");
        datosIzq.addElement("Merida");
        listaIzq = new JList(datosIzq);
        listaIzq.setBounds(100, 150, 350, 600);
        add(listaIzq);
        
        datosDer = new DefaultListModel<>();
        listaDer = new JList(datosDer);
        listaDer.setBounds(650, 150, 350, 600);
        add(listaDer);
        
        botonEnviarADER = new JButton("--->");
        botonEnviarADER.setBounds(500, 300, 100, 50);
        add(botonEnviarADER);
        
        botonEnviarAIZQ = new JButton("<---");
        botonEnviarAIZQ.setBounds(500, 500, 100, 50);
        add(botonEnviarAIZQ);
        
        //Paso 5: Crear listeners para los elementos que asi lo requieran
        botonEnviarADER.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object objetoSeleccionado  = listaIzq.getSelectedValue();
                if (objetoSeleccionado != null){
                    String datoSeleccionado =  objetoSeleccionado.toString();
                    datosDer.addElement(datoSeleccionado);
                    datosIzq.removeElement(datoSeleccionado);
                }
            }
        });
        
        botonEnviarAIZQ.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Object objetoSeleccionado  = listaDer.getSelectedValue();
                if (objetoSeleccionado != null){
                    String datoSeleccionado = objetoSeleccionado.toString();
                    datosIzq.addElement(datoSeleccionado);
                    datosDer.removeElement(datoSeleccionado);
                }
            }
        });
    }
    
}
