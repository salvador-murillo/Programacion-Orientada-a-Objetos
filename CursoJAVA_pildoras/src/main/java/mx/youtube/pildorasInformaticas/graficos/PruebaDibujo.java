package mx.youtube.pildorasInformaticas.graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PruebaDibujo {
    
    
    
    public static void main(String[] args) {
        
        MarcoConDibujos miMarco = new MarcoConDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

class MarcoConDibujos extends JFrame {

    public MarcoConDibujos(){
        setTitle("Prueba  de Dibujo");
        setSize(400, 400);
        
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
        miLamina.setBackground(Color.DARK_GRAY);
    }
}

class LaminaConFiguras extends JPanel {
    
    public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        
        //CLASE 59: Dibujando en frame 1
        //Dibuja un cuadrado en las cordenadas x=50 y=50 de 200px x 200px
        //g.drawRect(50, 50, 200, 200);
        //g.drawLine(100, 100, 300, 200);
        //g.drawArc(50, 100, 100, 200, 120, 150);
        
        //CLASE 60: Dibujando en frame 2
        //Conversion de objeto g a Graphics2D
        Graphics2D g2=(Graphics2D) g;
        //Figuras
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        Ellipse2D elipse = new Ellipse2D.Double();
        
        /*
        g2.draw(new Line2D.Double(100, 100, 300, 250)); //Dibujando instaciando
        
        double centroX = rectangulo.getCenterX();
        double centroY = rectangulo.getCenterY();
        double radio = 150;
        
        Ellipse2D circulo = new Ellipse2D.Double();
        //Dibuja un circulo a partir del centro de un rectangulo
        circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
        g2.draw(circulo);
        */
        
        //Clase 61: Manejando Colores
        g2.setPaint(Color.RED);
        //g2.draw(rectangulo); //Dibuja
        g2.fill(rectangulo); //Rellena
        
        elipse.setFrame(rectangulo);
        g2.setPaint(new Color(100, 120, 240));
        g2.fill(elipse);
    }
}