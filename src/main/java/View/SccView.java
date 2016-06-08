package main.java.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.java.Controller.ControllerInterface;
import main.java.Model.BeatModelInterface;
import main.java.Model.SccModelInterface;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

public class SccView extends JPanel implements BPMObserver, BeatObserver, ActionListener {
	
	/**
	 * Declaración de las variables locales
	 *
	 **/
	
	SccModelInterface model;
	ControllerInterface controller;
	JLabel vel;
    JPanel animacion;		//Panel de la animacion
    JPanel botones;			//Panel de los botones
    JPanel velocidad;		//Panel donde se muestra la velocidad
	Button incrementa;
    Button decrementa;
    Button pausa;

    JMenuBar barraMenu;
	JMenuItem on;
    JMenuItem off;
    TextField campo;
    
	protected ImageIcon images[];		//Arreglo donde se almacenan las imagenes para la animacion
	protected int totalImages = 2,		//Cantidad de imagenes a usar en la animacion
	              currentImage = 0,		//Indice de la imagen actual (inicia en 0 por defecto)
	              animationDelay = 50; 	//Retraso entre cuadro y cuadro, en milisegundos
	   protected Timer animationTimer;	//Timer que se encarga de alternar entre los cuadros de la animacion
	
	/** 
	 * Constructor de la clase. Al ejecutarse, registra a los observadores
	 * 
	 * **/
	
	public SccView(ControllerInterface controller, SccModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
		
		setSize( getPreferredSize() );
	    images = new ImageIcon[ totalImages ];
	 
	    for ( int i = 0; i < 2; ++i ) 
	         images[ i ] = new ImageIcon( "E:/tio" + i + ".jpg" );
	    inicializa();
	    startAnimation();
	}
	
/**
 * Método a llamarse desde el constructor. Se encarga de generar la ventana en si, y de establecer los comportamientos
 * al producirse los eventos
 * 
 * **/
	public void inicializa()
	   {
	      Button incrementa = new Button (">>");
	      Button decrementa = new Button ("<<");
	      Button pausa = new Button("||");
	      JPanel animacion = new JPanel();//Panel de la animacion
	      JPanel botones = new JPanel();		//Panel de los botones
	      JPanel velocidad = new JPanel();
	      JMenuBar barraMenu = new JMenuBar();
	      TextField campo= new TextField(5);
	      
	      
	      
	      JMenu archivo= new JMenu("Archivo");
	      JMenu edicion = new JMenu("Edicion");
	      JMenuItem salir = new JMenuItem("Salir");
	      on = new JMenuItem("On");
	      off= new JMenuItem("Off");
	      
	      archivo.add(salir);
	      archivo.add(on);
	      archivo.add(off);
	      barraMenu.add(archivo);
	      barraMenu.add(edicion);
	      
	      
	      vel= new JLabel ();
	      velocidad.add(vel);
	      vel.setText("Velocidad: "+this.animationDelay);
	      
	      
	      JPanel container = new JPanel();									//Genera un contenedor que simplifica el agregado de multiples paneles
	      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));	//Cada panel se agrega sobre el contenedor. Luego, se formatea el contenedor
	      
	      
	      
	      JFrame app = new JFrame( "Animator test" );
	      animacion.add(this);
	      app.getContentPane().add( animacion, BorderLayout.EAST );
	      app.add(animacion,BorderLayout.EAST);
	      
	      
	      salir.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    System.exit(0);
	    	    	  }
	    	    	});
	      
	      on.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    controller.start();
	    	    	  }
	    	    	});
	      
	      off.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    controller.stop();
	    	    	  }
	    	    	});	      
	      
	      incrementa.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    		controller.increaseBPM();  
	    	  }
	    	});
	      
	      pausa.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    System.out.println("Pausau");
	    	    		  //model.setPause();  
	    	    	  }
	    	    	});
	      
	      
	      decrementa.addActionListener(new ActionListener()					//Habilita la funcion del boton decrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    	  controller.decreaseBPM();}
	    	});
	      
	      
	      
	      campo.addActionListener(new ActionListener()					//Habilita la funcion del boton decrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    	  controller.setBPM(Integer.parseInt(campo.getText()));}
	    	});
	      
	      app.addWindowListener(				//Implementa la accion a realizar al apretar el boton "salir"
	         new WindowAdapter() {
	            public void windowClosing( WindowEvent e )
	            {
	               System.exit( 0 );
	            }
	         }
	      );
	      
	      botones.add(decrementa);
	      botones.add(pausa);
	      botones.add(incrementa);
	      
	      container.add(animacion);
	      container.add(botones);
	      container.add(velocidad);
	      container.add(campo);
	      
	      app.add(container);
	      app.setJMenuBar(barraMenu);
	      app.pack();
	      app.setVisible(true);
	   }
	
	
	
	@Override
	public void updateBeat() {
		System.out.print("Se cumplieron:" + 1+ " m");
	}

	@Override
	public void updateBPM() {
		animationDelay = model.getSpeed();
		vel.setText("Velocidad: "+animationDelay);
	}

	
	   public void stopAnimation()
	   {
	      animationTimer.stop();
	   }
	 
	   /**
	    * Decrementa el retraso de la animacion (aumenta la frecuencia).
	    * HACEN FALTA ESTOS METODOS????
	    * **/
	   public void dec(int d){
		   animationTimer.setDelay(d);
		   }

	   public void inc(int d){
		   animationTimer.setDelay(d);
		   
	   }
	   
	   public Dimension getMinimumSize()
	   { 
	      return getPreferredSize(); 
	   }
	 
	   public Dimension getPreferredSize()
	   {
	      return new Dimension( 143, 238 );		//Modifica la dimension de la imagen
	   }
	
	   
	   public void paintComponent( Graphics g )
	   {
	      super.paintComponent( g );
	 
	      if ( images[ currentImage ].getImageLoadStatus() ==
	           MediaTracker.COMPLETE ) {
	         images[ currentImage ].paintIcon( this, g, 0, 0 );
	         currentImage = ( currentImage + 1 ) % totalImages;
	      }
	   }
	 
	   public void actionPerformed( ActionEvent e )
	   {
	      repaint();
	   }
	 
	   
	   /**
	    * Declara el timer a usar en la animacion, y lo arranca.
	    * **/
	   public void startAnimation()
	   {
	      if ( animationTimer == null ) {
	         currentImage = 0;  
	         animationTimer = new Timer( animationDelay, this );
	         animationTimer.start();
	      }
	      else  // continue from last image displayed
	         if ( ! animationTimer.isRunning() )
	            animationTimer.restart();
	   }
	
	   public void enableStopMenuItem() {
	    	off.setEnabled(true);
		}

		public void disableStopMenuItem() {
	    	off.setEnabled(false);
		}

		public void enableStartMenuItem() {
	    	on.setEnabled(true);
		}

		public void disableStartMenuItem() {
	    	on.setEnabled(false);
		}

		public void disablePauseButtonItem() {
	    	pausa.setEnabled(false);
		}
		
		public void enablePauseButtonItem() {
	    	pausa.setEnabled(true);
		}
		
		
}
