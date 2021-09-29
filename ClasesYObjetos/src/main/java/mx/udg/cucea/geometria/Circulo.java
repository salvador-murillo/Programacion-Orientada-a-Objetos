package mx.udg.cucea.geometria;

public class Circulo {
    //Atributos
    private float radio;
    
    //Constructor inicializando atributos en especifico
    public Circulo(float r){
        radio = r;
    }

    //Metodos
    float calcularPerimetro(){
        return 2 * 3.1416f * radio;
    }
    float calcularArea(){
        return 3.1416f * radio * radio;
    }
    
    public void escribeDetalles(){
        System.out.println("Circulo Radio: " + radio +
                           " Perimetro: " + calcularPerimetro() +
                           " Area: " + calcularArea());
    }


    
}
