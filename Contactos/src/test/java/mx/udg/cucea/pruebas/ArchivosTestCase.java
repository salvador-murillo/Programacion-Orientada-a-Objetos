package mx.udg.cucea.pruebas;

import java.io.IOException;
import java.util.ArrayList;
import mx.udg.cucea.archivos.EscritorArchivoContacto;
import mx.udg.cucea.archivos.LeerArchivoContacto;
import mx.udg.cucea.datos.Contacto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArchivosTestCase {
    private EscritorArchivoContacto eac;
    private LeerArchivoContacto lac;
    
    public ArchivosTestCase() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void agregarContacto() {
        Contacto c = new Contacto("Pedro", 1234);
        try{
            eac = new EscritorArchivoContacto(c);
            eac.agregarContenido();
            eac.close();
            
            lac = new LeerArchivoContacto();
            ArrayList<Contacto> allContacts = lac.leerContactos();
            boolean encontrado = false;
            for(Contacto c2: allContacts){
                if(c2.getTelefonoMovil() == 1234){
                    assertEquals(c2.getNombres(), c.getNombres());
                    encontrado = true;
                }
            }
            
            assertEquals(encontrado, true);
            
        }catch (IOException e){
            
        }
        
    }
}
