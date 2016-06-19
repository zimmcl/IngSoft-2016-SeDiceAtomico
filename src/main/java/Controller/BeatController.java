package main.java.Controller;

import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;
import main.java.View.DJView;
import main.java.View.MultiplesView;

public class BeatController implements ControllerInterface {
	BeatModelInterface model;
	public DJView view;
   
	public BeatController(BeatModelInterface model) {
		this.model = model;
		view = new DJView(this, model);
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
  
	/**
	 * Constructor creado para el uso de MultiplesView
	 */
	public BeatController(BeatModel model, MultiplesView view) {
		 
		this.view = view;
 
		this.view.disableStopMenuItem();
 
		this.view.enableStartMenuItem();
 
		this.model = model;
 
		this.model.initialize();
 
	}
	
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
	}
    
	public void decreaseBPM() {
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
  	}
  
 	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}
}
