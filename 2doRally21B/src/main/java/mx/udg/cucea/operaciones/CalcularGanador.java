package mx.udg.cucea.operaciones;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcularGanador {
    
    private int res1, res2;
    private String nombreGanador;
    
    public String ObtenerResultado(JLabel equipo1LB, JTextField equipo1TF, JLabel equipo2LB, JTextField equipo2TF){
        res1 = Integer.parseInt(equipo1TF.getText());
        res2 = Integer.parseInt(equipo2TF.getText());
        if (res1 > res2) {
            nombreGanador = equipo1LB.getText();
        } else {
            nombreGanador = equipo2LB.getText();
        }
        return nombreGanador;
    }
}
