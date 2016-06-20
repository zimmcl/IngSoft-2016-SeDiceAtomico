package main.java.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import main.java.Class.Archivador;
import main.java.Class.Persona;
import main.java.Class.Reproductor;
import main.java.Controller.BeatController;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.HeartModel;
import main.java.Model.SccModelInterface;
import main.java.Model.TemplateMethod.Abuelo;
import main.java.Model.TemplateMethod.Cazador;
import main.java.Model.TemplateMethod.Duo;
import main.java.Model.TemplateMethod.Estandar;
import main.java.Model.TemplateMethod.Fantasma;
import main.java.Model.TemplateMethod.Mani;
import main.java.Model.TemplateMethod.SccModel;
import main.java.Model.TemplateMethod.Soldado;
import main.java.View.SecundariaView.AcercaDe;
import main.java.View.SecundariaView.CargarPersona;
import main.java.View.SecundariaView.NuevaPersona;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;

@SuppressWarnings("unused")
public class OficialView {

	JFrame frmSdatrabajoFinalIngenieria;
	JInternalFrame internalFrameHeart;
	JInternalFrame internalFrameBeat;
	JInternalFrame internalFrameScc;
	JInternalFrame internalFrameMultiples;
	JInternalFrame internalFrameCintaMatrix;
	GroupLayout groupLayout;
	HeartModel modeloHeart;
	HeartController controladorHeart;
	BeatModel modeloBeat;
	SccModel modeloScc;
	SccModel modeloCintaM;
	SccController controladorScc;
	BeatController controladorBeat;
	MultiplesView multiplesView;
	SccView sccView;
	SccController controladorCinta;
	SccController controller;
	JCheckBoxMenuItem chckbxmntmHeartmodel;
	JCheckBoxMenuItem chckbxmntmBeatmodel;
	JCheckBoxMenuItem chckbxmntmSccmodel;
	JCheckBoxMenuItem chckbxmntmMultiplesview;
	JMenuItem mntmEncender;
	JMenuItem mntmPausar;
	static JButton btnIniciar;
	static JMenuItem mntmGuardarPersona;
	JButton btnAnonimo;
	Persona persona;
	static JLabel lblUsuarioPropio;
	static JLabel lblEdadPropia;
	static JLabel lblPesoPropio;
	static JLabel lblTiempoPropio;
	static JPanel panelDistancia;
	static JPanel panelVelocidad;
	static JPanel panelCalorias; 
	Clip sonido;
	BufferedInputStream bis;
	private JMenuItem mntmApagar;
	private JSeparator separator_3;
	private static JMenu mnCintamatrixSkin;
	private JMenuItem mntmSkinMani;
	private JMenuItem mntmSkinSoldado;
	private JMenuItem mntmSkinGhostBusters;
	private JMenuItem mntmAbuelo;
	private JMenuItem mntmCazador;
	private JPasswordField passwordField;
	private JMenuItem mntmDuo;
	private Archivador archivador;
	private Reproductor jukebox;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OficialView window = new OficialView();
					window.frmSdatrabajoFinalIngenieria.setVisible(true);
					window.frmSdatrabajoFinalIngenieria.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public OficialView() {
		initialize();
		cargamusica();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		jukebox = new Reproductor();	
		
		frmSdatrabajoFinalIngenieria = new JFrame();
		frmSdatrabajoFinalIngenieria.setIconImage(Toolkit.getDefaultToolkit().getImage(OficialView.class.getResource("/imagenes/Se_dice_Atomico.jpg")));
		frmSdatrabajoFinalIngenieria.setTitle("SDA-Trabajo Final Ingenieria de Software");
		frmSdatrabajoFinalIngenieria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSdatrabajoFinalIngenieria.setBounds(150, 50, 1100, 630);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		frmSdatrabajoFinalIngenieria.setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		mnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		mnInicio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		menuBar.add(mnInicio);
		//-----Nueva Persona-------
		JMenuItem mntmNuevaPersona = new JMenuItem("Nueva Persona");
		mntmNuevaPersona.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
        		nuevaPersonaActionPerformed(evt);
        	}
        });
		mntmNuevaPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnInicio.add(mntmNuevaPersona);
		//------
		//-----Cargar-------
		JMenuItem mntmCargarPersona = new JMenuItem("Cargar");
		mntmCargarPersona.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
        		cargarPersonaActionPerformed(evt);
        	}
        });
		mntmCargarPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnInicio.add(mntmCargarPersona);
		//------
		//------Guardar-------
		mntmGuardarPersona = new JMenuItem("Guardar");
		mntmGuardarPersona.setEnabled(false);
		mntmGuardarPersona.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
        		guardarPersonaActionPerformed(evt);
        	}
        });
		mntmGuardarPersona.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnInicio.add(mntmGuardarPersona);
		
		JSeparator separator = new JSeparator();
		mnInicio.add(separator);
		//-------Menu item Salir------------
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
        		SalirActionPerformed(evt);
        	}
        });
		mntmSalir.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnInicio.add(mntmSalir);
		
		JMenu mnModelos = new JMenu("Modelos");
		mnModelos.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		menuBar.add(mnModelos);
		
		//----Boton Heart-------
		chckbxmntmHeartmodel = new JCheckBoxMenuItem("HeartModel");
		chckbxmntmHeartmodel.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/heart.png")));
		chckbxmntmHeartmodel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonHeartActionPerformed(evt);
        	}
        });
		chckbxmntmHeartmodel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(chckbxmntmHeartmodel);
		//-----
		//-----Boton Beat-------
		chckbxmntmBeatmodel = new JCheckBoxMenuItem("BeatModel");
		chckbxmntmBeatmodel.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/Audio-Frequency-Icon.gif")));
		chckbxmntmBeatmodel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonBeatActionPerformed(evt);
        	}
        });
		chckbxmntmBeatmodel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(chckbxmntmBeatmodel);
		//-----
		//-----Boton Scc-------
		chckbxmntmSccmodel = new JCheckBoxMenuItem("SccModel");
		chckbxmntmSccmodel.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/BAC.gif")));
		chckbxmntmSccmodel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonSccActionPerformed(evt);
        	}
        });
		chckbxmntmSccmodel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(chckbxmntmSccmodel);
		//-----
		//-----Boton Vistas Multiples--------
		chckbxmntmMultiplesview = new JCheckBoxMenuItem("MultiplesView");
		chckbxmntmMultiplesview.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/3.gif")));
		chckbxmntmMultiplesview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonMultiplesviewActionPerformed(evt);
        	}
        });
		chckbxmntmMultiplesview.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(chckbxmntmMultiplesview);
		
		separator_3 = new JSeparator();
		mnModelos.add(separator_3);
		
		mnCintamatrixSkin = new JMenu("CintaMatrix Skin");
		mnCintamatrixSkin.setEnabled(false);
		mnCintamatrixSkin.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(mnCintamatrixSkin);
		
		mntmSkinMani = new JMenuItem("Mani Skin");
		mntmSkinMani.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mntmSkinMani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarManiActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmSkinMani);
		//----------------
		mntmSkinSoldado = new JMenuItem("Soldado Skin");
		mntmSkinSoldado.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mntmSkinSoldado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarSoldadoActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmSkinSoldado);
		//-------------------
		//-------------------
		mntmSkinGhostBusters = new JMenuItem("GhostBusters Skin");
		mntmSkinGhostBusters.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mntmSkinGhostBusters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarFantasmaActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmSkinGhostBusters);
		//-------------------
		mntmCazador = new JMenuItem("Cazador Skin");
		mntmCazador.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mntmCazador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarCazadorActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmCazador);
		//--------------------
		//--------------------
		mntmAbuelo = new JMenuItem("Abuelo Skin");
		mntmAbuelo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mntmAbuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarAbueloActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmAbuelo);
		//---------------------
		mntmDuo = new JMenuItem("Bonus");
		mntmDuo.setVisible(false);
		mntmDuo.setForeground(Color.BLUE);
		mntmDuo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mntmDuo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CambiarDuoActionPerformed(evt);
        	}
        });
		mnCintamatrixSkin.add(mntmDuo);
		//---------------------------------
		passwordField = new JPasswordField();
		passwordField.setFocusTraversalPolicyProvider(true);
		passwordField.setFocusCycleRoot(true);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				char[] valido ={'B','a','t','m','a','n'};
				char[] password = passwordField.getPassword();
	    	    if(Arrays.equals(password, valido)){
	    	    	mntmDuo.setVisible(true);
	    	    	passwordField.setEnabled(false);}  
	    	    }
	    	}
		);
		
		mnCintamatrixSkin.add(passwordField);
		//------
		JMenu mnMsica = new JMenu("M\u00FAsica");
		mnMsica.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		menuBar.add(mnMsica);
		//------Item Encender Musica---------------
		mntmEncender = new JMenuItem("Encender");
		mntmEncender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		mntmEncenderActionPerformed(evt);
        	}
        });
		mntmEncender.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMsica.add(mntmEncender);
		//--------
		//-----Item Apagar Musica---------
		mntmPausar = new JMenuItem("Pausar");
		mntmPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		mntmPausarActionPerformed(evt);
        	}
        });
		mntmPausar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMsica.add(mntmPausar);
		
		mntmApagar = new JMenuItem("Apagar");
		mntmApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		mntmApagarActionPerformed(evt);
        	}
        });
		mntmApagar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnMsica.add(mntmApagar);
		//-------
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 17));
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Contenido de Ayuda");
		mntmAyuda.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/system_help.png")));
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		try {
					ContenidoAyudaActionPerformed(evt);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
        	}
        });
		mntmAyuda.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmAyuda);
		
		JSeparator separator_1 = new JSeparator();
		mnAyuda.add(separator_1);
		
		JMenuItem mntmLicenciaGNU = new JMenuItem("Licencia P\u00FAblica General GNU");
		mntmLicenciaGNU.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/gnu.png")));
		mntmLicenciaGNU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		try {
					LicenciaGNUActionPerformed(evt);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
        	}
        });
		mntmLicenciaGNU.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmLicenciaGNU);
		
		JSeparator separator_2 = new JSeparator();
		mnAyuda.add(separator_2);
		//------------
		JMenuItem mntmVisitarSitioWeb = new JMenuItem("Visitar sitio Web");
		mntmVisitarSitioWeb.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/web.png")));
		mntmVisitarSitioWeb.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mntmVisitarSitioWeb.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		try {
					VisitarSitioActionPerformed(evt);
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
        	}
        });
		mnAyuda.add(mntmVisitarSitioWeb);
		//---------
		//--------
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		mntmAcercaDeActionPerformed(evt);
        	}
        });
		mnAyuda.add(mntmAcercaDe);
		
		//-----------------------------------------------------------------------------
		
		internalFrameHeart = new JInternalFrame("Heart Model");
		internalFrameHeart.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255)));
		internalFrameHeart.setVisible(true);
		
		internalFrameBeat = new JInternalFrame("Beat Model");
		internalFrameBeat.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255)));
		internalFrameBeat.setFocusTraversalPolicyProvider(true);
		internalFrameBeat.setFocusCycleRoot(false);
		internalFrameBeat.setVisible(true);
		
		internalFrameScc = new JInternalFrame("Scc Model");
		internalFrameScc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255)));
		internalFrameScc.setVisible(true);
		
		internalFrameMultiples = new JInternalFrame("Multiples Vistas");
		internalFrameMultiples.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(0, 0, 255)));
		internalFrameMultiples.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		
		JLabel lblVisualizacinDeModelos = new JLabel("Visualizaci\u00F3n de Modelos a partir de DJView");
		lblVisualizacinDeModelos.setForeground(new Color(0, 102, 255));
		lblVisualizacinDeModelos.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		internalFrameCintaMatrix = new JInternalFrame("Visualización");
		internalFrameCintaMatrix.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 255), new Color(255, 0, 0)));
		internalFrameCintaMatrix.setVisible(true);
		
		JLabel lblCintamatrix = new JLabel("CintaMatrix 300");
		lblCintamatrix.setForeground(new Color(0, 102, 255));
		lblCintamatrix.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		
		//-----boton Iniciar------
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setEnabled(false);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setBackground(SystemColor.textHighlight);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnIniciarActionPerformed(evt);
        	}
        });
		btnIniciar.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		//--------
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblUsuarioPropio = new JLabel("<nombre>");
		lblUsuarioPropio.setVisible(false);
		lblUsuarioPropio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblEdadPropia = new JLabel("<edad>");
		lblEdadPropia.setVisible(false);
		lblEdadPropia.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		lblPesoPropio = new JLabel("<peso>");
		lblPesoPropio.setVisible(false);
		lblPesoPropio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblCalorias = new JLabel("Calorias:");
		lblCalorias.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		
		lblTiempoPropio = new JLabel("<tiempo>");
		lblTiempoPropio.setVisible(false);
		lblTiempoPropio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		panelDistancia = new JPanel();
		panelDistancia.setMaximumSize(new Dimension(10, 10));
		panelDistancia.setVisible(false);
		
		panelVelocidad = new JPanel();
		panelVelocidad.setMaximumSize(new Dimension(10, 10));
		panelVelocidad.setVisible(false);
		
		JButton btnActualizarEstado = new JButton("Actualizar");
		btnActualizarEstado.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/view_refresh.png")));
		btnActualizarEstado.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		btnActualizarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnActualizarEstadoActionPerformed(evt);
        	}
        });
		
		panelCalorias = new JPanel();
		panelCalorias.setMaximumSize(new Dimension(10, 10));
		
		btnAnonimo = new JButton("Usuario An\u00F3nimo");
		btnAnonimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnonimoActionPerformed(evt);
			}
		});
		btnAnonimo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		//-------------------------------------------------------------------------------
		groupLayout = new GroupLayout(frmSdatrabajoFinalIngenieria.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnActualizarEstado)
							.addGap(51)
							.addComponent(lblCintamatrix, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(internalFrameCintaMatrix, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblUsuario)
												.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblCalorias, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblVelocidad)
												.addComponent(lblTiempo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
											.addGap(31)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblEdadPropia, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
												.addComponent(lblUsuarioPropio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblPesoPropio, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
												.addComponent(lblTiempoPropio, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
												.addComponent(panelVelocidad, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(panelDistancia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(panelCalorias, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnAnonimo)))))
					.addGap(99)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(internalFrameMultiples, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(internalFrameScc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(internalFrameBeat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
								.addComponent(internalFrameHeart, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(lblVisualizacinDeModelos)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblVisualizacinDeModelos)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(internalFrameHeart, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(internalFrameBeat, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addComponent(internalFrameMultiples, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(internalFrameScc, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCintamatrix, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizarEstado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(internalFrameCintaMatrix, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(lblUsuarioPropio))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEdadPropia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPesoPropio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCalorias, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelCalorias, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelDistancia, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVelocidad, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelVelocidad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTiempo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTiempoPropio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAnonimo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		internalFrameCintaMatrix.getContentPane().setLayout(new SpringLayout());
		internalFrameMultiples.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frmSdatrabajoFinalIngenieria.getContentPane().setLayout(groupLayout);
		
	}
	
		//-----------------------------------------------------------------------
		private void botonHeartActionPerformed(java.awt.event.ActionEvent evt) {
		if(chckbxmntmHeartmodel.isSelected()){
			if(modeloHeart!=null){
				internalFrameHeart.getContentPane().setVisible(true);
				controladorHeart.view.menu.setVisible(true);
			}else{
		modeloHeart = HeartModel.getInstancia();
		controladorHeart = new HeartController((HeartModel) modeloHeart);
		internalFrameHeart.setJMenuBar(controladorHeart.view.menuBar);;
		internalFrameHeart.getContentPane().add(controladorHeart.view.viewFrame.getContentPane());
		internalFrameHeart.getContentPane().add(controladorHeart.view.controlFrame.getContentPane());
		controladorHeart.view.controlFrame.dispose();
  		controladorHeart.view.viewFrame.dispose();
  		internalFrameHeart.repaint();
				}
		  }else {internalFrameHeart.getContentPane().setVisible(false);
		  controladorHeart.view.menu.setVisible(false);
		  frmSdatrabajoFinalIngenieria.repaint();}
		}
		//-----------------------------------------------------------------------
		private void botonBeatActionPerformed(java.awt.event.ActionEvent evt) {
			if(chckbxmntmBeatmodel.isSelected()){
				if(modeloBeat!=null){
					internalFrameBeat.getContentPane().setVisible(true);
					controladorBeat.view.menu.setVisible(true);
				}else{
			modeloBeat = new BeatModel();
			controladorBeat = new BeatController(modeloBeat);
			internalFrameBeat.setJMenuBar(controladorBeat.view.menuBar);;
			internalFrameBeat.getContentPane().add(controladorBeat.view.viewFrame.getContentPane());
			internalFrameBeat.getContentPane().add(controladorBeat.view.controlFrame.getContentPane());
			controladorBeat.view.controlFrame.dispose();
	  		controladorBeat.view.viewFrame.dispose();
	  		internalFrameBeat.repaint();
					}
			  }else {internalFrameBeat.getContentPane().setVisible(false);
			  controladorBeat.view.menu.setVisible(false);
			  frmSdatrabajoFinalIngenieria.repaint();}
			}
		//-----------------------------------------------------------------------
		private void botonSccActionPerformed(java.awt.event.ActionEvent evt) {
			if(chckbxmntmSccmodel.isSelected()){
				if(modeloScc!=null){
					internalFrameScc.getContentPane().setVisible(true);
					controladorScc.djview.menu.setVisible(true);
				}else{
			modeloScc = new Estandar();
			controladorScc = new SccController(modeloScc,false);
			internalFrameScc.setJMenuBar(controladorScc.djview.menuBar);;
			internalFrameScc.getContentPane().add(controladorScc.djview.viewFrame.getContentPane());
			internalFrameScc.getContentPane().add(controladorScc.djview.controlFrame.getContentPane());
			controladorScc.djview.controlFrame.dispose();
	  		controladorScc.djview.viewFrame.dispose();
	  		internalFrameScc.repaint();
					}
			  }else {internalFrameScc.getContentPane().setVisible(false);
			  controladorScc.djview.menu.setVisible(false);
			  frmSdatrabajoFinalIngenieria.repaint();}
			}
		//----------------------------------------------------------------------
		private void botonMultiplesviewActionPerformed(java.awt.event.ActionEvent evt) {
			if(chckbxmntmMultiplesview.isSelected()){
				if(multiplesView!=null){
					internalFrameMultiples.getContentPane().setVisible(true);
					multiplesView.estaView.menu.setVisible(true);
					multiplesView.estaView.strategy.setVisible(true);
				}else{
			multiplesView = new MultiplesView();
			multiplesView.createView();
			multiplesView.createControls();
			internalFrameMultiples.setJMenuBar(multiplesView.estaView.strategy);
			internalFrameMultiples.getContentPane().add(multiplesView.estaView.menuBar);
			internalFrameMultiples.getContentPane().add(multiplesView.estaView.viewFrame.getContentPane());
			internalFrameMultiples.getContentPane().add(multiplesView.estaView.controlFrame.getContentPane());
			
			multiplesView.estaView.controlFrame.dispose();
			multiplesView.estaView.viewFrame.dispose();
	  		internalFrameMultiples.repaint();
					}
			  }else {internalFrameMultiples.getContentPane().setVisible(false);
			  multiplesView.estaView.menu.setVisible(false);
			  multiplesView.estaView.strategy.setVisible(false);
			  frmSdatrabajoFinalIngenieria.repaint();}
			}
		//------------------------------------------------------------------------
		@SuppressWarnings("static-access")
		private void nuevaPersonaActionPerformed(ActionEvent evt){
			NuevaPersona nueva = new NuevaPersona();
			nueva.main(null);
		}
		//------------------------------------------------------------------------
		private void cargarPersonaActionPerformed(ActionEvent evt){
			
			archivador = new Archivador();
			String aux[] = archivador.cargar();
			Persona.crearPersona(aux[0], Double.parseDouble(aux[2]), Integer.parseInt(aux[1]));
			OficialView.refrescar();
		}
		//------------------------------------------------------------------------
		private void guardarPersonaActionPerformed(ActionEvent evt){
			
			
			try
			 {
				boolean existe = false;
			  JFileChooser file=new JFileChooser();
			  file.showSaveDialog(null);
			  
			  File guarda =file.getSelectedFile();
			  
			  File aux = new File(guarda+".txt");
			 if (aux.exists()){
				 JOptionPane.showMessageDialog(null,
				         "Advertencia. Ya existe un archivo con ese nombre",
				             "Información",JOptionPane.INFORMATION_MESSAGE);
				 existe=true;
			 }
			  
			  if((guarda !=null)&&(!existe))
			  {
			    FileWriter  save=new FileWriter(guarda+".txt");
			    PrintWriter pw = new PrintWriter(save);
		        pw.println(Persona.getPersona().getNombre());
	           pw.println(Persona.getPersona().getEdad());
	           pw.println(Persona.getPersona().getPeso());
	           
	           pw.println(controller.sccview.metr.getText());
	           pw.println(controller.sccview.cal.getText());
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
		}	
		//------------------------------------------------------------------------
		@SuppressWarnings("static-access")
		private void mntmEncenderActionPerformed(ActionEvent evt){
			jukebox.play();
		}
		//------------------------------------------------------------------------
		private void mntmPausarActionPerformed(ActionEvent evt){
			jukebox.pause();

		}
		//------------------------------------------------------------------------
		private void mntmApagarActionPerformed(ActionEvent evt){
			jukebox.turnOff();
			/*sonido.close();
			cargamusica();
			*/
		}
		//------------------------------------------------------------------------
		private void SalirActionPerformed(ActionEvent evt){
			System.exit(0);
		}
		//------------------------------------------------------------------------
		private void btnActualizarEstadoActionPerformed(ActionEvent evt){
				frmSdatrabajoFinalIngenieria.repaint();
		}
		//------------------------------------------------------------------------
		private void VisitarSitioActionPerformed(java.awt.event.ActionEvent evt) throws IOException, URISyntaxException{
			if(Desktop.isDesktopSupported())
			{
			  Desktop.getDesktop().browse(new URI("http://zimmcl.github.io/IngSoft-2016-SeDiceAtomico"));
			}
		}
		//------------------------------------------------------------------------
		private void LicenciaGNUActionPerformed(java.awt.event.ActionEvent evt) throws IOException, URISyntaxException{
			if(Desktop.isDesktopSupported())
			{
			  Desktop.getDesktop().browse(new URI("http://www.gnu.org/licenses/gpl.html"));
			}
		}
		//------------------------------------------------------------------------
		private void ContenidoAyudaActionPerformed(java.awt.event.ActionEvent evt) throws IOException, URISyntaxException{
			if(Desktop.isDesktopSupported())
			{
			  Desktop.getDesktop().browse(new URI("https://github.com/zimmcl/IngSoft-2016-SeDiceAtomico/wiki/Manual-de-Usuario"));
			}
		}
		//------------------------------------------------------------------------
		private void mntmAcercaDeActionPerformed(java.awt.event.ActionEvent evt){
			AcercaDe acerca = new AcercaDe();
			acerca.main(null);
		}
		//------------------------------------------------------------------------
		private void CambiarManiActionPerformed(ActionEvent evt){	
			internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			panelDistancia.remove(controller.sccview.metr);
			panelVelocidad.remove(controller.sccview.vel);
			panelCalorias.remove(controller.sccview.cal);
			SccModel model = new Mani();
			controller = new SccController(model,true);
			panelDistancia.add(controller.sccview.metr);
			panelVelocidad.add(controller.sccview.vel);
			panelCalorias.add(controller.sccview.cal);
			controller.sccview.app.dispose();
			internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}
		//------------------------------------------------------------------------
		private void CambiarSoldadoActionPerformed(ActionEvent evt){			
			 internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			 panelDistancia.remove(controller.sccview.metr);
			 panelVelocidad.remove(controller.sccview.vel);
			 panelCalorias.remove(controller.sccview.cal);
			 SccModel model = new Soldado();
			 controller = new SccController(model,true);
			 panelDistancia.add(controller.sccview.metr);
			 panelVelocidad.add(controller.sccview.vel);
			 panelCalorias.add(controller.sccview.cal);
			 controller.sccview.app.dispose();
			 internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}
		//------------------------------------------------------------------------
		private void CambiarCazadorActionPerformed(ActionEvent evt){
			 internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			 panelDistancia.remove(controller.sccview.metr);
			 panelVelocidad.remove(controller.sccview.vel);
			 panelCalorias.remove(controller.sccview.cal);
			 SccModel model = new Cazador();
			 controller = new SccController(model,true);
			 panelDistancia.add(controller.sccview.metr);
			 panelVelocidad.add(controller.sccview.vel);
			 panelCalorias.add(controller.sccview.cal);
			 controller.sccview.app.dispose();
			 internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}
		//------------------------------------------------------------------------
		private void CambiarFantasmaActionPerformed(ActionEvent evt){
			 internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			 panelDistancia.remove(controller.sccview.metr);
			 panelVelocidad.remove(controller.sccview.vel);
			 panelCalorias.remove(controller.sccview.cal);
			 SccModel model = new Fantasma();
			 controller = new SccController(model,true);
			 panelDistancia.add(controller.sccview.metr);
			 panelVelocidad.add(controller.sccview.vel);
			 panelCalorias.add(controller.sccview.cal);
			 controller.sccview.app.dispose();
			 internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}	
		//------------------------------------------------------------------------
		private void CambiarAbueloActionPerformed(ActionEvent evt){
			 internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			 panelDistancia.remove(controller.sccview.metr);
			 panelVelocidad.remove(controller.sccview.vel);
			 panelCalorias.remove(controller.sccview.cal);
			 SccModel model = new Abuelo();
			 controller = new SccController(model,true);
			 panelDistancia.add(controller.sccview.metr);
			 panelVelocidad.add(controller.sccview.vel);
			 panelCalorias.add(controller.sccview.cal);
			 controller.sccview.app.dispose();
			 internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}	
		//------------------------------------------------------------------------
		private void CambiarDuoActionPerformed(ActionEvent evt){
			 internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			 panelDistancia.remove(controller.sccview.metr);
			 panelVelocidad.remove(controller.sccview.vel);
			 panelCalorias.remove(controller.sccview.cal);
			 SccModel model = new Duo();
			 controller = new SccController(model,true);
			 panelDistancia.add(controller.sccview.metr);
			 panelVelocidad.add(controller.sccview.vel);
			 panelCalorias.add(controller.sccview.cal);
			 controller.sccview.app.dispose();
			 internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
		}	
		//------------------------------------------------------------------------
		private void btnIniciarActionPerformed(ActionEvent evt){
			if(controller!=null){
			internalFrameCintaMatrix.remove(controller.sccview.app.getContentPane());
			panelDistancia.remove(controller.sccview.metr);
			panelVelocidad.remove(controller.sccview.vel);
			panelCalorias.remove(controller.sccview.cal);}
			SccModel model = new Estandar();
			controller = new SccController(model,true);
			controller.sccview.app.dispose();
			panelDistancia.add(controller.sccview.metr);
			panelVelocidad.add(controller.sccview.vel);
			panelCalorias.add(controller.sccview.cal);
			//panelBarraProgreso.add(controller.sccview.barra);
			lblUsuarioPropio.setText(Persona.getPersona().getNombre());
			lblEdadPropia.setText(String.valueOf(Persona.getPersona().getEdad()));
			lblPesoPropio.setText(String.valueOf(Persona.getPersona().getPeso()));
			internalFrameCintaMatrix.getContentPane().add(controller.sccview.barraMenu);
			internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
			btnIniciar.setEnabled(false);
			btnAnonimo.setEnabled(false);
		}
		//---------------------------------------------------------------------------
		private void btnAnonimoActionPerformed(ActionEvent evt){
			SccModel model = new Estandar();
			controller = new SccController(model,true);
			controller.sccview.app.dispose();
			panelDistancia.add(controller.sccview.metr);
			panelVelocidad.add(controller.sccview.vel);
			panelCalorias.add(controller.sccview.cal);
			lblUsuarioPropio.setText("Anónimo");
			lblEdadPropia.setText("");
			lblPesoPropio.setText("");
			internalFrameCintaMatrix.getContentPane().add(controller.sccview.barraMenu);
			internalFrameCintaMatrix.getContentPane().add(controller.sccview.app.getContentPane());
			lblUsuarioPropio.setVisible(true);
			lblEdadPropia.setVisible(true);
			lblPesoPropio.setVisible(true);
			lblTiempoPropio.setVisible(true);
			panelDistancia.setVisible(true);
			panelVelocidad.setVisible(true);
			btnAnonimo.setEnabled(false);
			mntmGuardarPersona.setEnabled(false);
			
		}
		//---------------------------------------------------------------------------
		private void cargamusica(){
			
			jukebox.carga();
		}
		//------------------------------------------------------------
		public static void refrescar(){
			if(Persona.getPersona().getEstado()){
				mnCintamatrixSkin.setEnabled(true);
				btnIniciar.setEnabled(true);
				mntmGuardarPersona.setEnabled(true);
				lblUsuarioPropio.setVisible(true);
				lblEdadPropia.setVisible(true);
				lblPesoPropio.setVisible(true);
				lblTiempoPropio.setVisible(true);
				panelDistancia.setVisible(true);
				panelVelocidad.setVisible(true);
			}
		}
}
