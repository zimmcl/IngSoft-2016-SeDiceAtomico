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
		
		//IMPREMENTAR CONTROLADOR
		this.model = model;
		djview = new DJView(this, new SccAdapter(model));
        djview.createView();
        djview.createControls();
		djview.disableStopMenuItem();
		djview.enableStartMenuItem();
		model.initialize();
	}
	
public SccController(SccModelInterface model, int i){
		
		//IMPREMENTAR CONTROLADOR
		this.model = model;
		sccview = new SccView(this, model);
        /*djview.createView();
        djview.createControls();
		djview.disableStopMenuItem();
		djview.enableStartMenuItem();
		*/
		model.initialize();
	}
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		sccview.disableStartMenuItem();
		sccview.enableStopMenuItem();
		//djview.disableStartMenuItem();
		//djview.enableStopMenuItem();

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
		sccview.disableStopMenuItem();
		sccview.enableStartMenuItem();
		//djview.disableStopMenuItem();
		//djview.enableStartMenuItem();
	}

	public void increaseBPM() {
        int speed = model.getSpeed();
        model.setSpeed(speed + 1);
	}
    
	public void decreaseBPM() {
        int speed = model.getSpeed();
        model.setSpeed(speed - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setSpeed(bpm);
	}

}
