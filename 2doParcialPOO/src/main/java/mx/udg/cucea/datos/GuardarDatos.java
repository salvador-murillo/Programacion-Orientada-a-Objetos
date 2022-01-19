package mx.udg.cucea.datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarDatos extends FileWriter {

    public static final String CARPETA = "archivos/";

    static {
        crearCarpetaSiNoExiste();
    }

    public GuardarDatos() throws IOException {
        super(CARPETA + "temperatura.txt");
    }

    //Metodo para crear la carpeta "archivos" 
    public static void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    //Metodo para agregar la informacion del objeto  al archivo generado
    public void agregarContenido(Double gradosF, Double gradosC) {
        try {
            append(String.valueOf(gradosF) + " grados fahrenheit equivalen a " + String.valueOf(gradosC) + " grados centigrados");
        } catch (IOException ex) {
            System.out.println("No puedo escribir al archivo" + ex.getMessage());
        }
    }
}
