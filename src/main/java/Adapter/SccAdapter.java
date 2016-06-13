package main.java.Adapter;

import main.java.Model.BeatModelInterface;
import main.java.Model.SccModelInterface;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class SccAdapter implements BeatModelInterface {
	
	SccModelInterface scc;
	 
	public SccAdapter(SccModelInterface scc) {
		this.scc = scc;
	}

	@Override
	public void initialize() {
		scc.initialize();

	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		scc.on();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		scc.off();
	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		scc.setSpeed(bpm);
	}

	@Override
	public int getBPM() {
		// TODO Auto-generated method stub
		return scc.getSpeed();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		scc.registerObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		scc.removeObserver(o);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		scc.registerObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		scc.removeObserver(o);
	}

}
