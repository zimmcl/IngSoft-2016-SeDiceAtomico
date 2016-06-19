package main.java.Controller;

import main.java.Adapter.SccAdapter;
import main.java.Model.SccModelInterface;
import main.java.Model.TemplateMethod.SccModel;
import main.java.View.DJView;
import main.java.View.SccView;

public class SccController implements ControllerInterface {
	
	SccModelInterface model;
	public DJView djview;
	public SccView sccview;
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
			isPaused = false;
			
		}
        
		model.initialize();
	}
	
	/**
	 * Constructor creado para el uso de MultiplesView
	 */
	public SccController(SccModel model, DJView view) 
    {
        this.model = model;
        this.djview = view;
        this.djview.disableStopMenuItem();
        this.djview.enableStartMenuItem();
        this.model.initialize();  // ver inicializacion del modelo 
    }
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		if(model.getSpeed()==0){
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
 		if(!isPaused){
 			model.setSpeed(bpm);
 		}
		
	}
 	
 	public void setPause() {
 		if(!isPaused){
 			model.pause();
 			isPaused = true;
 		}else{
 			model.resume();
 			isPaused=false;
 		}
 			
 	}
 	
 	public SccModelInterface getModel(){ return model;}
 	public SccView getSccView(){return sccview;}
 	public DJView getDJView(){return djview;}
 	
 	

}
