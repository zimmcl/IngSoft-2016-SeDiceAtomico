package main.java.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.java.Controller.ControllerInterface;
import main.java.Controller.SccController;
import main.java.Model.SccModelInterface;
import main.java.Model.TemplateMethod.Mani;
import main.java.Model.TemplateMethod.SccModel;
import main.java.Model.TemplateMethod.Soldado;
import main.java.Observer.BPMObserver;
import main.java.Observer.BeatObserver;

@SuppressWarnings("serial")
public class SccView extends JPanel implements BPMObserver, BeatObserver, ActionListener {
	
	/**
	 * Declaración de las variables locales
	 *
	 **/
	
	SccModelInterface model;
	ControllerInterface controller;
	JLabel vel;
	JLabel metr;
	JLabel cal;
    JPanel animacion;		//Panel de la animacion
    JPanel botones;			//Panel de los botones
    JPanel velocidad;		//Panel donde se muestra la velocidad
    JPanel metros;			//Panel que muestra metros recorridos;
    JPanel valores;
    JPanel barras;
    JPanel calorias;
	Button incrementa;
    Button decrementa;
    Button pausa;
    JDialog app;
    JProgressBar barra;
    JMenuBar barraMenu;
	JButton on;
    JButton off;
    JMenuItem manisito;
    JMenuItem soldadito;
    TextField campo;
    TextField campoMetros;
    URL sDirectorio;
    File[] archivos;
    Soldado soldado;
    Mani mani;
    JMenu skin;
    String nombreClase;
    
	protected ArrayList<ImageIcon> images;		//Arreglo donde se almacenan las imagenes para la animacion
	protected int totalImages = 0,		//Cantidad de imagenes a usar en la animacion
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
		images = new ArrayList<ImageIcon>();
	    cargar();
	    inicializa();
	}
	
	public void cargar(){
		nombreClase=model.getClass().getSimpleName();
		if(nombreClase.equals("Abuelo")){
			totalImages=16;
		}if(nombreClase.equals("Cazador")){
			totalImages=8;
		}if(nombreClase.equals("Duo")){
			totalImages=13;
		}if(nombreClase.equals("Estandar")){
			totalImages=16;
		}if(nombreClase.equals("Fantasma")){
			totalImages=7;
		}if(nombreClase.equals("Mani")){
			totalImages=10;
		}if(nombreClase.equals("Soldado")){
			totalImages=16;
		}
		
		images.clear();	
		/*sDirectorio = getClass().getResource("/imagenes/"+nombreClase+"/");
		File f = new File(sDirectorio.toString());
		archivos = f.listFiles();
		totalImages=archivos.length;*/
			
		for ( int i = 0; i <totalImages; ++i ){ 
	         images.add(new ImageIcon(getClass().getResource("/imagenes/"+nombreClase+"/"+nombreClase+ i + ".jpg" )));
			}
		if (this.app!=null){this.app.dispose();}
		
	}
	
