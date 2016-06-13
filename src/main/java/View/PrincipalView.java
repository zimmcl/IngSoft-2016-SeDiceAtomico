package main.java.View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import main.java.Controller.BeatController;
import main.java.Controller.ControllerInterface;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;
import main.java.Model.HeartModel;
import main.java.Model.HeartModelInterface;
import main.java.Model.SccModel;
import main.java.Model.SccModelInterface; 

public class PrincipalView extends JFrame implements ActionListener {
	
	private JLabel imagen;           	 
    private JLabel texto; 
    private JLabel texto1;
    private JButton botonHeart;          
    private JButton botonBeat;
    private JButton botonScc;
    private JButton botonCintaM;
    private JButton botonTodos;
    private JButton boton3Vistas;
    private JPanel panelSuperior;
    private JPanel panelInferior;
       
	public PrincipalView(){
		super();
		configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
	}
	
	private void configurarVentana() {
        this.setTitle("SDA - CINTAMATRIX 300 - Trabajo Final Ing. Software");               // colocamos titulo a la ventana
        this.setSize(500, 450);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }
	
	private void inicializarComponentes() {
        // creamos los componentes
        imagen = new JLabel();
        texto1 = new JLabel("v1.0.0");
        botonHeart = new JButton();
        botonBeat = new JButton();
        botonScc = new JButton();
        botonCintaM = new JButton();
        botonTodos = new JButton();
        boton3Vistas = new JButton();
        panelSuperior = new JPanel();
        panelInferior = new JPanel();
        texto = new JLabel("MANTENGA EL CURSOR SOBRE CADA OPCIÓN PARA MÁS INFORMACIÓN");
        
        /** CONFIGURAMOS COMPONENTES
         * 
         */
        
        //Boton Heart
        botonHeart.setText("HEART");
        botonHeart.setBounds(25, 290, 100, 40);
        botonHeart.setToolTipText("Instancia HeartModel y muestra su comportamiento en DJView");
        botonHeart.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		botonHeartActionPerformed(evt);
        	}
        });
        //Boton Beat
        botonBeat.setText("BEAT");
        botonBeat.setBounds(135, 290, 100, 40);
        botonBeat.setToolTipText("Instancia BeatModel y muestra su comportamiento en DJView");
        botonBeat.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		botonBeatActionPerformed(evt);
        	}
        });
      //Boton Scc
        botonScc.setText("SCC");
        botonScc.setBounds(245, 290, 100, 40);
        botonScc.setToolTipText("Instancia SccModel y muestra su comportamiento en DJView");
        botonScc.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		botonSccActionPerformed(evt);
        	}
        });
        //Boton CintaMatrix
        botonCintaM.setText("CintaMatrix");
        botonCintaM.setBounds(355, 290, 100, 40);
        botonCintaM.setToolTipText("Instancia SccModel y muestra su comportamiento en SccView");
        botonCintaM.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		botonCintaMActionPerformed(evt);
        	}
        });
        //Boton 3Vista
        boton3Vistas.setText("3Vistas");
        boton3Vistas.setBounds(135, 350, 100, 40);
        boton3Vistas.setToolTipText("Invoca nueva vista que permite alternar los 3 modelos");
        boton3Vistas.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		boton3VistasActionPerformed(evt);
        	}
        });
        //Boton 3Todos
        botonTodos.setText("Todos");
        botonTodos.setBounds(245, 350, 100, 40);
        botonTodos.setToolTipText("Hace un desastre. NO USAR");
        botonTodos.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(ActionEvent evt){
        		botonTodosActionPerformed(evt);
        	}
        });
        panelSuperior.setBounds(0, 0, 500, 250);
        panelInferior.setBounds(0, 250, 500, 250);
        texto.setBounds(0, 230, 500, 20);
        texto.setHorizontalAlignment(NORMAL);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Se_dice_Atomico.jpg")));
        panelSuperior.add(imagen);

        this.add(texto);
        this.add(botonHeart);
        this.add(botonBeat);
        this.add(botonScc);
        this.add(botonCintaM);
        this.add(boton3Vistas);
        this.add(botonTodos);
        this.add(panelSuperior).setBackground(Color.WHITE);
        this.add(panelInferior).setBackground(Color.cyan);
        texto1.setBounds(0, 450, 20, 450);
        panelInferior.add(texto1);
         
    }

    private void botonHeartActionPerformed(java.awt.event.ActionEvent evt) {
            
    HeartModelInterface modelo = HeartModel.getInstancia();
    HeartController controlador = new HeartController((HeartModel) modelo);    
    }
    
    private void botonBeatActionPerformed(java.awt.event.ActionEvent evt){
    BeatModelInterface modelo = new BeatModel();
    ControllerInterface controlador = new BeatController(modelo);	
    }
    
    private void botonSccActionPerformed(java.awt.event.ActionEvent evt){
    SccModelInterface modelo = new SccModel();
    ControllerInterface controlador = new SccController(modelo, false);	
    }
    
    private void botonCintaMActionPerformed(java.awt.event.ActionEvent evt){
    	SccModel modelo=new SccModel();
    	SccController controlador=new SccController(modelo, true);
    }
    
    private void boton3VistasActionPerformed(java.awt.event.ActionEvent evt){
    MultiplesView vista = new MultiplesView();
    vista.createView();
    vista.createControls();
    }
    
    private void botonTodosActionPerformed(java.awt.event.ActionEvent evt){
    	
    }
    	
	@Override
	public void actionPerformed(ActionEvent e) {
       
    }
	
	public static void main(String[] args) {
        PrincipalView V = new PrincipalView();      // creamos una ventana
        V.setVisible(true);             					// hacemos visible la ventana creada
    }
	
}