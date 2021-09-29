
package mx.udg.cucea.vehiculos;

import java.awt.Color;

public class Automovil extends Transporte{
    
    private Color color;
    private String transmision; //
    private int numeroDeCilindros;
    
    private Automovil(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor) {
        super(placas, propietario, numeroDeSerie, numeroDeMotor);
    }
    public Automovil(String placas, String propietario, long numeroDeSerie, 
            long numeroDeMotor, String transmision) {
        this(placas, propietario, numeroDeSerie, numeroDeMotor);
        this.transmision = transmision;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumeroDeCilindros() {
        return numeroDeCilindros;
    }

    public void setNumeroDeCilindros(int numeroDeCilindros) {
        this.numeroDeCilindros = numeroDeCilindros;
    }
    
}
