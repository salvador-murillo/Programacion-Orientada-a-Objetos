package mx.udg.cucea.graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.udg.cucea.operaciones.CalcularGanador;

public class VentanaTorneo extends JFrame {

    //Octavos
    private JLabel o1LB, o2LB, o3LB, o4LB, o5LB, o6LB, o7LB, o8LB;
    private CustomTextField r1LTF, r1VTF, r2LTF, r2VTF, r3LTF, r3VTF, r4LTF, r4VTF;
    private JButton r1A, r2A, r3A, r4A;

    //Cuartos
    private JLabel c1LB, c2LB, c3LB, c4LB;
    private JTextField r5LTF, r5VTF, r6LTF, r6VTF;
    private JButton r5A, r6A;

    //Semifinal
    private JLabel s1LB, s2LB;
    private JTextField r7LTF, r7VTF;
    private JButton r7A;

    //Final
    private JLabel ganador;
    private JLabel campeon;
    private VentanaEquipos vEqui;
    ArrayList<String> equipos;
    CalcularGanador cg = new CalcularGanador();

    //Constructor
    public VentanaTorneo(VentanaEquipos vEqui, ArrayList<String> equipos) {
        this.vEqui = vEqui;
        this.equipos = equipos;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarGUI();
        CalcularOctavos();
        CalcularSemifinal();
        CalcularCampeon();
        setSize(1200, 700);
        setVisible(true);
    }

    private void inicializarGUI() {
        o1LB = new JLabel(equipos.get(0));
        o1LB.setBounds(50, 30, 100, 50);
        add(o1LB);
        r1LTF = new CustomTextField();
        r1LTF.setLocation(200, 40);
        add(r1LTF);

        o2LB = new JLabel(equipos.get(1));
        o2LB.setBounds(50, 60, 100, 50);
        add(o2LB);
        r1VTF = new CustomTextField();
        r1VTF.setLocation(200, 70);
        add(r1VTF);

        r1A = new JButton("Aceptar");
        r1A.setBounds(250, 50, 80, 40);
        //Funcion
        add(r1A);

        o3LB = new JLabel(equipos.get(2));
        o3LB.setBounds(50, 200, 100, 50);
        add(o3LB);
        r2LTF = new CustomTextField();
        r2LTF.setLocation(200, 210);
        add(r2LTF);

        o4LB = new JLabel(equipos.get(3));
        o4LB.setBounds(50, 230, 100, 50);
        add(o4LB);
        r2VTF = new CustomTextField();
        r2VTF.setLocation(200, 240);
        add(r2VTF);

        r2A = new JButton("Aceptar");
        r2A.setBounds(250, 220, 80, 40);
        //Funcion
        add(r2A);

        o5LB = new JLabel(equipos.get(4));
        o5LB.setBounds(50, 370, 100, 50);
        add(o5LB);
        r3LTF = new CustomTextField();
        r3LTF.setLocation(200, 380);
        add(r3LTF);

        o6LB = new JLabel(equipos.get(5));
        o6LB.setBounds(50, 400, 100, 50);
        add(o6LB);
        r3VTF = new CustomTextField();
        r3VTF.setLocation(200, 410);
        add(r3VTF);

        r3A = new JButton("Aceptar");
        r3A.setBounds(250, 390, 80, 40);
        //Funcion
        add(r3A);

        o7LB = new JLabel(equipos.get(6));
        o7LB.setBounds(50, 540, 100, 50);
        add(o7LB);
        r4LTF = new CustomTextField();
        r4LTF.setLocation(200, 550);
        add(r4LTF);

        o8LB = new JLabel(equipos.get(7));
        o8LB.setBounds(50, 570, 100, 50);
        add(o8LB);
        r4VTF = new CustomTextField();
        r4VTF.setLocation(200, 580);
        add(r4VTF);

        r4A = new JButton("Aceptar");
        r4A.setBounds(250, 560, 80, 40);
        //Funcion
        add(r4A);

        //CUARTOS
        c1LB = new JLabel("Semifinal Pase 1");
        c1LB.setBounds(350, 90, 140, 50);
        add(c1LB);
        r5LTF = new CustomTextField();
        r5LTF.setLocation(500, 100);
        add(r5LTF);

        c2LB = new JLabel("Semifinal Pase 2");
        c2LB.setBounds(350, 160, 140, 50);
        add(c2LB);
        r5VTF = new CustomTextField();
        r5VTF.setLocation(500, 170);
        add(r5VTF);

        r5A = new JButton("Aceptar");
        r5A.setBounds(550, 130, 80, 40);
        //Funcion
        add(r5A);

        c3LB = new JLabel("Semifinal Pase 3");
        c3LB.setBounds(350, 430, 140, 50);
        add(c3LB);
        r6LTF = new CustomTextField();
        r6LTF.setLocation(500, 440);
        add(r6LTF);

        c4LB = new JLabel("Semifinal Pase 4");
        c4LB.setBounds(350, 500, 140, 50);
        add(c4LB);
        r6VTF = new CustomTextField();
        r6VTF.setLocation(500, 510);
        add(r6VTF);

        r6A = new JButton("Aceptar");
        r6A.setBounds(550, 470, 80, 40);
        //Funcion
        add(r6A);

        //SEMIFINAL
        s1LB = new JLabel("Final Pase 1");
        s1LB.setBounds(650, 240, 120, 50);
        add(s1LB);
        r7LTF = new CustomTextField();
        r7LTF.setLocation(800, 250);
        add(r7LTF);

        s2LB = new JLabel("Final Pase 2");
        s2LB.setBounds(650, 340, 120, 50);
        add(s2LB);
        r7VTF = new CustomTextField();
        r7VTF.setLocation(800, 350);
        add(r7VTF);

        r7A = new JButton("Aceptar");
        r7A.setBounds(850, 290, 80, 40);
        //Funcion
        add(r7A);

        //Final
        ganador = new JLabel("");
        ganador.setBounds(1000, 285, 120, 50);
        add(ganador);
        campeon = new JLabel("::: CAMPEON :::");
        campeon.setBounds(1000, 265, 120, 50);
        campeon.setForeground(Color.red);
        add(campeon);

    }

    private void CalcularOctavos() {

        r1A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1LB.setText(cg.ObtenerResultado(o1LB, r1LTF, o2LB, r1VTF));
            }
        });

        r2A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c2LB.setText(cg.ObtenerResultado(o3LB, r2LTF, o4LB, r2VTF));
            }
        });
        
        r3A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c3LB.setText(cg.ObtenerResultado(o5LB, r3LTF, o6LB, r3VTF));
            }
        });
        
        r4A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c4LB.setText(cg.ObtenerResultado(o7LB, r4LTF, o8LB, r4VTF));
            }
        });
    }
    
    private void CalcularSemifinal() {
        
        r5A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s1LB.setText(cg.ObtenerResultado(c1LB, r5LTF, c2LB, r5VTF));
            }
        });
        
        r6A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s2LB.setText(cg.ObtenerResultado(c3LB, r6LTF, c4LB, r6VTF));
            }
        });
        
    }
    
    private void CalcularCampeon() {
    
        r7A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ganador.setText(cg.ObtenerResultado(s1LB, r7LTF, s2LB, r7VTF));
            }
        });
    }

}
