package mx.udg.cucea.archivos;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.udg.cucea.datos.Contacto;

/**
 *
 * @author murillo
 */
public class LecturaArchivoContacto {
    private static final String CARPETA = "contactos/";
    
    //Metodo para leer contactos
    public ArrayList<Contacto> leerContactos(){
        
        ArrayList<Contacto> contactos = new ArrayList<>();
        File carpeta = new File(CARPETA);
        if(carpeta.exists()){
            String[] nombresDeArchivos = carpeta.list();
            
            for(String nombreDeArchivo: nombresDeArchivos){
                Contacto contacto = leerContacto(nombreDeArchivo);
                contactos.add(contacto);
            }
        }
        return contactos;
    }
    
    //Metodo para leer contacto por separado
    private Contacto leerContacto (String nombreArchivo){
        Path path = Paths.get(CARPETA + nombreArchivo);
        
        try {
            List<String> lineas = Files.readAllLines(path);
            String nombres = lineas.get(0);
            Contacto c = new Contacto(nombres, Long.parseLong(nombreArchivo));
            //Continuar
            c.setApellidoPaterno(nombres);
            return c;
        } catch (IOException ex) {
            System.out.println("No puedo leer el archivo" + ex.getMessage());
        }
        return null;
    }
}
