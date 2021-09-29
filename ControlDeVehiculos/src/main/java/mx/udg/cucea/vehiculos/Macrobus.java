package mx.udg.cucea.vehiculos;

public class Macrobus extends TransportePublico {
    
    private String tipo; // express o parador
    private int numeroDeRemolques;
    private int numeroDeEjes;
    private int numeroDeEstaciones;
    
    public Macrobus(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor, String ruta) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor, ruta);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumeroDeRemolques() {
        return numeroDeRemolques;
    }

    public void setNumeroDeRemolques(int numeroDeRemolques) {
        this.numeroDeRemolques = numeroDeRemolques;
    }

    public int getNumeroDeEjes() {
        return numeroDeEjes;
    }

    public void setNumeroDeEjes(int numeroDeEjes) {
        this.numeroDeEjes = numeroDeEjes;
    }

    public int getNumeroDeEstaciones() {
        return numeroDeEstaciones;
    }

    public void setNumeroDeEstaciones(int numeroDeEstaciones) {
        this.numeroDeEstaciones = numeroDeEstaciones;
    }
    
}
