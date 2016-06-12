package main.java.Class;

import main.java.Model.SccModel;

public class Regulador implements Runnable {
	SccModel model;
	Thread tr;
	static boolean regular;
	
	public Regulador(SccModel model){
		this.model = model;
		regular= true;
		tr = new Thread(this);
		tr.start();		
	}
	
	public static void apagarRegulador(){
		regular = false;
	}
	@Override
	public void run(){
		while(regular || model.getSpeed()!=0){
			
			
			try {
				Thread.sleep(100);
				if(model.getSpeed()>model.getTargetSpeed()){
					model.modifyCurrentSpeed(-1);
					model.notifyBPMObservers();
				}
					
				else if(model.getSpeed()<model.getTargetSpeed()){
					model.modifyCurrentSpeed(1);
					model.notifyBPMObservers();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
		
		}
	}
}
