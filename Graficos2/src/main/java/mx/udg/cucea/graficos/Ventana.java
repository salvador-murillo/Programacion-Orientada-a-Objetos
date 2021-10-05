package mx.udg.cucea.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author murillo
 */
public class Ventana extends JFrame{ //Paso 1 Heredar JFrame

    //Paso 2: Definir como atributos los elementos graficos de la ventana
    private JTextField numero1;
    private JTextField numero2;
    private JButton botonSumar;
    private JButton botonRestar;
    private JButton botonMultiplicar;
    private JButton botonDividir;
    private JLabel resultado;
    
    
    public Ventana(){
        //Paso 3: Inicialiazar la ventana por medio de un constructor
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarElementos(); //Metodo
        setSize(1000, 800);
        setVisible(true);
        
    }
    
    //Paso 4: Crear metodo inicializar, donde creamos y agregamos 
    //a la ventana todos los elementos gráficos 
    private void inicializarElementos(){
        numero1 = new JTextField();
        numero1.setBounds(150, 200, 200, 50);
        add(numero1);
        
        numero2 = new JTextField();
        numero2.setBounds(650, 200, 200, 50);
        add(numero2);
        
        botonSumar = new JButton("Sumar");
        botonSumar.setBounds(150, 350, 100, 100);
        add(botonSumar);
        
        botonRestar = new JButton("Restar");
        botonRestar.setBounds(350, 350, 100, 100);
        add(botonRestar);
        
        botonMultiplicar = new JButton("Multiplicar");
        botonMultiplicar.setBounds(550, 350, 100, 100);
        add(botonMultiplicar);
        
        botonDividir = new JButton("Dividir");
        botonDividir.setBounds(750, 350, 100, 100);
        add(botonDividir);
        
        //Paso 5: Crear listeners para los elementos que asi lo requieran
        botonSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String n1 = numero1.getText();
                String n2 = numero2.getText();
                
                double num1 = Double.parseDouble(n1);
                double num2 = Double.parseDouble(n2);
                double r = num1 + num2;
                
                resultado.setText("El resultado es: " + r);  
            }
        });
        
        botonRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String n1 = numero1.getText();
                String n2 = numero2.getText();
                
                double num1 = Double.parseDouble(n1);
                double num2 = Double.parseDouble(n2);
                double r = num1 - num2;
                
                resultado.setText("El resultado es: " + r);  
            }
        });
        
        botonMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String n1 = numero1.getText();
                String n2 = numero2.getText();
                
                double num1 = Double.parseDouble(n1);
                double num2 = Double.parseDouble(n2);
                double r = num1 * num2;
                
                resultado.setText("El resultado es: " + r);  
            }
        });
        
        botonDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String n1 = numero1.getText();
                String n2 = numero2.getText();
                
                double num1 = Double.parseDouble(n1);
                double num2 = Double.parseDouble(n2);
                double r = num1 / num2;
                
                resultado.setText("El resultado es: " + r);  
            }
        });
        
        resultado = new JLabel("El resultado es: ");
        resultado.setBounds(450, 550, 150, 50);
        add(resultado);
    }
    
}
