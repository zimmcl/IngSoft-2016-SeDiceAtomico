package main.java.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;
import java.util.concurrent.TimeUnit;


import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class SccModel implements SccModelInterface, Runnable {
	
	//IMPLEMENTAR MODELO
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	
	//Velocidad medida en metros por minuto
	int targetSpeed;							//Velocidad Objetivo
	int currentSpeed; 							//Velocidad Actual de la cinta		
	int lastSpeed;
	Thread thread;
	Date dateInicial;
	double metros;
	double currentTime;
	

	@Override
	public void initialize() {
		metros = 0;
		currentTime=0;
		currentSpeed = 0;
	}

	@Override
	public void on() {
		dateInicial = new Date();
		currentSpeed=5;
		thread = new Thread(this);
		thread.start();
		setSpeed(40);
	}

	@Override
	public void off() {
		setSpeed(0);
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentTime += getTiempo(dateInicial);
		System.out.println("Tiempo: " + currentTime +" ms");
		/*Guardar archivo en registro
		-
		-
		*/
		initialize();
		
		
		

	}
	
	public void pause() {
		lastSpeed = targetSpeed;
		setSpeed(0);
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentTime += getTiempo(dateInicial);
		
		
	}
	public void resume(){
		dateInicial = new Date();
		currentSpeed=5;
		setSpeed(lastSpeed);
		
		thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void setSpeed(int speed) {
		targetSpeed = speed;
		
		while(currentSpeed!=targetSpeed){
			try {
				Thread.sleep(100);
				if(currentSpeed>targetSpeed)
					currentSpeed--;
				else
					currentSpeed++;
				notifyBPMObservers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	
		
	}

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return currentSpeed;
	}
	
	public String CaloriasConsumidas(){
		
		Date dateFinal = new Date();
		return null;
		
		
		
	}


	@Override
	public void run(){
		boolean interrupted=false;
		
		while(!interrupted){
			
				try {
					if(getSpeed()>=1){
						int time = (60000/currentSpeed);
						 
						System.out.println(time);
						TimeUnit.MILLISECONDS.sleep(( time ));
						metros++;
						System.out.println(60*time);

						notifyBeatObservers();
						
					}
					else{
						interrupted = true;

					}
						
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}	
		
	}
	
	
	
	
	
	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);

	}
	

	@Override
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}
	
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
		///-----------------------------------------------
		System.out.println("Sonido. Metros: "+(int) metros);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}
	
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
			
		}
		System.out.println("Speed: " + currentSpeed);
	}
	
	private int getTiempo(Date time){
		Date timeFinal = new Date();
		return (int) (timeFinal.getTime() - time.getTime());
	}
	
	public void increaseSpeed(){
	//	if(currentSpeed==targetSpeed){
	//		setSpeed(targetSpeed+1);
	//	}
		
	}
	
	public void decreaseSpeed(){
	//	if(currentSpeed==targetSpeed){
	//		setSpeed(targetSpeed-1);
	//	}
		
	}
	
	

	

}
