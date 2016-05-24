package Interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Autor chus

public class ModificarPerfil23 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtNomPerfil;
	private JTextField txtNomPlantilla;
	private JTextField txtCampos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarPerfil23 frame = new ModificarPerfil23();
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
	public ModificarPerfil23() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(166, 29, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(166, 76, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		List list = new List();
		list.setBounds(155, 117, 110, 109);
		MouseListener mouseListener = new MouseAdapter() {
		      public void mouseClicked(MouseEvent mouseEvent) {
		    	  int indice = list.getSelectedIndex();
		    	  String nomCamp = list.getSelectedItem();
		    	  
		      }
		};
		list.addMouseListener(mouseListener);
		contentPane.add(list);
		list.add("mameluco");

		txtNomPerfil = new JTextField();
		txtNomPerfil.setEditable(false);
		txtNomPerfil.setText("Nom Perfil");
		txtNomPerfil.setBounds(66, 29, 86, 20);
		contentPane.add(txtNomPerfil);
		txtNomPerfil.setColumns(10);
		
		txtNomPlantilla = new JTextField();
		txtNomPlantilla.setEditable(false);
		txtNomPlantilla.setText("Nom Plantilla");
		txtNomPlantilla.setBounds(66, 76, 86, 20);
		contentPane.add(txtNomPlantilla);
		txtNomPlantilla.setColumns(10);
		
		txtCampos = new JTextField();
		txtCampos.setEditable(false);
		txtCampos.setText("Campos");
		txtCampos.setBounds(66, 117, 60, 20);
		contentPane.add(txtCampos);
		txtCampos.setColumns(10);
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ControladorInterficie.setElement3((""));
				ControladorInterficie.VistaMenu2();
				dispose();
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorInterficie.VistaSLPlantilla16();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
	}
}
