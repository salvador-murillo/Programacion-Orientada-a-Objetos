package mx.udg.cucea.escuela;

import java.io.IOException;
import java.util.ArrayList;
import mx.udg.cucea.datos.EscribirDatosAlumnos;

/**
 *
 * @author murillo
 */
public class Escuela {

    public static void main(String[] args) {
        
        ArrayList<Alumno> grupo1 = new ArrayList<>();
        
        Alumno alumno1 = new Alumno("Jose Perez", 70, 80, 90);
        grupo1.add(alumno1);
        
        Alumno alumno2 = new Alumno("Monserrat Lopez", 100, 90, 95);
        grupo1.add(alumno2);
        
        Alumno alumno3 = new Alumno("Diana Ruelas", 90, 80, 90);
        grupo1.add(alumno3);
        
        Alumno alumno4 = new Alumno("Arturo Medina", 60, 70, 70);
        grupo1.add(alumno4);
        
        Alumno alumno5 = new Alumno("Felipe Valadez", 80, 85, 60);
        grupo1.add(alumno5);
        
        grupo1.forEach(alumnosGrupo1 -> {
            
            System.out.println("\nNombre: " + alumnosGrupo1.getNombre() + "\nPromedio: " + alumnosGrupo1.promedio());
            
            try {
                // Creacion de objeto eat de tipo filewriter
                EscribirDatosAlumnos eal = new EscribirDatosAlumnos(alumnosGrupo1);
                // Llamada al metodo escribirArchivo
                eal.escribirArchivo();
                eal.close();
            } catch (IOException ex) {
                System.out.println("No pude escribir el archivo: " + ex.getMessage());
            }
        });
        
        
    }
    
}
