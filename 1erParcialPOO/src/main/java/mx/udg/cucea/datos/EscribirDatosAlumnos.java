package mx.udg.cucea.datos;

import java.io.FileWriter;
import java.io.IOException;
import mx.udg.cucea.escuela.Alumno;

/**
 *
 * @author murillo
 */
public class EscribirDatosAlumnos extends FileWriter {
    private Alumno alumnos;
    
    public EscribirDatosAlumnos(Alumno al) throws IOException {
        super(al.getNombre() + ".txt");
        //Inicializamos la variable alumno con lo que se mande de al
        this.alumnos = al;
    }
    
    public void escribirArchivo() throws IOException{
        //Append solo recibe Strings
        append(alumnos.getNombre());
        append(System.lineSeparator());
        append(String.valueOf(alumnos.getCalificacion1()));
        append(System.lineSeparator());
        append(String.valueOf(alumnos.getCalificacion2()));
        append(System.lineSeparator());  
        append(String.valueOf(alumnos.getCalificacion3()));
        append(System.lineSeparator());  
        append("Promedio: " + String.valueOf(alumnos.promedio()));
        
    }
}
