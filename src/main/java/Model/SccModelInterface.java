package main.java.Model;

import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public interface SccModelInterface {
	
	void initialize();
	  
	void on();
  
	void off();
  
	void setSpeed(double speed);
  
	double getSpeed();
  
	void registerObserver(BeatObserver o);
  
	void removeObserver(BeatObserver o);
  
	void registerObserver(BPMObserver o);
  
	void removeObserver(BPMObserver o);

	

}
