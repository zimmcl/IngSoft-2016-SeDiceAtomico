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
		// TODO Auto-generated method stub

	}

	@Override
	public void on() {
		// TODO Auto-generated method stub

	}

	@Override
	public void off() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getBPM() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerObserver(BeatObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(BeatObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerObserver(BPMObserver o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(BPMObserver o) {
		// TODO Auto-generated method stub

	}

}
