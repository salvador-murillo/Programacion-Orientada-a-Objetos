package mx.udg.cucea.empleados;

public class Profesor extends Empleado {
    private String situacionSIIAU;
    private String gradoAcademico; // Licenciatura - Maestria - Doctorado
    private int materiasAsignadas;
    
    private Profesor(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono, String puesto, String departamento) {
        super(codigo, nombres, apellidoPaterno, genero, domicilio, telefono, puesto, departamento);
    }
    
    public Profesor(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono, String puesto, String departamento, String gradoAcademico, String situacionSIIAU) {
        this(codigo, nombres, apellidoPaterno, genero, domicilio, telefono, puesto, departamento);
        this.gradoAcademico = gradoAcademico;
        this.situacionSIIAU = situacionSIIAU;
    }

    public String getSituacionSIIAU() {
        return situacionSIIAU;
    }

    public void setSituacionSIIAU(String situacionSIIAU) {
        this.situacionSIIAU = situacionSIIAU;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public int getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(int materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }
    
    
    

}
