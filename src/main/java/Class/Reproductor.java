package main.java.Class;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Reproductor {

	Clip sonido;
	
	public Reproductor(){
	}
	
	
	
	public void turnOff(){
		sonido.close();
		carga();
	}
	
	
	public void pause(){
		sonido.stop();
	}
	
	public void play(){
		sonido.start();
		sonido.loop(sonido.LOOP_CONTINUOUSLY);
	}
	
	public void carga(){
		try{
			sonido = AudioSystem.getClip();
			AudioInputStream iS = AudioSystem.getAudioInputStream(getClass().getResource("/musica/MusicaElevador.wav"));
	    	sonido.open(iS);
		}catch(UnsupportedAudioFileException | LineUnavailableException | IOException e){
			System.out.println(e);
		}
	}
	
	
	
}
