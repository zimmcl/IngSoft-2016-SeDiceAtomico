package main.java.View;

import main.java.Controller.ControllerInterface;
import main.java.Model.BeatModelInterface;
import main.java.Model.SccModelInterface;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class SccView implements BPMObserver, BeatObserver {
	
	public SccView(ControllerInterface controller, SccModelInterface model){
		//IMPREMENTAR VISTA
	}

	@Override
	public void updateBeat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBPM() {
		// TODO Auto-generated method stub

	}

}
