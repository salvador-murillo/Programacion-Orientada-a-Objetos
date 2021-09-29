package mx.cucea.udg.autos;

public class Auto {
    int numeroDePuertas;
    String marca;
    static String modelo;
    int year;
    
    public void escribeAuto(){
        System.out.println("El coche tiene: " + numeroDePuertas + " puertas y es de la marca " + marca + " y de modelo " + modelo + " y fue fabricado en " + year);
    }
}
