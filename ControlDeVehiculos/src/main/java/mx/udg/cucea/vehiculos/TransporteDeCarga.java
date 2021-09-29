package mx.udg.cucea.vehiculos;

public class TransporteDeCarga extends Transporte{
    private int toneladas; //
    private String tipoDeCarga; //    // gas, mercancías, alimentos, construccion...
    private String empresa; //
    private int numeroDeRemolques; //
    private int numeroDeEjes;
    private int cilindraje;
    private int numeroDeCabinas;
    private int numeroDeFilas;
    
    private TransporteDeCarga(String placas, String propietario, 
            long numeroDeSerie, long numeroDeMotor) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor);
    }
    public TransporteDeCarga(String placas, String propietario, 
            long numeroDeSerie, long numeroDeMotor, int toneladas,
            String tipoDeCarga, String empresa, int numeroDeRemolques) {
        this(placas, propietario, numeroDeSerie, numeroDeMotor);
        this.toneladas = toneladas;
        this.tipoDeCarga = tipoDeCarga;
        this.empresa= empresa;
        setNumeroDeRemolques(numeroDeRemolques);
    }

    public int getNumeroDeRemolques() {
        return numeroDeRemolques;
    }

    public void setNumeroDeRemolques(int numeroDeRemolques) {
        this.numeroDeRemolques = numeroDeRemolques;
        if(this.numeroDeRemolques == 1){
            numeroDeCabinas = 1;
        } 
        else if(this.numeroDeRemolques >= 2){
            numeroDeCabinas = 2;
        }
    }

    public int getToneladas() {
        return toneladas;
    }

    public void setToneladas(int toneladas) {
        this.toneladas = toneladas;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getNumeroDeEjes() {
        return numeroDeEjes;
    }

    public void setNumeroDeEjes(int numeroDeEjes) {
        this.numeroDeEjes = numeroDeEjes;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getNumeroDeCabinas() {
        return numeroDeCabinas;
    }

    public int getNumeroDeFilas() {
        return numeroDeFilas;
    }

    public void setNumeroDeFilas(int numeroDeFilas) {
        this.numeroDeFilas = numeroDeFilas;
    }
    
}
