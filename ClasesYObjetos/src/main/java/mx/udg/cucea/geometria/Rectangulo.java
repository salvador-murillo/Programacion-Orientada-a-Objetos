package mx.udg.cucea.geometria;

public class Rectangulo extends Cuadrilatero {
    //Atributos
    float base, altura; //No necesarios dado el constructor de la super clase Cuadrilatero

    //Constructor Privado a la clase Rectangulo (lo ocultamos, solo visible a la misma clase (Encapsulamiento))
    private Rectangulo(float a, float b, float c, float d){
        super(a, b, c, d);
    }

    public Rectangulo(float b, float a){ //Constructor con 2 parametros, cuando se crean objetos se haran con este constructor
        this(b,b,a,a); //this() manda llamar al constructor de arriba, le pasa los 4 parametros requeridos
    }

    //Metodos
    public float calcularArea(){
        return lado1 * lado3;
    }

}
