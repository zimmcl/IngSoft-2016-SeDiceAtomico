package main.java.Controller;

import main.java.Adapter.SccAdapter;
import main.java.Model.SccModelInterface;
import main.java.View.DJView;
import main.java.View.SccView;

public class SccController implements ControllerInterface {
	
	SccModelInterface model;
	DJView djview;
	SccView sccview;

	public SccController(SccModelInterface model){
		this.model = model;
		djview = new DJView(this,new SccAdapter(model));
        djview.createView();
        djview.createControls();
		djview.disableStopMenuItem();
		djview.enableStartMenuItem();
		model.initialize();
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub

	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub

	}

}
