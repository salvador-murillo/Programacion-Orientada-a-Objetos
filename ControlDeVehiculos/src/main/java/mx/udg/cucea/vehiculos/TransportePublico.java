package mx.udg.cucea.vehiculos;

public class TransportePublico extends Transporte{
    
    protected String ruta; //
    private int cantidadMaximaDePasajeros;
    private String chofer;
    private int numeroDeUnidad;
    private int costo;
    
    private TransportePublico(String placas, String propietario, 
            long numeroDeSerie, long numeroDeMotor) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor);
    }
    public TransportePublico(String placas, String propietario, 
            long numeroDeSerie, long numeroDeMotor, String ruta) {
        this(placas, propietario, numeroDeSerie, numeroDeMotor);
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCantidadMaximaDePasajeros() {
        return cantidadMaximaDePasajeros;
    }

    public void setCantidadMaximaDePasajeros(int cantidadMaximaDePasajeros) {
        this.cantidadMaximaDePasajeros = cantidadMaximaDePasajeros;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public int getNumeroDeUnidad() {
        return numeroDeUnidad;
    }

    public void setNumeroDeUnidad(int numeroDeUnidad) {
        this.numeroDeUnidad = numeroDeUnidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getCostoConMiPasaje(){
        return costo / 2;
    }

    @Override
    public String toString(){
        return "placas: " + placas + ", propietario: " + propietario + ", chofer: " + chofer;
    }
    
}
