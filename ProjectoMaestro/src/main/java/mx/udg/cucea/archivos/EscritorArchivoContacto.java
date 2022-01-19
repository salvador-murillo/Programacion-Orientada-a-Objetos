package mx.udg.cucea.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.udg.cucea.datos.Contacto;

/**
 *
 * @author murillo
 */
public class EscritorArchivoContacto extends FileWriter {

    private Contacto contacto;
    private static final String CARPETA = "contactos/";
    //Lo primero que hace antes de cualquier cosa es ejecutar este bloque de codigo
    static {
        crearCarpetaSiNoExiste();
    }
    private EscritorArchivoContacto(String fileName) throws IOException {
        super(CARPETA + fileName + ".txt");
        
    }
    
    public EscritorArchivoContacto(Contacto contacto) throws IOException{
        this(String.valueOf(contacto.getTelefonoMovil())); //Llama al constructor privado
        this.contacto = contacto; //Guarda el contacto recibido en el de la clase.
    }
    
    //Metodo para crear carpeta en caso de que no existiera
    public static void crearCarpetaSiNoExiste(){
        File carpeta = new File(CARPETA);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
    }
    
    public void agregarContenido(){
        try {
            append(contacto.getNombres());
            append(System.lineSeparator());
            append(contacto.getApellidoPaterno());
            append(System.lineSeparator());
            append(contacto.getApellidoMaterno());
            append(System.lineSeparator());
            append(contacto.getCorreoElectronico());
            append(System.lineSeparator());
            append(String.valueOf(contacto.getTelefonoDeCasa()));
            append(System.lineSeparator());
            append(String.valueOf(contacto.getTelefonoDeOficina()));
            append(System.lineSeparator());
        } catch (IOException ex) {
            System.out.println("No se pudo escribir el archivo" + ex.getMessage());
        }
        
    }
}
