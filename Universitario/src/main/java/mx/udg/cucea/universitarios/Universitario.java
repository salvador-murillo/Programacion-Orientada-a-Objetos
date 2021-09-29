package mx.udg.cucea.universitarios;

public class Universitario {
    private long codigo;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private char genero; // 'M' o 'F'
    private String correoElectronico;
    private String domicilio;
    private long telefono;

    public Universitario(long codigo, String nombres, String apellidoPaterno, char genero, String domicilio, long telefono) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.genero = genero;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }
    
    public void mostrarUniversitario(){
        System.out.println("Nombre: " + nombres + " " + apellidoPaterno + "\nCodigo: " + codigo);
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    
    
    
}
