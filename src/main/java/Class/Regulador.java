package main.java.Class;

import main.java.Model.TemplateMethod.SccModel;

public class Regulador implements Runnable {
	SccModel model;
	Thread tr;
	static boolean regular;
	double factor;
	
	/**
	 * Constructor del regulador de velocidad.
	 * @param SccModel
	 * @param double
	 * **/
	
	public Regulador(SccModel model,double factor){
		this.model = model;
		this.factor=factor;
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
				Thread.sleep((long) (100*factor));
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
	
	public boolean isRunning(){
		return tr.isAlive();
	}
}
