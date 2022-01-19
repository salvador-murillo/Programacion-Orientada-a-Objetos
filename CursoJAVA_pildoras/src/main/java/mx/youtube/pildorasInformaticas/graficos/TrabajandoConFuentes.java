package mx.youtube.pildorasInformaticas.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes {
    
    public static void main(String[] args) {
        
        MarcoConFuentes miMarco = new MarcoConFuentes();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }
    
}

class MarcoConFuentes extends JFrame {

    public MarcoConFuentes(){
        setTitle("Prueba con Fuentes");
        setSize(400, 400);
        
        LaminaConFuentes miLamina = new LaminaConFuentes();
        add(miLamina);
        miLamina.setBackground(Color.white);
    }
}

class LaminaConFuentes extends JPanel {
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Font miFuente = new Font("Courier", Font.BOLD, 25);
        g2.setFont(miFuente);
        g2.setColor(Color.BLUE);
        g2.drawString("Chava", 100, 100);
        g2.setFont(new Font("Calibri", Font.ITALIC, 15));
        g2.setColor(Color.gray);
        g2.drawString("Curso Java", 100, 200);
        
    }
}
