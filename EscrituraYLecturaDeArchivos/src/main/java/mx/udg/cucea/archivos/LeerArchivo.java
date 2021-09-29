package mx.udg.cucea.archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeerArchivo {
    public static void main(String[] args) {
        //Clase File para leer archivos en OS
        File archivo = new File("EscrituraYLecturaDeArchivos/src/archivo.txt");
        try {

            //Creacion de Objeto Scanner, lee el objeto 'archivo' previamente declarado
            Scanner lectorDeArchivo = new Scanner(archivo);
            //Ciclo para que siga leyendo por medio del metodo en Scanner (hasNextLine)
            while(lectorDeArchivo.hasNextLine()){
                //Lee linea por linea e imprime en consola
                System.out.println(lectorDeArchivo.nextLine());
            }
            //Liberacion del buffer
            lectorDeArchivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No pude leer el archivo:" + ex.getMessage());
        } catch (NoSuchElementException ex){
            System.out.println("No pude leer la linea:" + ex.getMessage());
        }
    }
}
