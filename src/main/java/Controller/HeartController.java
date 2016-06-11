package main.java.Controller;

import main.java.Adapter.HeartAdapter;
import main.java.Model.HeartModel;
import main.java.Model.HeartModelInterface;
import main.java.View.DJView;
import main.java.View.MultiplesView;

public class HeartController implements ControllerInterface {
	HeartModelInterface model;
	DJView view;
  
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	/**
	 * Constructor creado para el uso de MultiplesView
	 */
	public HeartController(MultiplesView view){
		 
		this.model = HeartModel.getInstancia();
 
		this.view = view;
 
		this.view.disableStopMenuItem();
 
		this.view.disableStartMenuItem();
 
	}
	
	public void start() {}
 
	public void stop() {}
    
	//Incrementa en 1 los intentos de instanciación
	public void increaseBPM() {
	@SuppressWarnings("unused")
	HeartModel HeartUnico = HeartModel.getInstancia();
		}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



