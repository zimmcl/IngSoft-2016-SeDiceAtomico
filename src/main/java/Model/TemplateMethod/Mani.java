package main.java.Model.TemplateMethod;

import java.util.ArrayList;
import java.util.Date;

import main.java.Class.Regulador;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class Mani extends SccModel {
	//IMPLEMENTAR MODELO
		ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
		ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
		
		//Velocidad medida en metros por minuto
		int targetSpeed;							//Velocidad Objetivo
		int currentSpeed; 							//Velocidad Actual de la cinta		
		int lastSpeed;
		Thread thread;
		Date dateInicial;
		double metros;
		double currentTime;
		boolean stop;
		Regulador regulador;
		double factor=0.25;
		
		public Mani(){
			initialize();		
		}
		
		protected void crearRegulador(){
			regulador=new Regulador(this,factor);
		}
			
		public double getCaloriasConsumidas(){
			return getMetros()*factor;
		}

	}