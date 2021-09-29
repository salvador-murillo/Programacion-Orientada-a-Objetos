
package mx.udg.cucea.deportistas;


public class Ciclista extends Deportista {
    private String disciplina;
    
    public Ciclista(String nombres, String apellidoPaterno, String pais, char rama) {
        super(nombres, apellidoPaterno, pais, rama);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
}
