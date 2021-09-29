package mx.cucea.udg.libros;


public class Libro {
    String autor;
    String titulo;
    private int numeroDePaginas;
    String editorial;
    
    public Libro(String t, String a){
        titulo = t;
        autor = a;
    }
    
    public Libro(String t, String a, int n, String e){
        titulo = t;
        autor = a;
        numeroDePaginas = n;
        editorial = e;
    }
    
    //Set
    public void setNumeroDePaginas(int n){
        if(n > 0){
            numeroDePaginas = n;
        }
    }
    
    //Get
    public int getNumeroDePaginas(){
        return numeroDePaginas;
    }
    
}
