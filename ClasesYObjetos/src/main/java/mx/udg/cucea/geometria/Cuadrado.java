package mx.udg.cucea.geometria;

public class Cuadrado extends Rectangulo{
    
    public Cuadrado(float lado){
        this(lado, lado);
    }
    
    //Constructor que manda llamar al constructor de la clase padre (Rectangulo)
    private Cuadrado(float lado1, float lado2){
        super(lado1, lado2);
    }
    @Override //Mismo metodo pero diferente funcion, sobreescritura de metodos
    public void escribeDetalles(){
        System.out.println("Cuadrado de lado: " + lado1 +
                           "\nPerimetro = " + calcularPerimetro() +
                           "\nArea = " + calcularArea());
    }
}
