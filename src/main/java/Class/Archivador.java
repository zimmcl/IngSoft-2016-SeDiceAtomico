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
		
		try
		 {
		  JFileChooser file=new JFileChooser();
		  file.showSaveDialog(null);
		  
		  File guarda =file.getSelectedFile();
		 
		  if(guarda !=null)
		  {
		    FileWriter  save=new FileWriter(guarda+".txt");
		    PrintWriter pw = new PrintWriter(save);
	        pw.println(Persona.getPersona().getNombre());
           pw.println(Persona.getPersona().getEdad());
           pw.println(Persona.getPersona().getPeso());
           pw.println(modelo.getMetros());
           pw.println(modelo.getCaloriasConsumidas());
           //pw.println(controller.sccview.metr.getText());
           //pw.println(controller.sccview.cal.getText());
		    save.close();
		    JOptionPane.showMessageDialog(null,
		         "Guardado exitoso",
		             "Información",JOptionPane.INFORMATION_MESSAGE);
		    }
		 }
		  catch(IOException ex)
		  {
		   JOptionPane.showMessageDialog(null,
		        "Su archivo no se ha guardado",
		           "Advertencia",JOptionPane.WARNING_MESSAGE);
		  }
		

		/**JFileChooser file=new JFileChooser();
		file.showSaveDialog(null);
		File guarda =file.getSelectedFile();
		String directorio = guarda.getAbsolutePath();
		
		
		
		FileOutputStream fos = null;
	    ObjectOutputStream escribirObjeto = null;
		
		
	    try{
		       
	        fos = new FileOutputStream( guarda );
	        escribirObjeto = new ObjectOutputStream( fos );

	        //Se escribe la instancia de la clase CasaBulma
	        escribirObjeto.writeObject( p );
	    }
	    catch( Exception e ){ 
	    	e.printStackTrace();
	    }
	    finally
	    {
	        try{
	            //Se cierra el archivo y listo.
	            if( escribirObjeto != null ) escribirObjeto.close();
	        }catch( Exception ex ){
	        	ex.printStackTrace();
	        }
	    }**/
		
		
		
		
		
	 /*   File f = new File(directorio+".bin");

	    //Esto siempre debe de ir el FileOutputStream y ObjectOutputStream
	    FileOutputStream fos = null;
	    ObjectOutputStream escribirObjeto = null;

	    try{
	       
	        fos = new FileOutputStream( f );
	        escribirObjeto = new ObjectOutputStream( fos );

	        //Se escribe la instancia de la clase CasaBulma
	        escribirObjeto.writeObject( objetivo );
	    }
	    catch( Exception e ){ 
	    	e.printStackTrace();
	    }
	    finally
	    {
	        try{
	            //Se cierra el archivo y listo.
	            if( escribirObjeto != null ) escribirObjeto.close();
	        }catch( Exception ex ){
	        	ex.printStackTrace();
	        }
	    }*/
	}
	
	public String[] cargar(){
		
		String aux="";   
		String texto="";
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
