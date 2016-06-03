package main.java.TestDrive;

import main.java.Controller.ControllerInterface;
import main.java.Controller.HeartController;
import main.java.Model.HeartModel;

public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
