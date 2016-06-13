package main.java.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;   

public class Persona implements Serializable {

    private String id;
    private String nombre = "nombre";
    private double calorias = 0.0;
    private double tiempo = 0.0;
    private int distancia = 0;
    private double peso=0.0;
    private int edad=0;

    /**
     * Constructor, que crea una {@link Persona} con los siguiente parámetros.
     * @param id    el id de la {@link Persona}
     * @param nombre   el nombre de la {@link Persona}
     * @param peso   el peso de la {@link Persona}
     * @param edad   la edad de la {@link Persona}
     */
    public Persona(String id, String nombre, double peso, int edad) {
        this.id = id;
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
    }
    
    /**
     * Recupera la id.
     * @return id
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * Recupera el nombre.
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Recupera las calorias.
     * @return calorias
     */
    public double getCalorias() {
        return this.calorias;
    }

    /**
     * Recupera el tiempo.
     * @return tiempo
     */
    public double getTiempo() {
        return this.tiempo;
    }

    /**
     * Recupera la distancia.
     * @return distancia
     */
    public int getDistancia() {
        return this.distancia;
    }

    /**
     * Editar nombre.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Cambia valor de calorias.
     * @param calorias
     */
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    
    /**
     * Cambia el tiempo.
     * @param tiempo
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Cambia la distacia.
     * @param distancia
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
  
    public void guardarEstado( String nombre) {
    	this.setNombre(nombre);
    	File f = new File(nombre+".bin");
        FileOutputStream fos = null;
        ObjectOutputStream escribirObjeto = null;
        
        try{
            fos = new FileOutputStream( f );
            escribirObjeto = new ObjectOutputStream( fos );
            escribirObjeto.writeObject(this);
            JOptionPane.showMessageDialog(null, "Archivo "+ nombre +".bin guardado con éxito", "Notificación.", JOptionPane.INFORMATION_MESSAGE);
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
            	System.out.printf("E2");
            	ex.printStackTrace();
            }
        }
    }
    	
       
    
    public Persona cargaEstado() {
    	
    	String inputValue = JOptionPane.showInputDialog("Ingrese el nombre del archivo a guardar");
    	File f = new File(inputValue+".bin");

        //Esto siempre debe de ir el FileInputStream y ObjectInputStream
        FileInputStream fis = null;
        ObjectInputStream leerObjeto = null;

        try{
           
            fis = new FileInputStream( f );
            leerObjeto = new ObjectInputStream( fis );

            Persona cliente = (Persona)leerObjeto.readObject();
            String mensaje= "Bienvendio nuevamente " +cliente.getNombre()+ ". Sus ultimas estadisticas son: \n*Peso: "+cliente.peso+"\n*Distancia: "+cliente.distancia+"\n*Calorias: "+cliente.calorias;
            JOptionPane.showMessageDialog(null, mensaje , "Notificación.", JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("No. calorias: " + cliente.calorias + ", " + "Nombre: " + cliente.nombre);
    	return cliente;
        }
        catch( Exception e ){ }
        finally
        {
            try{
                //Se cierra el archivo y listo.
                if( leerObjeto != null ) leerObjeto.close();
            }catch( Exception ex ){}
        }
        return null;
    	
    }

}