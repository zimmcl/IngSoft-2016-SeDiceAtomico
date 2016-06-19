package main.java.Class;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Persona implements Serializable {

    private String id;
    private String nombre = "nombre";
    private double calorias = 0.0;
    private double tiempo = 0.0;
    private int distancia = 0;
    private double peso=0.0;
    private int velocidad=0;
	private int edad=0;
    private static Persona persona;
    private boolean personacargada=false;

    /**
     * Constructor, que crea una {@link Persona} con los siguiente parámetros.
     * @param id    el id de la {@link Persona}
     * @param nombre   el nombre de la {@link Persona}
     * @param peso   el peso de la {@link Persona}
     * @param edad   la edad de la {@link Persona}
     */
    private Persona(String nombre, double peso, int edad) {
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
        calorias=0.0;
        tiempo=0;
        personacargada=true;
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
        return nombre;
    }

    /**
     * Recupera las calorias.
     * @return calorias
     */
    public double getCalorias() {
        return calorias;
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
     * Recupera la edad.
     * @return edad
     */
    
    public int getEdad(){
    	return edad;
    }
    
    /**
     * Recupera el peso.
     * @return peso
     */
    
    public double getPeso(){
    	return peso;
    }
    
    /**
     * Recupera la velocidad.
     * @return velocidad
     */
    
    public int getVelocidad(){
    	return velocidad;
    }
    
    /**
     * Establece la velocidad.
     * @param velocidad
     */

    public void setVelocidad(int velo){
    	velocidad=velo;
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
    	
    public boolean getEstado(){
    	return personacargada;
    }
       
    /**
     * Crea una nueva persona.
     * @param nombre, peso, edad
     */
    public static Persona crearPersona(String nombre, double peso,int edad){
    	if(persona==null){
    		persona = new Persona(nombre,peso,edad);
    	}
    		return persona;
    	}
    
    /**
     * Recupera la persona.
     * @return persona
     */
    
    public static Persona getPersona(){
    	return persona;
    }

}