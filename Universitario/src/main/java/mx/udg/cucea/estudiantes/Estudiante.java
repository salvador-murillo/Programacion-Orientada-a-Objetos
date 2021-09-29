package mx.udg.cucea.estudiantes;

import mx.udg.cucea.universitarios.Universitario;

public class Estudiante extends Universitario{
    private String carrera;
    private String centro;
    private String situacionSIIAU;
    private String nivel; // Licenciatura - Preparatoria
    private float promedio;
    private int creditosAdquiridos;
    
    private Estudiante(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono) {
        super(codigo, nombres, apellidoPaterno, genero, domicilio, telefono);
    }
    
    public Estudiante(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono, String carrera, String centro) {
        this(codigo, nombres, apellidoPaterno, genero, domicilio, telefono);
        this.carrera = carrera;
        this.centro = centro;
    }
    
    public void mostrarEstudiante(){
        
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getSituacionSIIAU() {
        return situacionSIIAU;
    }

    public void setSituacionSIIAU(String situacionSIIAU) {
        this.situacionSIIAU = situacionSIIAU;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getCreditosAdquiridos() {
        return creditosAdquiridos;
    }

    public void setCreditosAdquiridos(int creditosAdquiridos) {
        this.creditosAdquiridos = creditosAdquiridos;
    }
    
}
