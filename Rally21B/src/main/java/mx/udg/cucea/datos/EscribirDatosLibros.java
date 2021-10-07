package mx.udg.cucea.datos;

import java.io.FileWriter;
import java.io.IOException;
import mx.udg.cucea.biblioteca.Libros;

/**
 *
 * @author murillo
 */
public class EscribirDatosLibros extends FileWriter{
    //Creacion de variable libro de tipo Libros
    private Libros libro;

    public EscribirDatosLibros(Libros l) throws IOException {
        super(l.getISBN() +".rtf");
        //Inicializamos la variable libro con lo que se mande de l
        this.libro = l;
    }
    
    public void escribirArchivo() throws IOException{
        //Append solo recibe Strings
        append(String.valueOf(libro.getPrecio()));
        append(System.lineSeparator());
        append(libro.getNombreDelLibro());
        append(System.lineSeparator());  
        append(libro.getNombreDelAutor());
        append(System.lineSeparator()); 
        append(String.valueOf(libro.getNumeroDePaginas()));
        append(System.lineSeparator());
        append(libro.getEditorial());
    }
}
