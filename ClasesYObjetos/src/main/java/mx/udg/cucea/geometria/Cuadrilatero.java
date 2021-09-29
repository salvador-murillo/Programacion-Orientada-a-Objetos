package mx.udg.cucea.geometria;

public class Cuadrilatero {
    protected float lado1, lado2, lado3, lado4;

    //Constructor 
    public Cuadrilatero(float l1, float l2, float l3, float l4){
        lado1 = l1;
        lado2 = l2;
        lado3 = l3;
        lado4 = l3;
    }

    //Metodos
    public float calcularPerimetro(){
        return lado1 + lado2 + lado3 + lado4;
    }

    public void escribeDetalles(){
        System.out.println("Cuadrilatero \nL1: " + lado1 + " L2: " + lado2 + " L3: " + lado3 +  " L4: " + lado4 +
                           "\nPerimetro = " + calcularPerimetro());
    }
    
}