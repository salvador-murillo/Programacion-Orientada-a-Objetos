package mx.udg.cucea.vialidad;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import mx.udg.cucea.datos.EscritorArchivoTransporte;
import mx.udg.cucea.vehiculos.Automovil;
import mx.udg.cucea.vehiculos.Macrobus;
import mx.udg.cucea.vehiculos.Motocicleta;
import mx.udg.cucea.vehiculos.Transporte;
import mx.udg.cucea.vehiculos.TransporteDeCarga;
import mx.udg.cucea.vehiculos.TransportePublico;
import mx.udg.cucea.vehiculos.TrenLigero;

public class Vialidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Transporte> vehiculos = new ArrayList<>();
        // crear un montón de vehículos de todos los tipos
        // agregarlos al arraylist (vehiculos)
        // sobreescriban el método toString() en las clases que necesiten chofer
        // mediante un ciclo , imprimir en pantalla placas, propietario y
        // el chofer(si aplica)

        Automovil auto1 = new Automovil("12DAF", "Jorge Perez", 98765, 54321, "Manual");
        vehiculos.add(auto1);

        Macrobus macro1 = new Macrobus("JDK2432", "Gobierno de Guadalajara", 534232, 72648289, "Express");
        macro1.setChofer("Juan Lopez");
        vehiculos.add(macro1);

        Motocicleta moto1 = new Motocicleta("JAM9873", "Diana Gonzales", 43211, 57374632, 120);
        vehiculos.add(moto1);

        TransporteDeCarga transporteCarga1 = new TransporteDeCarga("FED3214", "Diego Trujillo", 873632, 2342242, 5,
                "Alimentos", "SuKarne", 2);
        vehiculos.add(transporteCarga1);

        TransportePublico transporteP1 = new TransportePublico("PUB3213", "Jorge Gonzalez", 548372, 3221345, "TR-01");
        transporteP1.setChofer("Mauricio Camarena");
        vehiculos.add(transporteP1);

        TrenLigero tren1 = new TrenLigero("TRA834", "SITEUR", 762313, 87716322, "Linea 1");
        tren1.setChofer("Magdalena Arreola");
        vehiculos.add(tren1);

        vehiculos.forEach(vehicles -> {
            // System.out.println(vehicles);
            try {
                // Creacion de objeto eat de tipo filewriter
                EscritorArchivoTransporte eat = new EscritorArchivoTransporte(macro1);
                // Llamada al metodo escribirArchivo
                eat.escribirArchivo();
                eat.close();
            } catch (IOException ex) {
                System.out.println("No pude escribir el archivo: " + ex.getMessage());
            }
        });

        // Ejemplo de EscritorArchivoTransporte
        // //Creacion de objeto automovil1 de tipo Automovil
        // Automovil automovil1 = new Automovil("ABCD123", "Juan Perez", 123, 456,
        // "Manual");
        // automovil1.setMarca("VW");
        // automovil1.setModelo("Jetta");
        // automovil1.setAño(2020);
        // automovil1.setTipoDeCombustible("Diesel");
        // automovil1.setNumeroDePuertas(4);
        // automovil1.setColor(Color.yellow);
        // automovil1.setNumeroDeCilindros(8);

        // try {
        // //Creacion de objeto eat de tipo filewriter
        // EscritorArchivoTransporte eat = new EscritorArchivoTransporte(automovil1);
        // //Llamada al metodo escribirArchivo
        // eat.escribirArchivo();
        // eat.close();
        // } catch (IOException ex) {
        // System.out.println("No pude escribir el archivo: " + ex.getMessage());
        // }
    }

}
