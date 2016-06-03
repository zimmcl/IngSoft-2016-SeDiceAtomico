package main.java.TestDrive;

import main.java.Model.SccModel;

public class SccTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SccModel model = new SccModel();
		
		model.initialize();
		model.on();
		try {
			Thread.sleep(3000);
			model.pause();

			//model.setSpeed(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			model.resume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(3000);
			model.off();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
