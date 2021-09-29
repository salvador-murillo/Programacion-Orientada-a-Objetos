package mx.udg.cucea.vehiculos;

public class Transporte {
    protected String placas; //
    protected String propietario; //
    private String marca;
    private String modelo;
    private int año; 
    private long numeroDeSerie; //
    private int numeroDePuertas;
    private long numeroDeMotor; //
    private String tipoDeCombustible;
    
    public Transporte(String placas, String propietario, 
            long numeroDeSerie, long numeroDeMotor){
        this.placas = placas;
        this.propietario = propietario;
        this.numeroDeSerie = numeroDeSerie;
        this.numeroDeMotor = numeroDeMotor;
    }
    
    public long getNumeroDeMotor() {
        return numeroDeMotor;
    }

    public void setNumeroDeMotor(long numeroDeMotor) {
        this.numeroDeMotor = numeroDeMotor;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public long getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(long numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }

    public String getTipoDeCombustible() {
        return tipoDeCombustible;
    }

    public void setTipoDeCombustible(String tipoDeCombustible) {
        this.tipoDeCombustible = tipoDeCombustible;
    }
    @Override
    public String toString(){
        return "placas: " + placas + ", propietario: " + propietario;
    }
    
}
