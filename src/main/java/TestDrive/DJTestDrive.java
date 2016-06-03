package main.java.TestDrive;

import main.java.Controller.BeatController;
import main.java.Controller.ControllerInterface;
import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
