package mx.udg.cucea.biblioteca;

/**
 *
 * @author murillo
 */
public class Libros {
    protected String ISBN;
    private float precio;
    private String nombreDelLibro;
    private String nombreDelAutor;
    private int numeroDePaginas;
    private String editorial;

    public Libros(String ISBN, float precio, String nombreDelLibro, String nombreDelAutor, int numeroDePaginas, String editorial) {
        this.ISBN = ISBN;
        this.precio = precio;
        this.nombreDelLibro = nombreDelLibro;
        this.nombreDelAutor = nombreDelAutor;
        this.numeroDePaginas = numeroDePaginas;
        this.editorial = editorial;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombreDelLibro() {
        return nombreDelLibro;
    }

    public void setNombreDelLibro(String nombreDelLibro) {
        this.nombreDelLibro = nombreDelLibro;
    }

    public String getNombreDelAutor() {
        return nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
    
    
}
