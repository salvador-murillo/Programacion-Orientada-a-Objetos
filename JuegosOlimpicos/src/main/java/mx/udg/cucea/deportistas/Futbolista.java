
package mx.udg.cucea.deportistas;

public class Futbolista extends Deportista {
    private String posicion;
    private int numero;
    
    public Futbolista(String nombres, String apellidoPaterno, String pais, char rama) {
        super(nombres, apellidoPaterno, pais, rama);
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return("Futbolista -> " + nombres + " " + apellidoPaterno + " Pais: " + pais + " Rama: " + rama + " Numero: " + numero + " Posicion: " + posicion);
    }
}
