package mx.udg.cucea.graficos;

import java.awt.Color;
import javax.swing.JTextField;

public class JTextFieldSB extends JTextField{
    Color customGreen = new Color(52, 72, 59);
    public JTextFieldSB(){
        setForeground(Color.WHITE);
        setBackground(customGreen.brighter());
    }
}
