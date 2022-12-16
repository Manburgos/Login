package Formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mantenimiento.GestionUsuario;
import bean.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginJForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJForm frame = new LoginJForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginJForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(55, 87, 34, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setBounds(37, 139, 52, 13);
		contentPane.add(lblNewLabel_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(162, 87, 96, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(162, 139, 96, 19);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salir();
				
			}
		});
		btnNewButton.setBounds(68, 194, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ingresar();
			}
		});
		btnNewButton_1.setBounds(174, 194, 85, 21);
		contentPane.add(btnNewButton_1);
	}

	protected void ingresar() {
	
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtPass.getPassword());
		
		GestionUsuario gestionusuario = new GestionUsuario();
		
		Usuario usu = new Usuario();
		
		usu.setUsuario(usuario);
		usu.setClave(clave);
		
		Usuario user = gestionusuario.obtenerUsuario(usu);
		
		if (user!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			this.dispose();
			
			BienvenidoJf bienvenida = new BienvenidoJf();
			bienvenida.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error 2",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void salir() {
		System.exit(0);
	}
}
