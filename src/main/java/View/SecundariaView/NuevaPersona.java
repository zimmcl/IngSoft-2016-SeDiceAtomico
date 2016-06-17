package main.java.View.SecundariaView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import main.java.Class.Persona;
import main.java.View.OficialView;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;


public class NuevaPersona {

	private JFrame frmNuevoUsuario;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldPeso;
	FileWriter fichero;
	JLabel lblExito;
	JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaPersona window = new NuevaPersona();
					window.frmNuevoUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevaPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoUsuario = new JFrame();
		frmNuevoUsuario.setResizable(false);
		frmNuevoUsuario.setTitle("Nuevo Usuario");
		frmNuevoUsuario.setBounds(100, 100, 450, 300);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		
		JLabel lvlEdad = new JLabel("Edad:");
		lvlEdad.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		
		JLabel lblTexto = new JLabel("Ingrese los siguientes datos para generar su usuario");
		lblTexto.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		//-----Boton Aceptar------
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
        		botonAceptarActionPerformed(evt);
        	}
        });
		btnAceptar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		//-----
		//----Boton Cancelar------
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				botonCancelarActionPerformed(evt);
			}
		});
		btnSalir.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		
		lblExito = new JLabel("Usuario creado con exito");
		lblExito.setVisible(false);
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		
		lblError = new JLabel("Complete todos los campos");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setVisible(false);
		lblError.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		
		//----------------------------------------------------------------------------
		GroupLayout groupLayout = new GroupLayout(frmNuevoUsuario.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTexto)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lvlEdad, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldPeso, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addComponent(textFieldEdad, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblExito)
									.addGap(27)
									.addComponent(lblError))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAceptar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addGap(57))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTexto)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lvlEdad, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEdad, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeso, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPeso, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExito)
						.addComponent(lblError))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar))
					.addGap(23))
		);
		frmNuevoUsuario.getContentPane().setLayout(groupLayout);
	}
	
	//----------------------------------------------------------------------------------------
	private void botonAceptarActionPerformed(ActionEvent evt){
		if(textFieldNombre.getText().equals("") || textFieldEdad.getText().equals("") || textFieldPeso.getText().equals("")){
			lblError.setVisible(true);
		}else{
			
			 try
			 {
			  String nombre="";
			  JFileChooser file=new JFileChooser();
			  file.showSaveDialog(null);
			  File guarda =file.getSelectedFile();
			 
			  if(guarda !=null)
			  {
			    FileWriter  save=new FileWriter(guarda+".txt");
			    PrintWriter pw = new PrintWriter(save);
		        pw.println(textFieldNombre.getText());
	            pw.println(textFieldEdad.getText());
	            pw.println(textFieldPeso.getText());
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
		Persona.crearPersona(textFieldNombre.getText(),Double.parseDouble(textFieldPeso.getText()),Integer.parseInt(textFieldEdad.getText()));
		lblError.setVisible(false);
		lblExito.setVisible(true);
		textFieldNombre.setText("");
		textFieldEdad.setText("");
		textFieldPeso.setText("");
		OficialView.refrescar();
		}
	
	//---------------------------------------------------------------
	private void botonCancelarActionPerformed(ActionEvent evt){
		frmNuevoUsuario.dispose(); 
	}
}
