package mx.udg.cucea.deportistas;

import java.util.Date;


public class Deportista {
    protected String nombres;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected Date fechaDeNacimiento;
    protected String pais;
    protected char rama; // F o V
    
    public Deportista(String nombres, String apellidoPaterno, String pais, char rama){
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.pais = pais;
        this.rama = rama;
    }

    public char getRama() {
        return rama;
    }

    public void setRama(char rama) {
        this.rama = rama;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString(){
        return(nombres + " " + apellidoPaterno + " Pais: " + pais + " Rama: " + rama);
    }
    
}
