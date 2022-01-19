package mx.udg.cucea.datos;

/**
 *
 * @author murillo
 */
public class Contacto {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronico;
    private long telefonoDeCasa;
    private long telefonoMovil;
    private long telefonoDeOficina;

    public Contacto(String nombres, long telefonoMovil) {
        this.nombres = nombres;
        this.telefonoMovil = telefonoMovil;
    }

    public long getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(long telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public long getTelefonoDeCasa() {
        return telefonoDeCasa;
    }

    public void setTelefonoDeCasa(long telefonoDeCasa) {
        this.telefonoDeCasa = telefonoDeCasa;
    }

    public long getTelefonoDeOficina() {
        return telefonoDeOficina;
    }

    public void setTelefonoDeOficina(long telefonoDeOficina) {
        this.telefonoDeOficina = telefonoDeOficina;
    }
    
    
}
