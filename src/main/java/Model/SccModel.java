package main.java.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import main.java.Class.Regulador;
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
	Regulador regulador;
	
	public SccModel(){
		initialize();		
	}
	

	@Override
	public void initialize() {
		metros = 0;
		currentTime=0;
		currentSpeed = 0;
	}

	@Override
	public void on() {
		dateInicial = new Date();
		currentSpeed=1;
		thread = new Thread(this);
		thread.start();
		setSpeed(40);
		regulador = new Regulador(this);
		
		
	}

	@Override
	public void off() {
		setSpeed(0);
		
		currentTime += getTiempo(dateInicial);
		System.out.println("Tiempo Total: " + currentTime +" ms. Metros Recorridos: "+ getMetros());
		/*Guardar archivo en registro
		-
		-
		*/
		
		
	}
	
	public void pause() {
		lastSpeed = targetSpeed;
		setSpeed(0);
		currentTime += getTiempo(dateInicial);
		
		
	}
	public void resume(){
		dateInicial = new Date();
		currentSpeed=1;
		
		
		thread = new Thread(this);
		thread.start();
		
		setSpeed(lastSpeed);
		
	}

	@Override
	public void setSpeed(int speed) {
		if(speed>=0){
			targetSpeed = speed;
		}
	}
	
	public void modifyCurrentSpeed(int n){
		if(n<0 && (currentSpeed+n)<0){
			return;
		}
		currentSpeed = currentSpeed +n;
	}
	

	@Override
	public int getSpeed() {
		return currentSpeed;
	}
	public int getTargetSpeed(){
		return targetSpeed;
	}
	
	public String CaloriasConsumidas(){
		
		
		return null;
				
	}


	@Override
	public void run(){
		int n=0;
		boolean detener=false;
		
		while(!detener){			
				try {
					if(getSpeed()>=1){
						double time = (600/(double)currentSpeed);
						//System.out.println(time+" "+n);
						TimeUnit.MILLISECONDS.sleep(( (long) time ));
						n++;
						metros+=0.01;
						if(n>=100){
							
							notifyBeatObservers();
							n=0;							
						}						
					}
					else{
						detener = true;
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
		System.out.println("Sonido.");
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
	
	public double getMetros(){
		
		double n = 100*metros;
		n = (int) n;
		n = n/100;
		return n;
	}
	//public void increaseSpeed(){
	//	if(currentSpeed==targetSpeed){
	//		setSpeed(targetSpeed+1);
	//	}
		
	//}
	
	//public void decreaseSpeed(){
	//	if(currentSpeed==targetSpeed){
	//		setSpeed(targetSpeed-1);
	//	}
		
	//}
}
