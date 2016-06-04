package main.java.Model;

import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public interface SccModelInterface {
	
	void initialize();
	  
	void on();
  	void off();
	
	void pause();
	void resume();
  
	void setSpeed(int speed);
  	int getSpeed();
	
	//void increaseSpeed();
	
	//void decreaseSpeed();
  
	void registerObserver(BeatObserver o);
  	void removeObserver(BeatObserver o);
  	void registerObserver(BPMObserver o);
  	void removeObserver(BPMObserver o);

	

}
