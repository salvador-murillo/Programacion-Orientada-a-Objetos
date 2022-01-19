package mx.udg.cucea.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LeftPanel extends JPanel {
    //Variables
    Color sideGreen = new Color(52, 72, 59);
    private Image mp3Logo;
    private File rutaIcon = new File("icons/Icon-mp3Tag.png");
    
    public LeftPanel() {
        setBounds(0, 0, 350, 870);
        setBackground(sideGreen);
        
        //Colocacion de Logo APP en sideBar
        try{
            mp3Logo = ImageIO.read(rutaIcon);
        }catch(IOException ex){
            System.out.println("No pudo encontrarse la imagen: " + ex.getMessage() );
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        g2.drawImage(mp3Logo, 6, 25, null);
        
        /*
        g2.setColor(Color.WHITE);
        Font arial = new Font("Arial", Font.PLAIN, 14);
        g2.setFont(arial);
        g2.drawString("Composer:", 20, 485);
        */
        
        Rectangle2D coverArt = new Rectangle2D.Double(20, 485, 305, 305);
        g2.setColor(sideGreen.darker());
        g2.fill(coverArt);
        
        g2.setColor(Color.BLACK);
        g2.drawLine(350, 0, 350, 870);
        
        
    }
}
