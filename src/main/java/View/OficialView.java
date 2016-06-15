package main.java.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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

import main.java.Class.Persona;
import main.java.Controller.BeatController;
import main.java.Controller.HeartController;
import main.java.Controller.SccController;
import main.java.Model.BeatModel;
import main.java.Model.HeartModel;
import main.java.Model.SccModel;
import main.java.View.SecundariaView.CargarPersona;
import main.java.View.SecundariaView.NuevaPersona;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

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
	SccController controladorCinta;
	JCheckBoxMenuItem chckbxmntmHeartmodel;
	JCheckBoxMenuItem chckbxmntmBeatmodel;
	JCheckBoxMenuItem chckbxmntmSccmodel;
	JCheckBoxMenuItem chckbxmntmMultiplesview;
	JMenuItem mntmEncender;
	JMenuItem mntmPausar;
	static JButton btnIniciar;
	Persona persona;
	JPanel panelAnimacion;
	static JLabel lblUsuarioPropio;
	static JLabel lblEdadPropia;
	static JLabel lblPesoPropio;
	static JLabel lblCaloriaPropia;
	static JLabel lblTiempoPropio;
	static JPanel panelDistancia;
	static JPanel panelVelocidad;
	static JLabel lblVel;
	static JLabel lblBarra;
	static JButton btnOn;
	static JButton btnOff;
	static JButton btnAtras;
	static JButton btnPausa;
	static JButton btnAvanzar;
	private static JTextField textFieldVelocidad;
	private static JTextField textFieldBarra;
	JPanel panelBarraProgreso;
	Clip sonido;
	BufferedInputStream bis;
	private JMenuItem mntmApagar;
	private JSeparator separator_3;
	private JMenu mnCintamatrixSkin;
	private JMenuItem mntmSkinA;
	private JMenuItem mntmSkinB;
	private JMenuItem mntmSkinC;
	private JMenuItem mntmSkinD;
	

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
		
		SccModel modelo=new SccModel();
		modeloCintaM=modelo;
    	controladorCinta=new SccController(modelo, true);
    	controladorCinta.sccview.app.dispose();
		
    	
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
		
		JMenuItem mntmGuardarPersona = new JMenuItem("Guardar");
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
		mnCintamatrixSkin.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnModelos.add(mnCintamatrixSkin);
		
		mntmSkinA = new JMenuItem("Skin A");
		mntmSkinA.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mnCintamatrixSkin.add(mntmSkinA);
		
		mntmSkinB = new JMenuItem("Skin B");
		mntmSkinB.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mnCintamatrixSkin.add(mntmSkinB);
		
		mntmSkinC = new JMenuItem("Skin C");
		mntmSkinC.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mnCintamatrixSkin.add(mntmSkinC);
		
		mntmSkinD = new JMenuItem("Skin D");
		mntmSkinD.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		mnCintamatrixSkin.add(mntmSkinD);
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
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/system_help.png")));
		mntmAyuda.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmAyuda);
		
		JSeparator separator_1 = new JSeparator();
		mnAyuda.add(separator_1);
		
		JMenuItem mntmAdquirirVersinPro = new JMenuItem("Adquirir Versi\u00F3n PRO");
		mntmAdquirirVersinPro.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/balloon_yellow.gif")));
		mntmAdquirirVersinPro.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmAdquirirVersinPro);
		
		JMenuItem mntmIngresarLicencia = new JMenuItem("Ingresar Licencia");
		mntmIngresarLicencia.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/icon-key-orange.gif")));
		mntmIngresarLicencia.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmIngresarLicencia);
		
		JSeparator separator_2 = new JSeparator();
		mnAyuda.add(separator_2);
		
		JMenuItem mntmVisitarSitioWeb = new JMenuItem("Visitar sitio Web");
		mntmVisitarSitioWeb.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/web.png")));
		mntmVisitarSitioWeb.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmVisitarSitioWeb);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		mnAyuda.add(mntmAcercaDe);
		
		JLabel lblActivado = new JLabel("PRO");
		lblActivado.setForeground(new Color(255, 204, 0));
		lblActivado.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblActivado.setVisible(false);
		lblActivado.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(lblActivado);
		
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
		lblEdad.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		lblEdadPropia = new JLabel("<edad>");
		lblEdadPropia.setVisible(false);
		lblEdadPropia.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		lblPesoPropio = new JLabel("<peso>");
		lblPesoPropio.setVisible(false);
		lblPesoPropio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblCalorias = new JLabel("Calorias:");
		lblCalorias.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		lblCaloriaPropia = new JLabel("<calorias>");
		lblCaloriaPropia.setVisible(false);
		lblCaloriaPropia.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		lblTiempoPropio = new JLabel("<tiempo>");
		lblTiempoPropio.setVisible(false);
		lblTiempoPropio.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		
		panelBarraProgreso = new JPanel();
		panelBarraProgreso.add(controladorCinta.sccview.barra);
		
		panelDistancia = new JPanel();
		panelDistancia.setVisible(false);
		
		panelVelocidad = new JPanel();
		panelVelocidad.setVisible(false);
		
		JButton btnActualizarEstado = new JButton("Actualizar");
		btnActualizarEstado.setIcon(new ImageIcon(OficialView.class.getResource("/imagenes/view_refresh.png")));
		btnActualizarEstado.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		btnActualizarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnActualizarEstadoActionPerformed(evt);
        	}
        });
		//-------------------------------------------------------------------------------
		groupLayout = new GroupLayout(frmSdatrabajoFinalIngenieria.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(internalFrameCintaMatrix, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblUsuario)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblUsuarioPropio))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblEdadPropia, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(lblPesoPropio, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblVelocidad)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(panelVelocidad, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblTiempo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblTiempoPropio, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
													.addComponent(panelBarraProgreso, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
													.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
															.addComponent(lblCalorias, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
														.addGap(6)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addGroup(groupLayout.createSequentialGroup()
																.addComponent(panelDistancia, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
																.addGap(18))
															.addComponent(lblCaloriaPropia, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))))))))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnIniciar, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
									.addGap(4))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnActualizarEstado)
							.addGap(51)
							.addComponent(lblCintamatrix, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(lblVisualizacinDeModelos))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(internalFrameMultiples, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(internalFrameScc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
								.addComponent(internalFrameBeat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
								.addComponent(internalFrameHeart, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblVisualizacinDeModelos)
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(internalFrameHeart, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(internalFrameBeat, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
								.addComponent(internalFrameMultiples, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(internalFrameScc, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
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
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelDistancia, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCalorias, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCaloriaPropia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVelocidad, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelVelocidad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTiempo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTiempoPropio, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(179)))
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCintamatrix, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnActualizarEstado, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnIniciar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelBarraProgreso, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addComponent(internalFrameCintaMatrix, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		
		panelVelocidad.add(controladorCinta.sccview.vel);
		
		panelDistancia.add(controladorCinta.sccview.metr);
		
		panelAnimacion = new JPanel();
		
		//-----Boton ON-----------
		btnOn = new JButton("ON");
		btnOn.setEnabled(false);
		btnOn.setVisible(false);
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnOnActionPerformed(evt);
        	}
        });
		btnOn.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		//------
		//------Boton OFF----------
		btnOff = new JButton("OFF");
		btnOff.setEnabled(false);
		btnOff.setVisible(false);
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnOffActionPerformed(evt);
        	}
        });
		btnOff.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		//------
		//------Boton Atras-------
		btnAtras = new JButton("<<");
		btnAtras.setEnabled(false);
		btnAtras.setVisible(false);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnAtrasActionPerformed(evt);
        	}
        });
		btnAtras.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		//------
		//------Boton Pausa-------
		btnPausa = new JButton("| |");
		btnPausa.setEnabled(false);
		btnPausa.setVisible(false);
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnPausaActionPerformed(evt);
        	}
        });
		btnPausa.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		//------
		//------Boton Avanzar------
		btnAvanzar = new JButton(">>");
		btnAvanzar.setEnabled(false);
		btnAvanzar.setVisible(false);
		btnAvanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnAvanzarActionPerformed(evt);
        	}
        });
		btnAvanzar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		//------
		//------Campo Velocidad------------------
		textFieldVelocidad = new JTextField();
		textFieldVelocidad.setEnabled(false);
		textFieldVelocidad.setVisible(false);
		textFieldVelocidad.setColumns(10);
		textFieldVelocidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnSetVelActionPerformed(evt);
        	}
        });
		//------
		lblVel = new JLabel("Velocidad");
		lblVel.setEnabled(false);
		lblVel.setVisible(false);
		lblVel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
		//------Campo Barra Progreso-------------
		textFieldBarra = new JTextField();
		textFieldBarra.setEnabled(false);
		textFieldBarra.setVisible(false);
		textFieldBarra.setColumns(10);
		textFieldBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		btnSetBarraActionPerformed(evt);
        	}
        });
		//-------
		lblBarra = new JLabel("Barra");
		lblBarra.setEnabled(false);
		lblBarra.setVisible(false);
		lblBarra.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
		GroupLayout groupLayout_1 = new GroupLayout(internalFrameCintaMatrix.getContentPane());
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(274)
							.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout_1.createParallelGroup(Alignment.LEADING)
										.addComponent(btnOn, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
										.addComponent(textFieldVelocidad, 0, 0, Short.MAX_VALUE)
										.addGroup(groupLayout_1.createSequentialGroup()
											.addGap(10)
											.addComponent(lblVel))
										.addComponent(btnOff, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
										.addComponent(textFieldBarra, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addGap(28)
									.addComponent(lblBarra))))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAtras)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPausa, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAvanzar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelAnimacion, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(btnOn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOff)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldVelocidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldBarra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblBarra, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelAnimacion, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addGap(31)))
					.addGroup(groupLayout_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPausa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAvanzar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		internalFrameCintaMatrix.getContentPane().setLayout(groupLayout_1);
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
			modeloScc = new SccModel();
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
		@SuppressWarnings("static-access")
		private void cargarPersonaActionPerformed(ActionEvent evt){
			CargarPersona nueva = new CargarPersona();
			nueva.main(null);
		}
		//------------------------------------------------------------------------
		private void btnOnActionPerformed(ActionEvent evt){
			controladorCinta.start();
		}
		//------------------------------------------------------------------------
		private void btnOffActionPerformed(ActionEvent evt){
			controladorCinta.stop();
		}
		//------------------------------------------------------------------------
		private void btnAtrasActionPerformed(ActionEvent evt){
			controladorCinta.decreaseBPM();
		}
		//------------------------------------------------------------------------
		private void btnPausaActionPerformed(ActionEvent evt){
			controladorCinta.setPause();
		}
		//------------------------------------------------------------------------
		private void btnAvanzarActionPerformed(ActionEvent evt){
			controladorCinta.increaseBPM();
		}
		//------------------------------------------------------------------------
		private void btnSetVelActionPerformed(ActionEvent evt){
			controladorCinta.setBPM(Integer.parseInt(textFieldVelocidad.getText()));
		}
		//------------------------------------------------------------------------
		private void btnSetBarraActionPerformed(ActionEvent evt){
			controladorCinta.sccview.barra.setMaximum(Integer.parseInt(textFieldBarra.getText()));
		}
		//------------------------------------------------------------------------
		@SuppressWarnings("static-access")
		private void mntmEncenderActionPerformed(ActionEvent evt){
			sonido.start();
			sonido.loop(sonido.LOOP_CONTINUOUSLY);
		}
		//------------------------------------------------------------------------
		private void mntmPausarActionPerformed(ActionEvent evt){
			sonido.stop();
		}
		//------------------------------------------------------------------------
		private void mntmApagarActionPerformed(ActionEvent evt){
			sonido.close();
			cargamusica();
		}
		//------------------------------------------------------------------------
		private void SalirActionPerformed(ActionEvent evt){
			System.exit(0);
		}
		//------------------------------------------------------------------------
		private void btnActualizarEstadoActionPerformed(ActionEvent evt){
			if(Persona.getPersona().getEstado()){
				frmSdatrabajoFinalIngenieria.repaint();
			}
		}
		//------------------------------------------------------------------------
		private void btnIniciarActionPerformed(ActionEvent evt){
			lblVel.setEnabled(true);
			lblBarra.setEnabled(true);
			btnOn.setEnabled(true);
			btnOff.setEnabled(true);
			btnAtras.setEnabled(true);
			btnPausa.setEnabled(true);
			btnAvanzar.setEnabled(true);
			textFieldVelocidad.setEnabled(true);
			textFieldBarra.setEnabled(true);
	    	panelAnimacion.add(controladorCinta.sccview.animacion.getParent());    	
	    	lblUsuarioPropio.setText(Persona.getPersona().getNombre().toString());
	    	lblEdadPropia.setText(String.valueOf((Persona.getPersona().getEdad())));
	    	lblPesoPropio.setText(String.valueOf((Persona.getPersona().getPeso())));
	    	internalFrameCintaMatrix.repaint();
			
		}
		//---------------------------------------------------------------------------
		private void cargamusica(){
			try{
				sonido = AudioSystem.getClip();
				AudioInputStream iS = AudioSystem.getAudioInputStream(getClass().getResource("/musica/MusicaElevador.wav"));
				//sonido.open(AudioSystem.getAudioInputStream(new File("src/musica/MusicaElevador.wav")));
				//bis = new BufferedInputStream(getClass().getResourceAsStream("/src/musica/MusicaElevador.wav"));
		    	//AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
		    	sonido.open(iS);
			}catch(UnsupportedAudioFileException | LineUnavailableException | IOException e){System.out.println(e);
			}
		}
		//------------------------------------------------------------
		public static void refrescar(){
			if(Persona.getPersona().getEstado()){
				btnIniciar.setEnabled(true);
				lblUsuarioPropio.setVisible(true);
				lblEdadPropia.setVisible(true);
				lblPesoPropio.setVisible(true);
				lblCaloriaPropia.setVisible(true);
				lblTiempoPropio.setVisible(true);
				lblVel.setVisible(true);
				lblBarra.setVisible(true);
				btnOn.setVisible(true);
				btnOff.setVisible(true);
				btnAtras.setVisible(true);
				btnPausa.setVisible(true);
				btnAvanzar.setVisible(true);
				textFieldVelocidad.setVisible(true);
				textFieldBarra.setVisible(true);
				panelDistancia.setVisible(true);
				panelVelocidad.setVisible(true);
			}
		}
}
