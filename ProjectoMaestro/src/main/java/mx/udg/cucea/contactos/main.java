package mx.udg.cucea.contactos;

import java.io.IOException;
import mx.udg.cucea.archivos.EscritorArchivoContacto;
import mx.udg.cucea.datos.Contacto;

/**
 *
 * @author murillo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contacto c1 = new Contacto("Joaquin", 66434532);
        c1.setApellidoPaterno("Gonzalez");
        c1.setApellidoMaterno("Linares");
        c1.setCorreoElectronico("jose@udg.mx");
        c1.setTelefonoDeCasa(6543221);
        c1.setTelefonoDeOficina(212333);
        
        Contacto c2 = new Contacto("Sandra", 55643234);
        c2.setApellidoPaterno("Martinez");
        c2.setApellidoMaterno("Jimenez");
        c2.setCorreoElectronico("sandra@udg.mx");
        c2.setTelefonoDeCasa(99999);
        c2.setTelefonoDeOficina(222222);
        
        try {
            EscritorArchivoContacto escritor = new EscritorArchivoContacto(c1);
            escritor.agregarContenido();
            escritor.close();
            
            EscritorArchivoContacto escritor2 = new EscritorArchivoContacto(c2);
            escritor2.agregarContenido();
            escritor2.close();
        } catch (IOException ex) {
            System.out.println("No puedo escribir el archivo");
        }
    }
    
}
