package main.java.Model;

import java.util.*;

import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class HeartModel implements HeartModelInterface, Runnable {
	
	//Modifico la clase para que se pueda instanciar una �nica vez
	private static HeartModel Instancia;
	//Llevar� la cuenta de los intentos de instanciaci�n
	private static int intentos=0;
	//
	ArrayList<BeatObserver>beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	int time = 1000;
    int bpm = 90;
	Random random = new Random(System.currentTimeMillis());
	Thread thread;

	public HeartModel() {
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		int lastrate = -1;

		for(;;) {
			int change = random.nextInt(10);
			if (random.nextInt(2) == 0) {
				change = 0 - change;
			}
			int rate = 60000/(time + change);
			if (rate < 120 && rate > 50) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBPMObservers();
				}
			}
			try {
				Thread.sleep(time);
			} catch (Exception e) {}
		}
	}
	/*
	 * M�todo modificado:
	 * Devuelve el n�mero de intentos de instanciaci�n.
	 */
	public int getHeartRate() {
		return intentos;
		//return 60000/time;
	}

	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

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
	}

	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}

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
	
	/*
	 *M�todo creado:
	 *Devuelve la �nica instancia HeartModel.
	 *Si no existe la crea.
	 *Si ya existe suma 1 a intentos.
	 */
	public static HeartModel getInstancia(){
		if(Instancia==null){
			Instancia= new HeartModel();
			intentos+=1;
		}else intentos+=1;
		return Instancia;
	}
}
