package mx.udg.cucea.mp3tag.CustomFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class JLabelMP3 extends JLabel {
    
    public JLabelMP3(String text, int i){
        setText(text);
        setFont(new Font("Lucida Grande", Font.BOLD, 15));
        setForeground(Color.WHITE);
        if(i==0) { 
            setSize(50, 50);
        }else { 
            setSize(150, 50);
        }
    }
}
