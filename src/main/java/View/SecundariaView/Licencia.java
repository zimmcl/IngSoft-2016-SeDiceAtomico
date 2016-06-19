package main.java.View.SecundariaView;

import javax.swing.SpringLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class Licencia {

	private JDialog frmIntroducirClaveDe;
	private JTextField textField;
	private Label label_1;
	private JTextField textField_1;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextPane txtpnClaveActivadaCon;
	private JTextPane txtpnClaveNoValida;
	private JTextField clave;
	private File serial;
	private FileWriter escribir;
	private PrintWriter printW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Licencia window = new Licencia();
					window.frmIntroducirClaveDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Licencia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clave = new JTextField("X7LL-45T8-10ÑP-4R44");
		serial = new File("serial.txt");
		try{
		escribir = new FileWriter(serial,true);
		}catch(Exception e){}
		
		frmIntroducirClaveDe = new JDialog();
		frmIntroducirClaveDe.setModal(true);
		frmIntroducirClaveDe.setResizable(false);
		frmIntroducirClaveDe.setTitle("Introducir Clave de Licencia");
		frmIntroducirClaveDe.setBounds(100, 100, 404, 285);
		SpringLayout springLayout = new SpringLayout();
		frmIntroducirClaveDe.getContentPane().setLayout(springLayout);
		
		Panel panel = new Panel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frmIntroducirClaveDe.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frmIntroducirClaveDe.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 246, SpringLayout.NORTH, frmIntroducirClaveDe.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frmIntroducirClaveDe.getContentPane());
		panel.setBackground(Color.WHITE);
		frmIntroducirClaveDe.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		Label label = new Label("Nombre de Usuario:");
		label.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		sl_panel.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 31, SpringLayout.WEST, panel);
		panel.add(label);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -32, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		label_1 = new Label("Clave de Licencia:");
		sl_panel.putConstraint(SpringLayout.NORTH, label_1, 94, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		panel.add(label_1);
		
		textField_1 = new JTextField();
		
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, label_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 31, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, 43, SpringLayout.SOUTH, label_1);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		AceptarPerformed(evt);
        	}	
        });	
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		CancelarPerformed(evt);
        	}	
        });		
        sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, btnCancelar);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnCancelar, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, btnAceptar, 0, SpringLayout.NORTH, btnCancelar);
		sl_panel.putConstraint(SpringLayout.EAST, btnAceptar, -6, SpringLayout.WEST, btnCancelar);
		sl_panel.putConstraint(SpringLayout.EAST, btnCancelar, -32, SpringLayout.EAST, panel);
		panel.add(btnCancelar);
		
		txtpnClaveActivadaCon = new JTextPane();
		txtpnClaveActivadaCon.setForeground(Color.WHITE);
		txtpnClaveActivadaCon.setFont(new Font("SansSerif", Font.PLAIN, 12));
		sl_panel.putConstraint(SpringLayout.NORTH, txtpnClaveActivadaCon, 6, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, txtpnClaveActivadaCon, 0, SpringLayout.WEST, label);
		txtpnClaveActivadaCon.setText("Clave Activada con Exito");
		panel.add(txtpnClaveActivadaCon);
		
		txtpnClaveNoValida = new JTextPane();
		txtpnClaveNoValida.setForeground(Color.WHITE);
		txtpnClaveNoValida.setFont(new Font("SansSerif", Font.PLAIN, 12));
		sl_panel.putConstraint(SpringLayout.NORTH, txtpnClaveNoValida, 6, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, txtpnClaveNoValida, 0, SpringLayout.EAST, textField);
		txtpnClaveNoValida.setText("Clave no valida");
		panel.add(txtpnClaveNoValida);
		}
	
		private void CancelarPerformed(ActionEvent evt) {
		 
			frmIntroducirClaveDe.dispose();
		}
		
		private void AceptarPerformed(ActionEvent evt) {
			 
			if(textField_1.getText().equals(clave.getText())){
				txtpnClaveActivadaCon.setForeground(Color.GREEN);
				try{
					escribir = new FileWriter("C:/Users/Ezequiel/Desktop/serial.txt");
					printW = new PrintWriter(escribir);
					printW.println(clave.getText());
					printW.print(textField.getText());
					escribir.close();
					textField_1.setEditable(false);
					btnAceptar.setText("Salir");
					}catch(Exception e){}
							
			}else{
				txtpnClaveNoValida.setForeground(Color.RED);
			}
		}
			
		
}
