package main.java.Class;

import java.io.BufferedReader;
import java.io.File;               
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import main.java.Controller.SccController;
import main.java.Model.TemplateMethod.SccModel;
import main.java.View.OficialView;

/**
 * La clase "Archivador" es un modulo que se encarga de guardar a la persona en un archivo de texto.
 * **/

public class Archivador implements Serializable {

	
	Persona p;
	SccController controller;
	SccModel modelo;
	
	
	
	public Archivador(Persona persona, SccController controller, SccModel modelo) {
		p=persona;
		this.controller=controller;
		this.modelo=modelo;
	}
	
	public Archivador(){
		
	}
	
	
	public void guardar(){
	}
	
	public String[] cargar(){
		
		//String aux="";   
		//String texto="";
		String[] cadena = new String[3];
		  try
		  {
		   /**Llamamos el metodo que permite cargar la ventana*/
		   JFileChooser file=new JFileChooser();
		   file.setCurrentDirectory(new File("C:\\"));
		   file.showOpenDialog(null);
		   /**Abrimos el archivo seleccionado*/
		   File abre=file.getSelectedFile();
		 
		   /**Recorremos el archivo, lo leemos para plasmarlo
		   *en el area de texto*/
		   if(abre!=null)
		   {     
			   boolean fin = false;
				int i=0;
				String linea;
				//String[] cadena = new String[3];
				FileReader fichero=new FileReader(abre);
				BufferedReader buffer = new BufferedReader(fichero);
				StringBuffer sbf = new StringBuffer();
		      while(fin == false){
					linea = buffer.readLine();
					if(linea != null){
						cadena[i]=linea;
						sbf.append(linea + "\n");
						i++;
					}else{
						fin = true;
						//Persona.crearPersona(cadena[0], Double.parseDouble(cadena[2]), Integer.parseInt(cadena[1]));
						
						//OficialView.refrescar();
								}
						}
		         buffer.close();
		        
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
		  return cadena;
		  
		
	}
	
	
	
}
