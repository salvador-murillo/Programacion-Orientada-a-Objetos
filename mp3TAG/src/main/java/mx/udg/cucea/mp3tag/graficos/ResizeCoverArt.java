package mx.udg.cucea.mp3tag.graficos;

import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class ResizeCoverArt {
    ImageIcon coverResize;
    
    public ImageIcon getScaledImage(ImageIcon coverNormal){
        ImageIcon imageIcon = coverNormal;
        Image image = imageIcon.getImage(); // Transforma a Imagen
        Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // Escala smooth  
        coverResize = new ImageIcon(newimg); //Transforma a Icono
        return coverResize;
    }
    
    private ImageIcon getScaledImage500x500(ImageIcon coverNormal){
        ImageIcon imageIcon = coverNormal;
        Image image = imageIcon.getImage(); // Transforma a Imagen
        Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); // Escala smooth  
        coverResize = new ImageIcon(newimg); //Transforma a Icono
        return coverResize;
    }
}
