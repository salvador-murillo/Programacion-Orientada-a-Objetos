package mx.udg.cucea.mp3tag.CustomFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class JTextFieldMP3 extends JTextField {
    
    Color customGreen = new Color(52, 72, 59);
    
    public JTextFieldMP3(int i){
        setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        setBackground(customGreen.brighter());
        if(i==0) { 
            setSize(350, 30);
        }else if(i==1) { 
            setSize(53, 30);
        }else{
            setSize(30, 30);
        }
    }
}
