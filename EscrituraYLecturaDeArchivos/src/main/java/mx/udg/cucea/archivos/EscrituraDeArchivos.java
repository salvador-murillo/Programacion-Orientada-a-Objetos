package mx.udg.cucea.archivos;

import java.io.FileWriter;
import java.io.IOException;

public class EscrituraDeArchivos {
   public static void main(String[] args) {
        //Try-Catch para que en caso de que no pueda crear el archivo nos arroje un mensaje del porque
        try {
            //Creacion de objeto para crear archivo -- Se le da nombre relativo al projecto
            FileWriter escritorDeArchivo = new FileWriter("EscrituraYLecturaDeArchivos/src/archivo.txt");
            escritorDeArchivo.append("Hola, bienvenidos");
            //Agrega salto de linea independiente el sistema operativo
            escritorDeArchivo.append(System.lineSeparator());
            escritorDeArchivo.append("Estamos en la clase de POO-CUCEA");
            
            //Liberacion del buffer
            escritorDeArchivo.close();            
        } catch (IOException ex) { //Creacion de exepcion y obtener mensaje
            System.out.println("No pude escribir el archivo:" + ex.getMessage());
        } 
    }   
}
