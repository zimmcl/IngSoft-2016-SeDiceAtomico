package main.java.TestDrive;

import main.java.Controller.ControllerInterface;
import main.java.Controller.SccController;
import main.java.Model.TemplateMethod.Estandar;
import main.java.Model.TemplateMethod.SccModel;

public class SccTestDrive {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		SccModel sccModel = new Estandar();
        ControllerInterface model = new SccController(sccModel, true); 
		
	}
				
}
