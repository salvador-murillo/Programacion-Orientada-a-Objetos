package mx.udg.cucea.deportistas;


public class Clavadista extends Deportista {
    private String disciplina;
    
    
    public Clavadista(String nombres, String apellidoPaterno, String pais, char rama) {
        super(nombres, apellidoPaterno, pais, rama);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
}
