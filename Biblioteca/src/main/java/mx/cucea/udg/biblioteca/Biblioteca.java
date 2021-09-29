package mx.cucea.udg.biblioteca;
import mx.cucea.udg.libros.Libro;

public class Biblioteca {

    
    public static void main(String[] args) {
        Libro libro = new Libro("Don Quijote", "M. Cervantes");
        libro.setNumeroDePaginas(500);
        libro.setNumeroDePaginas(-50);
        System.out.println(libro.getNumeroDePaginas());
    }   
}
