package mx.udg.cucea.olimpicos;

import java.util.ArrayList;
import java.util.Date;
import mx.udg.cucea.deportistas.Ciclista;
import mx.udg.cucea.deportistas.Clavadista;
import mx.udg.cucea.deportistas.Deportista;
import mx.udg.cucea.deportistas.Futbolista;
import mx.udg.cucea.deportistas.Luchador;

public class JuegosOlimpicos {


    public static void main(String[] args) {
        
        Futbolista f1 = new Futbolista("Neymar", "Junior", "Brazil", 'V');
        f1.setNumero(10);
        f1.setPosicion("Delantero");
        Date fechaNacimientoDeF1 = new Date(1990, 5, 20);//Creacion de objeto tipo fecha
        f1.setFechaDeNacimiento(fechaNacimientoDeF1); //Se asigna el objeto fecha al futbolista 1
        
        Clavadista c1 = new Clavadista("Wan", "Lee", "China", 'V');
        c1.setDisciplina("10 metros");
        
        Luchador luchador1 = new Luchador("Maria", "Perez", "España", 'F', 60);
        luchador1.setApellidoMaterno("Gonzalez");
        
        Ciclista ciclista1 = new Ciclista("Heidi", "Schultz", "Alemana", 'F');
        ciclista1.setDisciplina("Prueba de Ruta");
        
        ArrayList<Deportista> arregloDeDeportistas = new ArrayList<>();
        arregloDeDeportistas.add(c1);
        arregloDeDeportistas.add(luchador1);
        arregloDeDeportistas.add(f1); 
        arregloDeDeportistas.add(ciclista1);
        
        arregloDeDeportistas.forEach(deportista -> {
            //Para futbolista llama al metodo propio de futbolista (Polimorfismo, un objeto puede tomar diferentes resutlados dependiendo como es llamado.
            
            //Al mandar el objeto, java manda llamar al metodo toString() por defecto y regresa una representacion del objeto (Ver Documentacion)
            //Se sobreescribe el metodo toString()
            System.out.println(deportista); 
            /*if(deportista instanceOf Ciclista){
                Ciclista ciclista = (Ciclista) deportista;
                System.out.println("Soy un ciclista de tipo: " + ciclista.getDisciplina());
            }*/
        });           
    }
}
