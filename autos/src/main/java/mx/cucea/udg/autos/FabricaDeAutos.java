package mx.cucea.udg.autos;

public class FabricaDeAutos {

    public static void main(String[] args){
        
        Auto coche1 = new Auto();
        coche1.marca = "Volkswagen";
        Auto.modelo = "Passat"; //Se le coloca el modelo al atributo como tal de la clase auto
        coche1.year = 2021;
        coche1.numeroDePuertas = 4;
        
        Auto coche2 = new Auto();
        coche2.marca = "Nissan";
        Auto.modelo = "Altima";
        coche2.year = 2016;
        coche2.numeroDePuertas = 4;
        
        Auto coche3 = new Auto();
        coche3.marca = "Honda";
        Auto.modelo = "Civic";
        coche3.year = 2019;
        coche3.numeroDePuertas = 2;

        coche1.escribeAuto();
        coche2.escribeAuto();
        coche3.escribeAuto();
    }
    
}
