package main.java.View.SecundariaView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import main.java.Class.Persona;
import main.java.View.OficialView;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CargarPersona {

	private JFrame frame;
	private JTextField textFieldNombre;
	FileReader filered;
    BufferedReader buffred;
	JLabel lblError;
	JLabel lblExito;
	Persona persona;
	OficialView oficial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarPersona window = new CargarPersona();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CargarPersona() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 235);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre a buscar");
		lblIngreseElNombre.setFont(new Font("Sitka Small", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					botonCargarActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCargar.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		//-----Boton Cancelar------------
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				botonCancelarActionPerformed(evt);
			}
		});
		btnSalir.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		//------
		lblExito = new JLabel("Carga exitosa");
		lblExito.setVisible(false);
		lblExito.setForeground(new Color(0, 128, 0));
		lblExito.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		
		lblError = new JLabel("Usuario no encontrado");
		lblError.setVisible(false);
		lblError.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		lblError.setForeground(new Color(255, 0, 0));
		
		//----------------------------------------------------------------------------------
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseElNombre, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblExito)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblError))))))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIngreseElNombre, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExito)
						.addComponent(lblError))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCargar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	//-----------------------------------------------------------------------------------
	private void botonCancelarActionPerformed(ActionEvent evt){
		frame.dispose(); 
	}
	//----------------------------------------------------------------------------------
	@SuppressWarnings("resource")
	private void botonCargarActionPerformed(ActionEvent evt) throws IOException{
		  
		File archivo = new File("C:\\Users\\Ezequiel\\Desktop",textFieldNombre.getText()+".txt");
		if(textFieldNombre.getText().equals("")||(!archivo.exists())){
			lblError.setVisible(true);
		}else{
		boolean fin = false;
		int i=0;
		String linea;
		String[] cadena = new String[3];
		FileReader fichero=new FileReader(archivo);
		BufferedReader buffer = new BufferedReader(fichero);
		StringBuffer sbf = new StringBuffer();
		while(fin == false){
			linea = buffer.readLine();
			if(linea != null){
				cadena[i]=linea;
				sbf.append(linea + "\n");
				i++;
			}else{
				fin = true;
				Persona.crearPersona(cadena[0], Double.parseDouble(cadena[2]), Integer.parseInt(cadena[1]));
				lblError.setVisible(false);
				lblExito.setVisible(true);
				textFieldNombre.setText("");
				OficialView.refrescar();
						}
				}
			}
		}
	}
