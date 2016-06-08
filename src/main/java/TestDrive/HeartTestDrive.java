package main.java.TestDrive;

import main.java.Controller.ControllerInterface;
import main.java.Controller.HeartController;
import main.java.Model.HeartModel;

public class HeartTestDrive {

	@SuppressWarnings("unused")
	public static void main (String[] args) {
	//HeartModel heartModel = new HeartModel();
    //ControllerInterface model = new HeartController(heartModel);
    	
    /*Se modifico la creación del HeartModel*/
    HeartModel HeartUnico = HeartModel.getInstancia();
	ControllerInterface model = new HeartController(HeartUnico);
    }
}
