package Interficie;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
@SuppressWarnings("serial")
public class Plantilla11 extends JFrame {
	private JPanel contentPane;
	private boolean usat = false;
	private JTextField txtNom;
	private JTextField txtTipus;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plantilla11 frame = new Plantilla11();
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
	public Plantilla11() {
		setTitle("Crear Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtNom.setEditable(false);
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNom.setText("Nom:");
		txtNom.setBounds(55, 34, 81, 31);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtTipus = new JTextField();
		txtTipus.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipus.setEditable(false);
		txtTipus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipus.setText("Tipus:");
		txtTipus.setBounds(55, 96, 81, 31);
		contentPane.add(txtTipus);
		txtTipus.setColumns(10);
		
		JComboBox combotipus = new JComboBox();
		combotipus.setBounds(156, 94, 156, 38);
		contentPane.add(combotipus);
		combotipus.addItem("Autor");
		combotipus.addItem("Paper");
		combotipus.addItem("Conferencia");
		combotipus.addItem("Terme");
		ControladorInterficie.setTipusPlant11("Autor");
		combotipus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setTipusPlant11(combotipus.getSelectedItem().toString());
				ControladorInterficie.setEntidades4(combotipus.getSelectedItem().toString());
				}
		});
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(134, 34, 250, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAfegirCamp = new JButton("Afegir Camp");
		btnAfegirCamp.setBounds(134, 153, 178, 48);
		contentPane.add(btnAfegirCamp);
		btnAfegirCamp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText(); 
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Inserta un nombre para la plantilla antes de continuar");
				}
				else {
					usat = true;
				ControladorInterficie.VistaAfegirCamp12();
				}
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				if (s.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Inserta un nombre para la plantilla antes de continuar");
				}
				else {
					ControladorInterficie.setNomPlant11(textField.getText());
					if(!usat) ControladorInterficie.borrarCamp12();
					ControladorInterficie.cargarPlantilla();
					try {
						ControladorInterficie.VistaConsPlant17();
					} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
			}
		});
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setNomPlant11((""));
				ControladorInterficie.setTipusPlant11("");
				ControladorInterficie.borrarCamp12();
				ControladorInterficie.VistaElementos3();
				dispose();
			}
			
		});
	}
}