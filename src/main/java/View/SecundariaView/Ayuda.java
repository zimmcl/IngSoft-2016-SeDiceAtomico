package main.java.View.SecundariaView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import java.nio.channels.Selector;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.Color;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Choice;

public class Ayuda implements TreeSelectionListener {

	private JFrame frmAyuda;
	private JTextField txtPantallaPrincipal;
	JPanel panel;
	JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ayuda window = new Ayuda();
					window.frmAyuda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ayuda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAyuda = new JFrame();
		frmAyuda.setTitle("Ayuda");
		frmAyuda.setBounds(100, 100, 650, 625);
		frmAyuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.WHITE));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.WHITE));
		GroupLayout groupLayout = new GroupLayout(frmAyuda.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, Alignment.LEADING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 223, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 557, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JTextPane txtInicio = new JTextPane();
		txtInicio.setEditable(false);
		txtInicio.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		txtInicio.setText("  Cuando inicia la aplicaci\u00F3n, lo primero que se ve es una ventana dividida en dos secciones. "
				+ "La secci\u00F3n de la izquierda le permitir\u00E1 visualizar el comportamiento de la CintaMatrix 300;"
				+ " mientras que la secci\u00F3n derecha, mostrar\u00E1 el funcionamiento de los modelos HeartModel, BeatModel, SccModel. \n"
				+ "Por ahora, simplemente haga clic en USUARIO AN\u00D3NIMO para una muestra del funcionamiento de la aplicaci\u00F3n. "
				+ "Paso siguiente interactue con los botones ON y OFF para encendar y apagar la cinta respectivamente. \n\n"
				+ "  Si ésta es su primera vez usando la aplicación, haga clic en la opción INICIO del menú y luego elija NUEVA PERSONA. "
				+ "Complete todos los campos, precione ACEPTAR y luego fije el destino y el nombre del archivo que guardará su estado de actividad.\n"
				+ "Si el guardado del archivo fue existo, notará que se habilitó la opción INICIAR. Haga clic ahí y comienze a disfrutar de una actividad física simulada.");
		scrollPane.setViewportView(txtInicio);
		
		txtPantallaPrincipal = new JTextField();
		txtPantallaPrincipal.setEditable(false);
		txtPantallaPrincipal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, Color.WHITE));
		txtPantallaPrincipal.setForeground(Color.BLUE);
		txtPantallaPrincipal.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		txtPantallaPrincipal.setText("Pantalla Principal");
		scrollPane.setColumnHeaderView(txtPantallaPrincipal);
		txtPantallaPrincipal.setColumns(10);
		frmAyuda.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
