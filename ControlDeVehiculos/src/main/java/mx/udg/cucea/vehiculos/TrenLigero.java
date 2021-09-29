package mx.udg.cucea.vehiculos;

public class TrenLigero extends TransportePublico{
    private int numeroDeTren;
    private String sistemaDeManejo;
    private int numeroDeVagones;
    
    public TrenLigero(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor, String ruta) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor, ruta);
        setRuta(ruta);
    }
    
    @Override
    public void setRuta(String ruta){
        this.ruta = ruta;
        this.sistemaDeManejo = "antiguo";
        if (ruta.equals("Linea 3")){
            this.sistemaDeManejo = "nuevo";
        }
    }

    public int getNumeroDeTren() {
        return numeroDeTren;
    }

    public void setNumeroDeTren(int numeroDeTren) {
        this.numeroDeTren = numeroDeTren;
    }

    public String getSistemaDeManejo() {
        return sistemaDeManejo;
    }

    public void setSistemaDeManejo(String sistemaDeManejo) {
        this.sistemaDeManejo = sistemaDeManejo;
    }

    public int getNumeroDeVagones() {
        return numeroDeVagones;
    }

    public void setNumeroDeVagones(int numeroDeVagones) {
        this.numeroDeVagones = numeroDeVagones;
    }
    
    
}
