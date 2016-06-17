package main.java.View.SecundariaView;


import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;

public class AcercaDe {

	private JFrame frmAcercaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe window = new AcercaDe();
					window.frmAcercaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcercaDe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcercaDe = new JFrame();
		frmAcercaDe.setTitle("Acerca de...");
		frmAcercaDe.setResizable(false);
		frmAcercaDe.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmAcercaDe.setAlwaysOnTop(true);
		frmAcercaDe.setBounds(100, 100, 620, 300);
		SpringLayout springLayout = new SpringLayout();
		frmAcercaDe.getContentPane().setLayout(springLayout);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmAcercaDe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmAcercaDe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 261, SpringLayout.NORTH, frmAcercaDe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frmAcercaDe.getContentPane());
		panel.setBackground(Color.WHITE);
		frmAcercaDe.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JTextPane txtpnSeDiceAtmico = new JTextPane();
		txtpnSeDiceAtmico.setEditable(false);
		sl_panel.putConstraint(SpringLayout.WEST, txtpnSeDiceAtmico, 189, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtpnSeDiceAtmico, -10, SpringLayout.EAST, panel);
		txtpnSeDiceAtmico.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		txtpnSeDiceAtmico.setForeground(Color.BLUE);
		sl_panel.putConstraint(SpringLayout.NORTH, txtpnSeDiceAtmico, 10, SpringLayout.NORTH, panel);
		txtpnSeDiceAtmico.setText("Se Dice At\u00F3mico\r\n\r\n(c) Copyright SDA contribuidores 2016. Todos los derechos reservados. \r\nSDA y el logo SDA son marcas registradas, http://zimmcl.github.io/IngSoft-2016-SeDiceAtomico.  \r\n\r\nVersi\u00F3n:\t\t      Scc.1 Release (1.1.0)\r\nFecha de publicaci\u00F3n:\t      Junio 20, 2016");
		panel.add(txtpnSeDiceAtmico);
		
		JLabel lblImagen = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblImagen, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblImagen, -6, SpringLayout.WEST, txtpnSeDiceAtmico);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtpnSeDiceAtmico, 0, SpringLayout.SOUTH, lblImagen);
		sl_panel.putConstraint(SpringLayout.NORTH, lblImagen, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblImagen, -53, SpringLayout.SOUTH, panel);
		lblImagen.setIcon(new ImageIcon(AcercaDe.class.getResource("/imagenes/Se_dice_Atomico.jpg")));
		panel.add(lblImagen);
	}
}
