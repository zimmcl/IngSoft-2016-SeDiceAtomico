package main.java.Class;

import main.java.Model.SccModel;

public class Regulador implements Runnable {
	SccModel model;
	
	public Regulador(SccModel model){
		this.model = model;
	}
		
		

	@Override
	public void run(){
		while(model.getSpeed()>=1){
			try {
				Thread.sleep(100);
				if(model.getSpeed()>model.getTargetSpeed())
					model.modifyCurrentSpeed(-1);
				else if(model.getSpeed()<model.getTargetSpeed())
					model.modifyCurrentSpeed(1);
				model.notifyBPMObservers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			
		}
		
		

	}

}
