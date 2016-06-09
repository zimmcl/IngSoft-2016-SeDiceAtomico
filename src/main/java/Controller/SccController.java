package main.java.Controller;

import main.java.Adapter.SccAdapter;
import main.java.Model.SccModelInterface;
import main.java.View.DJView;
import main.java.View.SccView;

public class SccController implements ControllerInterface {
	
	SccModelInterface model;
	DJView djview;
	SccView sccview;
	boolean isPaused = false;
	boolean ownView;

	public SccController(SccModelInterface model, boolean ownView){
		
		this.ownView = ownView;
		this.model = model;
		if(!ownView){		
			djview = new DJView(this, new SccAdapter(model));
			djview.createView();
	        djview.createControls();
			djview.disableStopMenuItem();
			djview.enableStartMenuItem();
		}else{
			sccview = new SccView(this, model);
			sccview.disableStopMenuItem();
			sccview.enableStartMenuItem();
			sccview.disablePauseButtonItem();
			
		}
        
		model.initialize();
	}
	
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		model.on();
		if(!ownView){
			djview.disableStartMenuItem();
			djview.enableStopMenuItem();
		}else{
			sccview.disableStartMenuItem();
			sccview.enableStopMenuItem();
			sccview.enablePauseButtonItem();
		}

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		model.off();
			if(!ownView){
			djview.disableStopMenuItem();
			djview.enableStartMenuItem();
		}else{
			sccview.disableStopMenuItem();
			sccview.enableStartMenuItem();
			sccview.disablePauseButtonItem();
		}
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
 	
 	public void setPause() {
 		if(!isPaused){
 			model.pause();
 		}else{
 			model.resume();
 		}
 			
 	}
 	

}
