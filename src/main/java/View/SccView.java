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
	
	SccModelInterface model;
	ControllerInterface controller;
	JLabel vel;
	
	   protected ImageIcon images[];
	   protected int totalImages = 2,
	                 currentImage = 0,
	                 animationDelay = 0; // 50 millisecond delay
	   protected Timer animationTimer;
	
	
	
	public SccView(ControllerInterface controller, SccModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
		
		setSize( getPreferredSize() );
		 
	      images = new ImageIcon[ totalImages ];
	 
	      for ( int i = 0; i < 2; ++i ) 
	         images[ i ] =
	            new ImageIcon( "E:/tio" + i + ".jpg" );
	      inicializa();
	      startAnimation();
	}

	@Override
	public void updateBeat() {
		// TODO Auto-generated method stub
		
		System.out.print("Se cumplieron:" + 1+ " m");
	}

	@Override
	public void updateBPM() {
		// TODO Auto-generated method stub

		animationDelay = model.getSpeed();
		vel.setText("Velocidad: "+animationDelay);
	}

	
	public void inicializa()
	   {
		   
	     //SccView anim = new SccView();
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
	      JMenuItem on = new JMenuItem("On");
	      JMenuItem off= new JMenuItem("Off");
	      
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
	    	    // display/center the jdialog when the button is pressed
	    	    /*
	    		  int d = animationDelay;
	    		  if((d-100)<0){
	      	    	d=0;
	      	    }else{
	    		  d=animationDelay -=100;
	      	    }
	    		  inc(d);
	    	    vel.setText("Velocidad: "+animationDelay);
	    	  */
	    		controller.increaseBPM();  
	    	  }
	    	});
	      
	      pausa.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    model.setPause();  
	    	    	  }
	    	    	});
	      
	      
	      decrementa.addActionListener(new ActionListener()					//Habilita la funcion del boton decrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    	    /*// display/center the jdialog when the button is pressed
	    	   int d = animationDelay +=100;
	    		dec(d);
	    	    vel.setText("Velocidad: "+animationDelay);
	    	  */
	    		  
	    	  controller.decreaseBPM();}
	    	});
	      
	      
	      
	      campo.addActionListener(new ActionListener()					//Habilita la funcion del boton decrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    	    /*// display/center the jdialog when the button is pressed
	    	   int d = animationDelay +=100;
	    		dec(d);
	    	    vel.setText("Velocidad: "+animationDelay);
	    	  */
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
	 
	      // The constants 10 and 30 are used below to size the
	      // window 10 pixels wider than the animation and
	      // 30 pixels taller than the animation. 
	      //app.setSize( anim.getPreferredSize().width + 10, anim.getPreferredSize().height + 30 );
	   }
	
	
	   public void stopAnimation()
	   {
	      animationTimer.stop();
	   }
	 
	   public void dec(int d){
		   /*int aux= animationDelay + 100;
		   animationTimer.setDelay(aux);
	       */
		   animationTimer.setDelay(d);
		   }

	   public void inc(int d){
		   
		   //int aux= animationDelay - 100;
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
	

}