/**
 * Método a llamarse desde el constructor. Se encarga de generar la ventana en si, y de establecer los comportamientos
 * al producirse los eventos
 * 
 * **/
	public void inicializa()
	   {
	      incrementa = new Button (">>>");
	      decrementa = new Button ("<<<");
	      pausa = new Button("||");
	      animacion = new JPanel();//Panel de la animacion
	      botones = new JPanel();		//Panel de los botones
	      valores = new JPanel();
	      barras = new JPanel();
	      //velocidad = new JPanel();
	      //metros = new JPanel();
	      barraMenu = new JMenuBar();
	      campo= new TextField(15);
	      corriendo=true;
	      barra = new JProgressBar();
	      campoMetros = new TextField(15);
	      campo.setText("Campo de velocidad");
	      campoMetros.setText("Campo ProgresBar");
	      
	      JMenu archivo= new JMenu("Archivo");
	      skin = new JMenu("SKIN");
	      JMenuItem salir = new JMenuItem("Salir");
	      on = new JButton("On");
	      off= new JButton("Off");
	      manisito = new JMenuItem("Mani");
	      soldadito = new JMenuItem("Soldado");
	      

	      //archivo.add(on);
	      //archivo.add(off);
	     // skin.add(manisito);
	     // skin.add(soldadito);
	      //archivo.add(salir);
	      //barraMenu.add(archivo);
	      //barraMenu.add(skin);
	      
	      
	      vel= new JLabel ();
	      vel.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
	      //velocidad.add(vel);
	      vel.setText( model.getSpeed()+" m/s");
	      
	      metr = new JLabel();
	      metr.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
	     // metros.add(metr);
	      metr.setText(((SccModel) model).getMetros()+" metros");
	      
	      cal = new JLabel();
	      cal.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
	      //calorias.add(cal);
	      cal.setText(((SccModel)model).getCaloriasConsumidas()+" cal");
	      
	      
	      
	      
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
	    	    	    skin.setEnabled(false);
	    	    	    //pausa.setEnabled(true);
	    	    	    
	    	    	  }
	    	    	});
	      
	      off.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    	    controller.stop();
	    	    	    //controller=null;
	    	    	    //stopAnimation();
	    	    	    //pausa.setEnabled(false);
	    	    	  }
	    	    	});	      

	      manisito.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {
	    	    		  
	    	    		  model = new Mani();
	    	    		  //controller = new SccController(model,true);
	    	    		  set(model);
	    	    		  //inicializa();
	    	    		  //cargar();
	    	    		  //controlador.sccview.app.dispose();
	    	    		  
	    	    	  }
	    	    	});
	      
	      
	      soldadito.addActionListener(new ActionListener()					//Habilita la funcion del boton incrementar
	    	      {
	    	    	  public void actionPerformed(ActionEvent e)
	    	    	  {  
	    	    		model = new Soldado();
	    	    	    //SccController controlador = new SccController(model,true);
	    	    	    //controlador.sccview.app.dispose();
	    	    	    set(model);
	    	    	    //controlador.sccview.app.dispose();
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
	            	app.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            	 controller.stop();
	            }
	         }
	      );
	      
	      pausa.setEnabled(false);
	      
	      botones.add(decrementa);
	      botones.add(pausa);
	      botones.add(incrementa);
	      botones.add(on);
	      botones.add(off);
	      //botones.add(campo);
	      //botones.add(campoMetros);
	      valores.add(vel);
	      valores.add(metr);
	      valores.add(cal);
	      barras.add(campo);
	      barras.add(campoMetros);
	      container.add(animacion);
	      container.add(botones);
	      container.add(valores);
	      container.add(barras);
	      //container.add(velocidad);
	      //container.add(metros);
	     // container.add(calorias);
	     // container.add(campo);
	      container.add(barra);
	      container.add(new JLabel("Barra de progreso"));
	      //container.add(campoMetros);
	      barra.setMaximum(100);
	      app.add(container);
	      //app.setJMenuBar(barraMenu);
	      
	      startAnimation();
	      updateBPM();
	      
	      app.pack();
	      app.setVisible(true);
	   }
	
	
	
	@Override
	public void updateBeat() {
		cal.setText((double)((SccModel)model).getCaloriasConsumidas()+" cal");
		metr.setText((int)((SccModel) model).getMetros()+" metros");
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
		vel.setText(model.getSpeed()+" mtr/min");
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
	 
	      if ( images.get(currentImage).getImageLoadStatus() ==
	           MediaTracker.COMPLETE ) {
	         images.get(currentImage).paintIcon( this, g, 0, 0 );
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
		//-------------------------------------------------
		public void set(SccModelInterface model) {
			cargar();
			model.registerObserver((BeatObserver) this);
	        model.registerObserver((BPMObserver) this);
		}
		
		public void setSkin(boolean valor){
			skin.setEnabled(valor);
		}

		
}
