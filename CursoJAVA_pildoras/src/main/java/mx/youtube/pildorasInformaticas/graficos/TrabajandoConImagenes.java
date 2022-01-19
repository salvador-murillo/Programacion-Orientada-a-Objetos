package mx.youtube.pildorasInformaticas.graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConImagenes {
    public static void main(String[] args) {
        
        MarcoConImagenes miMarco = new MarcoConImagenes();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
        
    }
    
}

class MarcoConImagenes extends JFrame {

    public MarcoConImagenes(){
        setTitle("Prueba con Imagenes");
        setBounds(750, 300, 600, 400);
        
        LaminaConImagenes miLamina = new LaminaConImagenes();
        miLamina.setBackground(Color.DARK_GRAY);
        add(miLamina);
    }
}

class LaminaConImagenes extends JPanel {
    
    private Image miIcon; 
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        File rutaIcon = new File("Icon-mp3Tag.png");
        
        try{
            miIcon = ImageIO.read(rutaIcon);
        }catch(IOException ex){
            System.out.println("No pudo encontrarse la imagen:" + ex.getMessage());
        }
        
        g2.drawImage(miIcon, 10, 10, null);
    }
    
}

