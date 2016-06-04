package main.java.TestDrive;

import java.util.Date;

import main.java.Model.SccModel;

public class SccTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SccModel model = new SccModel();
		Printer pr = new Printer (model);
		Thread tpr = new Thread(pr);
		tpr.start();
		
		model.on();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setSpeed(120);
		
		model.pause();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.resume();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.off();
		
	}
		
		
		
		
}
