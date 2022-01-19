package mx.udg.cucea.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaEquipos extends JFrame {
    
    private JTextField e1TF, e2TF, e3TF, e4TF, e5TF, e6TF, e7TF, e8TF;
    private JLabel e1LB, e2LB, e3LB, e4LB, e5LB, e6LB, e7LB, e8LB;
    private JButton crearTorneo;
    ArrayList<String> equipos = new ArrayList<String>();
    
    //Constructor
    public VentanaEquipos() {
        setLayout(null);
        inicializar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setVisible(true);
    }
    
    private void inicializar(){
        e1LB = new JLabel("Equipo 1");
        e1LB.setBounds(350, -50, 100, 300);
        add(e1LB);
        
        e1TF = new JTextField();
        e1TF.setBounds(450, 70, 400, 50);
        add(e1TF);
        
        e2LB = new JLabel("Equipo 2");
        e2LB.setBounds(350, 10, 100, 300);
        add(e2LB);
        
        e2TF = new JTextField();
        e2TF.setBounds(450, 130, 400, 50);
        add(e2TF);
        
        e3LB = new JLabel("Equipo 3");
        e3LB.setBounds(350, 70, 100, 300);
        add(e3LB);
        
        e3TF = new JTextField();
        e3TF.setBounds(450, 190, 400, 50);
        add(e3TF);
        
        e4LB = new JLabel("Equipo 4");
        e4LB.setBounds(350, 130, 100, 300);
        add(e4LB);
        
        e4TF = new JTextField();
        e4TF.setBounds(450, 250, 400, 50);
        add(e4TF);
        
        e5LB = new JLabel("Equipo 5");
        e5LB.setBounds(350, 190, 100, 300);
        add(e5LB);
        
        e5TF = new JTextField();
        e5TF.setBounds(450, 310, 400, 50);
        add(e5TF);
        
        e6LB = new JLabel("Equipo 6");
        e6LB.setBounds(350, 250, 100, 300);
        add(e6LB);
        
        e6TF = new JTextField();
        e6TF.setBounds(450, 370, 400, 50);
        add(e6TF);
        
        e7LB = new JLabel("Equipo 7");
        e7LB.setBounds(350, 310, 100, 300);
        add(e7LB);
        
        e7TF = new JTextField();
        e7TF.setBounds(450, 430, 400, 50);
        add(e7TF);
        
        e8LB = new JLabel("Equipo 8");
        e8LB.setBounds(350, 370, 100, 300);
        add(e8LB);
        
        e8TF = new JTextField();
        e8TF.setBounds(450, 490, 400, 50);
        add(e8TF);
        
        crearTorneo = new JButton("Crear Torneo");
        crearTorneo.setBounds(750, 550, 100, 50);
        crearTorneo.addActionListener(new ActionListener() {
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                
                equipos.add(e1TF.getText().trim());
                equipos.add(e2TF.getText().trim());
                equipos.add(e3TF.getText().trim());
                equipos.add(e4TF.getText().trim());
                equipos.add(e5TF.getText().trim());
                equipos.add(e6TF.getText().trim());
                equipos.add(e7TF.getText().trim());
                equipos.add(e8TF.getText().trim());
                
                /*for(String equipo: equipos){
                    System.out.println(equipo);
                }*/
                //Mandamos llamar la ventana detalles pasandole el contacto a editar
                new VentanaTorneo(VentanaEquipos.this, equipos);
                setVisible(false);
                
            }
        });
        add(crearTorneo);
            
    }
    
    
    public static void main(String[] args) {
        new VentanaEquipos();
    }
    
}
