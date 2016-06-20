package main.java.Model.TemplateMethod;

import java.util.ArrayList;
import java.util.Date;

import main.java.Class.Regulador;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class Abuelo extends SccModel {
			
		
		double factor=10;
		
		public Abuelo(){
			initialize();		
		}
		
		protected void crearRegulador(){
			regulador=new Regulador(this,factor);
		}
			
		public double getCaloriasConsumidas(){
			return getMetros()*factor;
		}


	}