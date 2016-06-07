package main.java.Controller;

import main.java.Adapter.HeartAdapter;
import main.java.Model.HeartModel;
import main.java.Model.HeartModelInterface;
import main.java.View.DJView;

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
  
	public void start() {}
 
	public void stop() {}
    
	//Incrementa en 1 los intentos de instanciaci�n
	public void increaseBPM() {
	@SuppressWarnings("unused")
	HeartModel HeartUnico = HeartModel.getInstancia();
		}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



