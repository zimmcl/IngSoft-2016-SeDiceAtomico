package main.java.Class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.UUID;
import java.io.File;               
import java.io.FileOutputStream;   

public class Persona {

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
    	File f = new File("juan.bin");
        FileOutputStream fos = null;
        ObjectOutputStream escribirObjeto = null;
        
        try{
            fos = new FileOutputStream( f );
            escribirObjeto = new ObjectOutputStream( fos );
            escribirObjeto.writeObject(this);
        }
        catch( Exception e ){ 
        	System.out.printf("E1");
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
    	
       
    
    public static Persona cargaEstado(String archivo) {
		return null;
    	
    	
    }

}