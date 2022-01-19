package mx.youtube.pildorasInformaticas.graficos;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

public class DetectarFuentesSistema {
    
    public static void main(String[] args){
        
        
        String fuente = JOptionPane.showInputDialog("Introduce Fuente:");
        boolean fuenteDisponible = false;
        String[] fuentes =  GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        for(String nombreFuente: fuentes){
            //System.out.println(fuente); //Lee todas las fuentes instaladas
            if(nombreFuente.equals(fuente)){
                fuenteDisponible=true;
            }
        }
        
        System.out.println("Fuente" + ((fuenteDisponible) ? " Instalada" : " No Instalada"));
        
    }
}
