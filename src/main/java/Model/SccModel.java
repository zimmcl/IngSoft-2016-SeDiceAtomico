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
	double targetSpeed;							//Velocidad Objetivo
	double currentSpeed; 							//Velocidad Actual de la cinta		
	Thread thread;
	Date dateInicial;
	double metros;
	double CurrentTime;
	double BeforeSpeed;

	@Override
	public void initialize() {
		
		
		metros = 0;
		CurrentTime=0;
		currentSpeed = 60;
		
		
		
				

	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
		dateInicial = new Date();
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
		CurrentTime += getTiempo(dateInicial);
		System.out.println("Tiempo: " + CurrentTime);
		/*Guardar archivo en registro
		-
		-
		*/
		//initialize();
		
		
		

	}
	
	public void pause() {
		BeforeSpeed = targetSpeed;
		setSpeed(0);
		CurrentTime += getTiempo(dateInicial);
		
		
	}
	public void resume(){
		dateInicial = new Date();
		setSpeed(BeforeSpeed);
		thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void setSpeed(double beforeSpeed) {
		targetSpeed = beforeSpeed;
		
		while((int)currentSpeed!=(int)targetSpeed){
			try {
				Thread.sleep(2);
				if(currentSpeed>targetSpeed)
					currentSpeed--;
				else
					currentSpeed++;
				notifyBPMObservers();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
						double time;
						if (currentSpeed==0)
							time=1;
						else
							time = (1/currentSpeed);
						//System.out.println(60*time);
						TimeUnit.MILLISECONDS.sleep((long) ((long) 60000*time));
						metros++;
						notifyBeatObservers();
						
					}
					else
						interrupted = true;
						
				} catch (InterruptedException e) {
					break;
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
	}
	
	private int getTiempo(Date time){
		Date timeFinal = new Date();
		return (int) (timeFinal.getTime() - time.getTime());
	}

	

}
