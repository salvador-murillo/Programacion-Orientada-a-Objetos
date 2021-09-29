package mx.udg.cucea.vehiculos;

import java.awt.Color;

public class Motocicleta extends Transporte{
    private Color color;
    private String transmision; //
    private int numeroDeCilindros;
    private int potencia;
    private String tipoDeLlantas;
    
    private Motocicleta(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor);
    }
    public Motocicleta(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor, int potencia) {
        this(placas, propietario, numeroDeSerie, numeroDeMotor);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipoDeLlantas() {
        return tipoDeLlantas;
    }

    public void setTipoDeLlantas(String tipoDeLlantas) {
        this.tipoDeLlantas = tipoDeLlantas;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public int getNumeroDeCilindros() {
        return numeroDeCilindros;
    }

    public void setNumeroDeCilindros(int numeroDeCilindros) {
        this.numeroDeCilindros = numeroDeCilindros;
    }
    
}
