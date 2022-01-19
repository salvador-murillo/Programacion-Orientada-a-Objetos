package mx.udg.cucea.mp3tag.datos;

import java.io.File;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;

public class LeerArchivoMP3 extends MP3File{
    
    private File archivoSeleccionado;
    
    public void leerFiles(File archivoSeleccionado){
        
        this.archivoSeleccionado = archivoSeleccionado;
    }
    
    
    
}
