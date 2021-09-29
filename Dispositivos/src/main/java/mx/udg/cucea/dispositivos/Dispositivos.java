package mx.udg.cucea.dispositivos;

import mx.udg.cucea.audio.Audio;

/**
 *
 * @author murillo
 */
public class Dispositivos {

    public static void main(String[] args) {
        Audio dispositivoAudio1 = new Audio(2008, 80, "iPod Video", "Apple", "Plata");
        dispositivoAudio1.setMaterial("Aluminio");
        dispositivoAudio1.setIsHighRes(false);
        dispositivoAudio1.mostrarDetallesAudio();
    }
    
}
