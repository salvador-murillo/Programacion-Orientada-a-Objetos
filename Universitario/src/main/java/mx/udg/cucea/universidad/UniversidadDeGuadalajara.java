package mx.udg.cucea.universidad;

import mx.udg.cucea.estudiantes.Estudiante;


public class UniversidadDeGuadalajara {
    
  
    public static void main(String[] args) {
        //Creacion de Objetos
        Estudiante estudiante1 = new Estudiante(220277653, "Salvador", "Murillo", 'M', "Pablo Bolio Ponce 21", 327374757 , "Lic. Tecnologias de la Informacion", "CUCEA");
        estudiante1.setNivel("Licenciatura");
        estudiante1.setSituacionSIIAU("Activo");
        estudiante1.mostrarUniversitario();
    }
    
}
