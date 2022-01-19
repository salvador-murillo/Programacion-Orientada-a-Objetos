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

public class LeerArchivoContacto {
    
    public static String CARPETA = "contactos/";
    
    //Array que guardara los contactos, regresa un arreglo de tipo contactos
    public ArrayList<Contacto> leerContactos (){
        
        //Variable que guardara objetos de tipo contacto
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        //Variable de tipo file, guarda la ruta de la carpeta
        File carpeta = new File(CARPETA);
        
        if (carpeta.exists()){
            //Arreglo de strings que guarda los nombres de los archivos
            String[] nombresDeArchivos = carpeta.list(); //.list : Busca todo lo que hay en el path
            //Recorre cada archivo
            for (String nombreDeArchivo: nombresDeArchivos){
                //Guarda en un objeto tipo contacto el contacto leido (c)
                Contacto contacto = leerContacto(nombreDeArchivo);
                //Lo agrega al arreglo
                contactos.add(contacto);
            }
        }
        return contactos;
    }
    
    //Metodo privado tipo 'Contacto' leera los archivos de la carpeta 
    private Contacto leerContacto(String nombreArchivo){
        
        //Variable de tipo Path, se guarda la ruta de la carpeta + nombreArchivo
        Path path = Paths.get(CARPETA + nombreArchivo);
        
        try {
            //Guarda en una lista de Strings (lineas), todo lo que contenga el path dado
            List<String> lineas = Files.readAllLines(path,Charset.defaultCharset());
            //Lee la primer linea (0) y la guarda en un String llamado 'nombres'
            String nombres = lineas.get(0);
            
            //Se crea un objeto de tipo contacto con el nombre y el nombre de archivo(#tel)
            Contacto c = new Contacto(nombres, Long.parseLong(nombreArchivo));
            
            //Se leen los demas datos y se asignan por medio de los setters
            c.setApellidoPaterno(lineas.get(1));
            c.setApellidoMaterno(lineas.get(2));
            c.setCorreoElectronico(lineas.get(3));
            c.setTelefonoDeCasa(Long.parseLong(lineas.get(4)));
            c.setTelefonoDeOficina(Long.parseLong(lineas.get(5)));
            //Se regresa el contacto
            return c;
        } catch (IOException ex) {
            System.out.println("No pude leer el archivo:" + ex.getMessage());
        }
        return null;
    }
}