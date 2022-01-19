package mx.udg.cucea.archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.udg.cucea.datos.Contacto;


//Extendemos de FileWriter para poder crear archivos
public class EscritorArchivoContacto extends FileWriter{
    
    //Sirve para poder guardar un objeto de tipo de contacto
    private Contacto contacto;
    
    //Ruta donde guardaremos los contactos
    public static final String CARPETA = "contactos/";
    
    //Bloque de codigo que se ejecuta en primera instancia
    static {
        crearCarpetaSiNoExiste();
    }
    
    //Constructor privado, recibe nombre de archivo
    private EscritorArchivoContacto(String fileName) throws IOException {
        super(CARPETA + fileName);
    }
    
    //Constructor publico, recibe objeto contacto como parametro de entrada
    public EscritorArchivoContacto(Contacto contacto) throws IOException{
        
        //Manda llamar al constructor padre (pasandole el #telefonoMovil como parametro de entrada)
        this(String.valueOf(contacto.getTelefonoMovil()));
        //Asigna el contacto del parametro de entrada al local
        this.contacto = contacto;
    }
   
    //Metodo para crear la carpeta "contactos" 
    public static void crearCarpetaSiNoExiste(){
        File carpeta = new File(CARPETA);
        if(!carpeta.exists()){
            carpeta.mkdir();
        }
    }
    
    //Metodo para agregar la informacion del objeto contacto al archivo generado
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
            System.out.println("No puedo escribir al archivo" +
                    ex.getMessage());
        }
    }

    public void editarContacto(Contacto contactoAnterior){
        if(contactoAnterior.getTelefonoMovil() != contacto.getTelefonoMovil()){
            File contactoABorrar = new File(CARPETA + contactoAnterior.getTelefonoMovil());
            contactoABorrar.delete();
        }
        agregarContenido();
    }
    
}