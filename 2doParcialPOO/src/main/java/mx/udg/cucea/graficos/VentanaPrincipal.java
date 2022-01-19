package mx.udg.cucea.graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.udg.cucea.datos.GuardarDatos;

public class VentanaPrincipal extends JFrame {
    private JTextField campoTextoGrados;
    private JLabel etiquetaIngrese, etiquetaResultado, etiquetaSalida;
    private JButton botonCalcular, botonGuardar;
    double valorIngresado, valorConversion;
    GuardarDatos gd;
    
    public VentanaPrincipal(){
        setLayout(null);
        inicializar();
        actionButton();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(600, 100, 500, 800);
        setVisible(true); 
    }
    
    private void inicializar(){
        etiquetaIngrese = new JLabel("Ingrese grados Fahrenheit:");
        etiquetaIngrese.setBounds(160, 70, 200, 40);
        add(etiquetaIngrese);
        
        campoTextoGrados = new JTextField();
        campoTextoGrados.setBounds(150, 100, 200, 40);
        add(campoTextoGrados);
        
        botonCalcular = new JButton("Calcular");
        botonCalcular.setBounds(150, 350, 200, 40);
        add(botonCalcular);
        
        etiquetaResultado = new JLabel("El resultado es:");
        etiquetaResultado.setBounds(50, 500, 400, 40);
        etiquetaResultado.setHorizontalAlignment(JTextField.CENTER);
        
        etiquetaSalida = new JLabel("");
        etiquetaSalida.setBounds(50, 550, 400, 40);
        etiquetaSalida.setHorizontalAlignment(JTextField.CENTER);
        add(etiquetaSalida);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(200, 600, 100, 40);
    }
    
    private void actionButton(){
        
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valorIngresado = Double.parseDouble(campoTextoGrados.getText());
                valorConversion = valorConversion = (valorIngresado - 32)/1.80;
                add(etiquetaResultado);
                add(botonGuardar);
                revalidate();
                repaint();
                etiquetaSalida.setText(String.valueOf(valorConversion));
            }
        });
        
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gd = new GuardarDatos();
                    gd.agregarContenido(valorIngresado,valorConversion);
                    gd.close();
                } catch (IOException ex) {
                    System.out.println("No pude crear el archivo: " + ex.getMessage());
                }
            }
        });

    }
    
public static void main(String[] args) {
        new VentanaPrincipal();
    }
    
}
