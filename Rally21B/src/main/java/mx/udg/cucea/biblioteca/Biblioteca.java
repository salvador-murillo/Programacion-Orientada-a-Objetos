package mx.udg.cucea.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import mx.udg.cucea.datos.EscribirDatosLibros;

/**
 *
 * @author murillo
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Libros> estante1 = new ArrayList<>();
        
        Libros libro1 = new Libros("321GBHDAS", 155.5f,"Pocahontas", "Juan Perez", 150, "Nuevo Mundo");
        estante1.add(libro1);

        Libros libro2 = new Libros("HJCR23212", 220,"El Esclavo", "Francisco Angel", 99, "El camino Rojo ediciones");
        estante1.add(libro2);

        Libros libro3 = new Libros("3234PPSLF", 549.99f,"Nuevos mundos", "Jaime de la Olla", 80, "Sierra Azul");
        estante1.add(libro3);

        Libros libro4 = new Libros("SKDL34876", 899,"Game Of Thrones", "George R.", 500, "Debolsillo");
        estante1.add(libro4);

        Libros libro5 = new Libros("KFVB78493", 330.33f,"Fundamentos de Java", "Aurelio Gutierrez", 600, "CUCEA BOOKS");
        estante1.add(libro5);

        Libros libro6 = new Libros("JKCLD9203", 600,"Swift & SiwftUI", "Apple", 90, "Apple Books");
        estante1.add(libro6);
        
        estante1.forEach(librosDeEstante1 ->{
            if(librosDeEstante1.getNumeroDePaginas()>100){
                System.out.print("\nLibro\nNombre: " + librosDeEstante1.getNombreDelLibro());
                System.out.print(" | Autor: " + librosDeEstante1.getNombreDelAutor());
            }
            
            try {
                // Creacion de objeto eat de tipo filewriter
                EscribirDatosLibros eal = new EscribirDatosLibros(librosDeEstante1);
                // Llamada al metodo escribirArchivo
                eal.escribirArchivo();
                eal.close();
            } catch (IOException ex) {
                System.out.println("No pude escribir el archivo: " + ex.getMessage());
            }
        });
        
        

    }
    
}
