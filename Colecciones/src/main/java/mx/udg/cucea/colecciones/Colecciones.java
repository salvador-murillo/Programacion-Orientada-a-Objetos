package mx.udg.cucea.colecciones;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author murillo
 */
public class Colecciones {

    public static void main(String[] args) {
        // <TipoDeDato> "Generics" sirve para indicarle el tipo de dato a almacenar 
        ArrayList<String> arregloDeDatos = new ArrayList();
        System.out.println("Tamaño arreglo: " + arregloDeDatos.size());
        arregloDeDatos.add("Universidad"); //Indicice 0
        arregloDeDatos.add("de"); //Indicice 1
        arregloDeDatos.add("Guadalajara"); //Indicice 2
        
        System.out.println("Tamaño arreglo: " + arregloDeDatos.size());
        
        //System.out.println(arregloDeDatos.get(2)); //Muestra "Guadalajara"
        
        for(int i = 0; i < arregloDeDatos.size(); i++){
              System.out.println(arregloDeDatos.get(i));
        }
        
        //Elimina por medio de indice
        arregloDeDatos.remove(0); 
        
        //Operador Funcional (for)
        arregloDeDatos.forEach(dato -> {
            System.out.println(dato);
        });
        
        //Elimina por medio de cadena (si hubiera)
        arregloDeDatos.remove("de"); 
        
        //Usado para colecciones, se coloca el tipo de dato contenido en el arreglo
        for (String dato : arregloDeDatos){
            System.out.println(dato);
        }
        //Limpia el arreglo
        arregloDeDatos.clear();
        System.out.println("Size arregloDeDatos: " + arregloDeDatos.size());
        
        //HashSet al usar Set los valores duplicados los ignora
        HashSet<String> juegoDeDatos = new HashSet<>();
        System.out.println("\nHashSet Size juegoDeDatos: " + juegoDeDatos.size());
        juegoDeDatos.add("hola");
        System.out.println("Se añade 'hola' Size: " + juegoDeDatos.size());
        juegoDeDatos.add("hola");
        System.out.println("Se añade 'hola' Size: " + juegoDeDatos.size());
        juegoDeDatos.add("hola");
        System.out.println("Se añade 'hola' Size: " +juegoDeDatos.size());
        juegoDeDatos.add("adios");
        System.out.println("Se añade 'adios' Size: " +juegoDeDatos.size());
        
        //ArrayList al usar List los valores duplicados los toma en cuenta
        ArrayList<String> juegoDeDatosArray = new ArrayList<>();
        System.out.println("\nArrayList Size juegoDeDatos: " + juegoDeDatosArray.size());
        juegoDeDatosArray.add("hola");
        System.out.println("Se añade 'hola' Size: " + juegoDeDatosArray.size());
        juegoDeDatosArray.add("hola");
        System.out.println("Se añade 'hola' Size: " + juegoDeDatosArray.size());
        juegoDeDatosArray.add("hola");
        System.out.println("Se añade 'hola' Size: " +juegoDeDatosArray.size());
        juegoDeDatosArray.add("adios");
        System.out.println("Se añade 'adios' Size: " +juegoDeDatosArray.size());
    }
}
