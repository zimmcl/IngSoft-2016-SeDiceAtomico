package main.java.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JTextPane;

import main.java.Controller.BeatController;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.BeatModelInterface;
import main.java.Model.HeartModel;
import main.java.Model.HeartModelInterface;
import main.java.Model.SccModel;
import main.java.Model.SccModelInterface;
import javax.swing.JProgressBar;


public class DemoView implements ActionListener {

	private JFrame frmSdaTrabajo;
	private JMenu mnMusica;
	SccController controladorScc;
	JProgressBar progressBar;
	HeartModelInterface modeloHeart;
	BeatModelInterface modeloBeat;
	SccModelInterface modeloScc;
	HeartController controladorHeart;
	BeatController controladorBeat;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoView window = new DemoView();
					window.frmSdaTrabajo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemoView() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		SccModel modelo=new SccModel();
		modeloScc=modelo;
    	SccController controlador=new SccController(modelo, true);
    	this.controladorScc=controlador;
    	controlador.sccview.app.setVisible(false);
		
		
		frmSdaTrabajo = new JFrame();
		frmSdaTrabajo.setResizable(false);
		frmSdaTrabajo.setTitle("SDA - Trabajo Final Ingenieria de Software");
		frmSdaTrabajo.setIconImage(Toolkit.getDefaultToolkit().getImage(DemoView.class.getResource("/imagenes/Se_dice_Atomico.jpg")));
		frmSdaTrabajo.setBounds(150, 100, 1025, 550);
		frmSdaTrabajo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 5, 0, 5));
		frmSdaTrabajo.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicio");
		mnNewMenu.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		mnNewMenu.setEnabled(false);
		
		JMenuItem mntmNuevaPersona = new JMenuItem("Nueva Persona");
		mntmNuevaPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnNewMenu.add(mntmNuevaPersona);
		
		JMenuItem mntmCargarPersona = new JMenuItem("Cargar Persona");
		mntmCargarPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnNewMenu.add(mntmCargarPersona);
		
		JMenuItem mntmGuardarPersona = new JMenuItem("Guardar Persona");
		mntmGuardarPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnNewMenu.add(mntmGuardarPersona);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnNewMenu.add(mntmSalir);
		
		mnMusica = new JMenu("Musica");
		mnMusica.setEnabled(false);
		mnMusica.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		menuBar.add(mnMusica);
		
		JMenuItem mntmEncender = new JMenuItem("Encender");
		mntmEncender.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMusica.add(mntmEncender);
		
		JSeparator separator_2 = new JSeparator();
		mnMusica.add(separator_2);
		
		JMenuItem mntmTema = new JMenuItem("Tema");
		mntmTema.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMusica.add(mntmTema);
		
		JSeparator separator_3 = new JSeparator();
		mnMusica.add(separator_3);
		
		JMenuItem mntmApagar = new JMenuItem("Apagar");
		mntmApagar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMusica.add(mntmApagar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		menuBar.add(mnAyuda);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
		mntmNewMenuItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnAyuda.add(separator_1);
		
		JMenuItem mntmBienvenido = new JMenuItem("Visitar sitio Web");
		mntmBienvenido.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		try {
					VisitarSitioActionPerformed(evt);
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
		mntmBienvenido.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmBienvenido);
		//----------------
		JMenuItem mntmAcercaDeSediceatmico = new JMenuItem("Acerca de...");
		mntmAcercaDeSediceatmico.setEnabled(false);
		
		mntmAcercaDeSediceatmico.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmAcercaDeSediceatmico);
		SpringLayout springLayout = new SpringLayout();
		frmSdaTrabajo.getContentPane().setLayout(springLayout);
		
		JPanel panelIzquierdo = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panelIzquierdo, 10, SpringLayout.NORTH, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelIzquierdo, 10, SpringLayout.WEST, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelIzquierdo, -10, SpringLayout.SOUTH, frmSdaTrabajo.getContentPane());
		panelIzquierdo.setBackground(SystemColor.inactiveCaption);
		frmSdaTrabajo.getContentPane().add(panelIzquierdo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setEnabled(false);
		lblUsuario.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		panelIzquierdo.add(lblUsuario);
		
		Label lblUsuarioPropio = new Label("<nombre>");
		lblUsuarioPropio.setEnabled(false);
		lblUsuarioPropio.setBackground(SystemColor.text);
		lblUsuarioPropio.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblUsuarioPropio.setAlignment(Label.CENTER);
		panelIzquierdo.add(lblUsuarioPropio);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setEnabled(false);
		lblPeso.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		panelIzquierdo.add(lblPeso);
		
		Label lblPesoPropio = new Label("<Peso>");
		lblPesoPropio.setEnabled(false);
		lblPesoPropio.setAlignment(Label.CENTER);
		lblPesoPropio.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblPesoPropio.setBackground(SystemColor.text);
		panelIzquierdo.add(lblPesoPropio);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		lblVelocidad.setEnabled(false);
		panelIzquierdo.add(lblVelocidad);
		
		//Label label = new Label("<Velocidad>");
		controlador.sccview.vel.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		controlador.sccview.vel.setBackground(SystemColor.text);
		//label.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		//label.setEnabled(false);
		//label.setBackground(Color.WHITE);
		//label.setAlignment(Label.CENTER);
		panelIzquierdo.add(controlador.sccview.vel);
		
		JLabel lblDistancia = new JLabel("Distancia");
		lblDistancia.setEnabled(false);
		lblDistancia.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		panelIzquierdo.add(lblDistancia);
		
		//Label lblDistanciaPropia = new Label("<Distancia>");
		controlador.sccview.metros.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		controlador.sccview.metros.setBackground(SystemColor.text);
		//controlador.sccview.metr.setAlignment(Label.CENTER);
		//lblDistanciaPropia.setEnabled(false);
		//lblDistanciaPropia.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		//lblDistanciaPropia.setBackground(SystemColor.text);
		//lblDistanciaPropia.setAlignment(Label.CENTER);
		panelIzquierdo.add(controlador.sccview.metros);
		
		JLabel lblCalorias = new JLabel("Calorias");
		lblCalorias.setEnabled(false);
		lblCalorias.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		panelIzquierdo.add(lblCalorias);
		
		Label lblCaloriasPropias = new Label("<Calorias>");
		lblCaloriasPropias.setEnabled(false);
		lblCaloriasPropias.setFont(new Font("Lucida Bright", Font.PLAIN, 14));
		lblCaloriasPropias.setBackground(SystemColor.text);
		lblCaloriasPropias.setAlignment(Label.CENTER);
		panelIzquierdo.add(lblCaloriasPropias);
		
		Panel panelDerecho = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panelDerecho, 10, SpringLayout.NORTH, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelDerecho, 0, SpringLayout.SOUTH, panelIzquierdo);
		springLayout.putConstraint(SpringLayout.EAST, panelDerecho, -10, SpringLayout.EAST, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panelDerecho, 680, SpringLayout.WEST, frmSdaTrabajo.getContentPane());
		panelDerecho.setBackground(Color.LIGHT_GRAY);
		panelDerecho.add(controlador.sccview.barraMenu);
		panelDerecho.add(controlador.sccview.app.getContentPane());
		frmSdaTrabajo.getContentPane().add(panelDerecho);
		
		JPanel panelInferior = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panelIzquierdo, -6, SpringLayout.WEST, panelInferior);
		springLayout.putConstraint(SpringLayout.SOUTH, panelInferior, -10, SpringLayout.SOUTH, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelInferior, -6, SpringLayout.WEST, panelDerecho);
		springLayout.putConstraint(SpringLayout.WEST, panelInferior, 121, SpringLayout.WEST, frmSdaTrabajo.getContentPane());
		
		JTextPane txtDemo = new JTextPane();
		panelIzquierdo.add(txtDemo);
		SpringLayout sl_panelInferior = new SpringLayout();
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, txtDemo, -24, SpringLayout.SOUTH, panelInferior);
		sl_panelInferior.putConstraint(SpringLayout.EAST, txtDemo, -10, SpringLayout.EAST, panelInferior);
		txtDemo.setForeground(Color.WHITE);
		txtDemo.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		txtDemo.setEditable(false);
		txtDemo.setBackground(SystemColor.inactiveCaption);
		txtDemo.setText("Versión BETA");
		panelInferior.setBackground(new Color(144, 238, 144));
		frmSdaTrabajo.getContentPane().add(panelInferior);
		
		panelInferior.setLayout(sl_panelInferior);
		
		JButton btnHeart = new JButton("HEART");
		sl_panelInferior.putConstraint(SpringLayout.WEST, btnHeart, 10, SpringLayout.WEST, panelInferior);
		sl_panelInferior.putConstraint(SpringLayout.EAST, btnHeart, -433, SpringLayout.EAST, panelInferior);
		btnHeart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonHeartActionPerformed(evt);
        	}
        });
		sl_panelInferior.putConstraint(SpringLayout.NORTH, btnHeart, 41, SpringLayout.NORTH, panelInferior);
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, btnHeart, -10, SpringLayout.SOUTH, panelInferior);
		btnHeart.setForeground(Color.WHITE);
		btnHeart.setToolTipText("HeartModel");
		btnHeart.setBackground(new Color(30, 144, 255));
		btnHeart.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		panelInferior.add(btnHeart);
		
		JButton btnBeat = new JButton("BEAT");
		sl_panelInferior.putConstraint(SpringLayout.NORTH, btnBeat, 0, SpringLayout.NORTH, btnHeart);
		sl_panelInferior.putConstraint(SpringLayout.WEST, btnBeat, 28, SpringLayout.EAST, btnHeart);
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, btnBeat, 0, SpringLayout.SOUTH, btnHeart);
		btnBeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonBeatActionPerformed(evt);
        	}
        });
		btnBeat.setForeground(Color.WHITE);
		btnBeat.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		btnBeat.setBackground(new Color(30, 144, 255));
		panelInferior.add(btnBeat);
		
		JButton btnVistacomb = new JButton("SCC");
		sl_panelInferior.putConstraint(SpringLayout.WEST, btnVistacomb, 287, SpringLayout.WEST, panelInferior);
		sl_panelInferior.putConstraint(SpringLayout.EAST, btnBeat, -29, SpringLayout.WEST, btnVistacomb);
		sl_panelInferior.putConstraint(SpringLayout.NORTH, btnVistacomb, 0, SpringLayout.NORTH, btnHeart);
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, btnVistacomb, 0, SpringLayout.SOUTH, btnHeart);
		sl_panelInferior.putConstraint(SpringLayout.EAST, btnVistacomb, -156, SpringLayout.EAST, panelInferior);
		btnVistacomb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonSccActionPerformed(evt);
        	}
        });
		
		btnVistacomb.setForeground(Color.WHITE);
		btnVistacomb.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		btnVistacomb.setBackground(new Color(30, 144, 255));
		panelInferior.add(btnVistacomb);
		
		Label txtModelosBase = new Label("MODELOS BASE DEL PROYECTO");
		sl_panelInferior.putConstraint(SpringLayout.WEST, txtModelosBase, 0, SpringLayout.WEST, btnBeat);
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, txtModelosBase, -3, SpringLayout.NORTH, btnBeat);
		txtModelosBase.setFont(new Font("Lucida Bright", Font.PLAIN, 17));
		txtModelosBase.setAlignment(Label.CENTER);
		panelInferior.add(txtModelosBase);
		
		JButton button = new JButton("3VISTAS");
		sl_panelInferior.putConstraint(SpringLayout.NORTH, button, 0, SpringLayout.NORTH, btnHeart);
		sl_panelInferior.putConstraint(SpringLayout.WEST, button, 23, SpringLayout.EAST, btnVistacomb);
		sl_panelInferior.putConstraint(SpringLayout.SOUTH, button, -10, SpringLayout.SOUTH, panelInferior);
		sl_panelInferior.putConstraint(SpringLayout.EAST, button, -23, SpringLayout.EAST, panelInferior);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		button.setBackground(new Color(30, 144, 255));
		panelInferior.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boton3VistasActionPerformed(evt);}
		});
		
		//progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, controlador.sccview.barra, -153, SpringLayout.NORTH, panelInferior);
		springLayout.putConstraint(SpringLayout.WEST, controlador.sccview.barra, 71, SpringLayout.EAST, panelIzquierdo);
		springLayout.putConstraint(SpringLayout.SOUTH, controlador.sccview.barra, -100, SpringLayout.NORTH, panelInferior);
		springLayout.putConstraint(SpringLayout.EAST, controlador.sccview.barra, -69, SpringLayout.WEST, panelDerecho);
		frmSdaTrabajo.getContentPane().add(controlador.sccview.barra);
		
		
		JButton btnCintamatrix = new JButton("CintaMatrix");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCintamatrix, -117, SpringLayout.SOUTH, frmSdaTrabajo.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnCintamatrix, -220, SpringLayout.WEST, panelDerecho);
		springLayout.putConstraint(SpringLayout.NORTH, panelInferior, 6, SpringLayout.SOUTH, btnCintamatrix);
		btnCintamatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonCintaMActionPerformed(evt);
        	}
        });
		frmSdaTrabajo.getContentPane().add(btnCintamatrix);
		btnCintamatrix.setToolTipText("HeartModel");
		btnCintamatrix.setForeground(Color.WHITE);
		btnCintamatrix.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 15));
		btnCintamatrix.setBackground(new Color(30, 144, 255));
		}		
		//------------------------------------------------------------------------
		
		private void botonHeartActionPerformed(java.awt.event.ActionEvent evt) {
            
		modeloHeart = HeartModel.getInstancia();
		controladorHeart = new HeartController((HeartModel) modeloHeart);    
		  }
		    
		private void botonBeatActionPerformed(java.awt.event.ActionEvent evt){
		modeloBeat = new BeatModel();
		controladorBeat = new BeatController(modeloBeat);	
		  }
		    
		private void botonSccActionPerformed(java.awt.event.ActionEvent evt){
		modeloScc = new SccModel();
		controladorScc = new SccController(modeloScc, false);	
		  }
		    
		private void botonCintaMActionPerformed(java.awt.event.ActionEvent evt){
		
		 }
		    
		private void boton3VistasActionPerformed(java.awt.event.ActionEvent evt){
			MultiplesView vista = new MultiplesView();
		    vista.createView();
		    vista.createControls();
		  }
		
		private void VisitarSitioActionPerformed(java.awt.event.ActionEvent evt) throws IOException, URISyntaxException{
			if(Desktop.isDesktopSupported())
			{
			  Desktop.getDesktop().browse(new URI("http://zimmcl.github.io/IngSoft-2016-SeDiceAtomico"));
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
}
