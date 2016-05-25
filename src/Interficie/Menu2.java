package Interficie;
//@author Albert Ripol
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import java.awt.Font;

public class Menu2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEligeUnaAccin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 frame = new Menu2();
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
	public Menu2() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnCrear = new JToggleButton("Crear");
		btnCrear.setBounds(44, 68, 150, 50);
		contentPane.add(btnCrear);
		
		JToggleButton btnConsultar = new JToggleButton("Consultar");
		btnConsultar.setBounds(244, 68, 150, 50);
		contentPane.add(btnConsultar);
		
		JToggleButton btnBorrar = new JToggleButton("Borrar");
		btnBorrar.setBounds(44, 133, 150, 50);
		contentPane.add(btnBorrar);
		
		JToggleButton btnModificar = new JToggleButton("Modificar");
		btnModificar.setBounds(244, 133, 150, 50);
		contentPane.add(btnModificar);
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnConsultar.isSelected() ) btnConsultar.setSelected(false); ;
				if(btnBorrar.isSelected()) btnBorrar.setSelected(false);
				if(btnModificar.isSelected()) btnModificar.setSelected(false);
			}
		});
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrear.isSelected() ) btnCrear.setSelected(false);
				if(btnBorrar.isSelected()) btnBorrar.setSelected(false);
				if(btnModificar.isSelected()) btnModificar.setSelected(false);
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrear.isSelected()) btnCrear.setSelected(false);
				if(btnConsultar.isSelected() ) btnConsultar.setSelected(false);
				if(btnModificar.isSelected()) btnModificar.setSelected(false);
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrear.isSelected()) btnCrear.setSelected(false);
				if(btnConsultar.isSelected() ) btnConsultar.setSelected(false);
				if(btnBorrar.isSelected()) btnBorrar.setSelected(false);
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrear.isSelected()){
					ControladorInterficie.setMenu2("Crear");
					ControladorInterficie.VistaElementos3();
					dispose();
				}
				if(btnConsultar.isSelected()){
					ControladorInterficie.setMenu2("Consultar");
					ControladorInterficie.VistaElementos3();
					dispose();
				}
				if(btnModificar.isSelected()){
					ControladorInterficie.setMenu2("Modificar");
					ControladorInterficie.VistaElementos3();
					dispose();
				}
				if(btnBorrar.isSelected()) {
					ControladorInterficie.setMenu2("Borrar");
					ControladorInterficie.VistaElementos3();
					dispose();
				}
				
			}
		});
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		txtEligeUnaAccin = new JTextField();
		txtEligeUnaAccin.setEditable(false);
		txtEligeUnaAccin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEligeUnaAccin.setText("Elige una acci\u00F3n");
		txtEligeUnaAccin.setBounds(153, 11, 120, 30);
		contentPane.add(txtEligeUnaAccin);
		txtEligeUnaAccin.setColumns(10);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaGrafo8();
				dispose();
			}
		});
	}
}

