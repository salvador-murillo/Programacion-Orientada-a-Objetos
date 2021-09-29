package mx.udg.cucea.deportistas;


public class Luchador extends Deportista {
    private int peso; //En Kg
    
    private Luchador(String nombres, String apellidoPaterno, String pais, char rama) {
        super(nombres, apellidoPaterno, pais, rama);
    }
    
    //Constructor para crear luchadores
    public Luchador(String nombres, String apellidoPaterno, String pais, char rama, int peso) {
        this(nombres, apellidoPaterno, pais, rama);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    @Override
    public String toString(){
        return(nombres + " " + apellidoPaterno + " Pais: " + pais + " Rama: " + rama + ", soy luchador, peso " + peso + "kgs");
    }
}
