package main.java.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.java.Controller.ControllerInterface;
import main.java.Controller.SccController;
import main.java.Model.SccModelInterface;
import main.java.Model.SccModel;
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
	JLabel metr;
    JPanel animacion;		//Panel de la animacion
    JPanel botones;			//Panel de los botones
    JPanel velocidad;		//Panel donde se muestra la velocidad
    JPanel metros;			//Panel que muestra metros recorridos;
	Button incrementa;
    Button decrementa;
    Button pausa;
    JDialog app;
    JProgressBar barra;

    JMenuBar barraMenu;
	JMenuItem on;
    JMenuItem off;
    JMenuItem importar;
    JMenuItem exportar;
    TextField campo;
    JTextField campoMetros;
    
	protected ImageIcon images[];		//Arreglo donde se almacenan las imagenes para la animacion
	protected int totalImages = 9,		//Cantidad de imagenes a usar en la animacion
	              currentImage = 0,		//Indice de la imagen actual (inicia en 0 por defecto)
	              animationDelay = 1000; 	//Retraso entre cuadro y cuadro, en milisegundos
	protected Timer animationTimer;	//Timer que se encarga de alternar entre los cuadros de la animacion
	protected boolean corriendo;
	private int aux=0;
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
	    
	    for ( int i = 0; i < 9; ++i ){ 
	         images[ i ] = new ImageIcon( "src/imagenes/Mani/Mani" + i + ".jpg" );}
	    inicializa();
	}
	
/**
 * Método a llamarse desde el constructor. Se encarga de generar la ventana en si, y de establecer los comportamientos
 * al producirse los eventos
 * 
 * **/
	public void inicializa()
	   {
	      incrementa = new Button (">>");
	      decrementa = new Button ("<<");
	      pausa = new Button("||");
	      animacion = new JPanel();//Panel de la animacion
	      botones = new JPanel();		//Panel de los botones
	      velocidad = new JPanel();
	      metros = new JPanel();
	      barraMenu = new JMenuBar();
	      campo= new TextField(5);
	      corriendo=true;
	      barra = new JProgressBar();
	      campoMetros = new JTextField();
	      
	      
	      JMenu archivo= new JMenu("Archivo");
	      JMenu edicion = new JMenu("Edicion");
	      JMenuItem salir = new JMenuItem("Salir");
	      on = new JMenuItem("On");
	      off= new JMenuItem("Off");
	      importar = new JMenuItem("Importar");
	      exportar = new JMenuItem("Exportar");
	      

	      archivo.add(on);
	      archivo.add(off);
	      archivo.add(importar);
	      archivo.add(exportar);
	      archivo.add(salir);
	      barraMenu.add(archivo);
	      barraMenu.add(edicion);
	      
	      
	      vel= new JLabel ();
	      velocidad.add(vel);
	      vel.setText("Velocidad: "+ model.getSpeed());
	      
	      metr = new JLabel();
	      metros.add(metr);
	      metr.setText("Metros: "+ ((SccModel) model).getMetros());
	      
	      
	      
	      
	      JPanel container = new JPanel();									//Genera un contenedor que simplifica el agregado de multiples paneles
	      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));	//Cada panel se agrega sobre el contenedor. Luego, se formatea el contenedor
	      
	      
	      
	      app = new JDialog();
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
	    	    	    startAnimation();
	    	    	    //pausa.setEnabled(true);
	    	    	    
	    	    	  }
	    	    	});
	      
	      off.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    controller.stop();
	    	    	    stopAnimation();
	    	    	    //pausa.setEnabled(false);
	    	    	  }
	    	    	});	      

	      importar.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    //controller.start();
	    	    	    //startAnimation();
	    	    	    //pausa.setEnabled(true);
	    	    	    System.out.printf("Cepo al dolar, flaco");
	    	    	  }
	    	    	});
	      
	      
	      exportar.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    		  model.getPersona().guardarEstado("juan");
	    	    	    //controller.start();
	    	    	    //startAnimation();
	    	    	    //pausa.setEnabled(true);
	    	    	    
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
	    	    	    System.out.println("corriendo1="+corriendo);
	    	    		  ((SccController) controller).setPause(); 
	    	    	    if(corriendo)
	    	    	    	{
	    	    	    		pausa.setLabel("->");
	    	    	    	}
	    	    	    else{
	    	    	    	pausa.setLabel("||");
	    	    	    }
	    	    	    corriendo = !corriendo;
	    	    	    System.out.println("corriendo2="+corriendo);
	    	    	    }
	    	    	});
	      
	      
	      decrementa.addActionListener(new ActionListener()					//Habilita la funcion del boton decrementar
	      {
	    	  public void actionPerformed(ActionEvent e)
	    	  {
	    	  controller.decreaseBPM();}
	    	});
	      
	      campoMetros.addActionListener(new ActionListener()					//Cambia el valor de completado de la barra de estado
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	  barra.setMaximum(Integer.parseInt(campoMetros.getText()));}  
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
	      
	      pausa.setEnabled(false);
	      
	      botones.add(decrementa);
	      botones.add(pausa);
	      botones.add(incrementa);
	      
	      container.add(animacion);
	      container.add(botones);
	      container.add(velocidad);
	      container.add(metros);
	      container.add(campo);
	      container.add(barra);
	      container.add(new JLabel("Limite Barra"));
	      container.add(campoMetros);
	      barra.setMaximum(100);
	      app.add(container);
	      app.setJMenuBar(barraMenu);
	      app.pack();
	      app.setVisible(true);
	   }
	
	
	
	@Override
	public void updateBeat() {
		
		metr.setText("Metros: "+(int)((SccModel) model).getMetros());
		aux++;
		barra.setValue(aux);
		if(barra.getValue()>=barra.getMaximum()){
		barra.setValue(0);
		barra.repaint();
		aux=0;
		}
		
	}
	
		

	@Override
	public void updateBPM() {
		double v =(double) model.getSpeed(); 		//Velocidad en metros por minuto
		
		if(v==0){
			stopAnimation();
		}else if(!animationTimer.isRunning())
		{
			animationTimer.restart();
		}
		
		v = 1/v;									//Tiempo en recorrer un metro, expresado en minutos;
		v = v*60*100	;							//Tiempo en milisegundos
				
		animationDelay = (int) v;
		animationTimer.setDelay(animationDelay);
		vel.setText("Velocidad: "+ model.getSpeed());
	}

	
	 
	 
	  
	   
	   public Dimension getMinimumSize()
	   { 
	      return getPreferredSize(); 
	   }
	 
	   public Dimension getPreferredSize()
	   {
	      return new Dimension( 300, 300 );		//Modifica la dimension de la imagen
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

	      if ( animationTimer == null || animationTimer.getDelay()>1000) {
	         currentImage = 0;  
	         animationTimer = new Timer( animationDelay, this );
	         animationTimer.start();
	         corriendo = true;
	      }
	      else  // continue from last image displayed
	         if ( ! animationTimer.isRunning() )
	            animationTimer.restart();	   
	   }
	   
	   public void stopAnimation()
	   {
	      animationTimer.stop();
	      
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
