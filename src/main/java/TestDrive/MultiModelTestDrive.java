package main.java.TestDrive;

import main.java.Controller.BeatController;
import main.java.Controller.ControllerInterface;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;
import main.java.Model.HeartModel;
import main.java.Model.SccModel;

public class MultiModelTestDrive {

	public static void main(String[] args) {
		
		BeatModelInterface beatModel = new BeatModel();
		ControllerInterface beatController = new BeatController(beatModel);
		
		HeartModel heartModel = new HeartModel();
        ControllerInterface heartController = new HeartController(heartModel);
        
        SccModel sccModel = new SccModel();
        ControllerInterface sccController = new SccController(sccModel); 

	}

}
