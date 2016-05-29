package Interficie;
//@author Eduard Maestro

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class CanviarNom extends JFrame {

	private JPanel contentPane;
	private JTextField txtIntrodueixElNom;
	private JTextField nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroduirNom5 frame = new IntroduirNom5();
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
	public CanviarNom() {
		setTitle("Introduir Nom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIntrodueixElNom = new JTextField();
		txtIntrodueixElNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntrodueixElNom.setEditable(false);
		txtIntrodueixElNom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIntrodueixElNom.setText("Introdueix el nou nom");
		txtIntrodueixElNom.setBounds(10, 58, 414, 36);
		contentPane.add(txtIntrodueixElNom);
		txtIntrodueixElNom.setColumns(10);
		
		nom = new JTextField();
		nom.setBounds(77, 105, 281, 36);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaModificarPerfil23();
				dispose();
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg")); 
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nom.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Introduce un nombre, porfavor");
				}
				else{
					ControladorInterficie.setCanviNom(nom.getText());
					
					// Voy a suponer que:
					// He clicado en la pantalla anterior y con lo cual he convertido
					// el indice a i y j y se donde tengo que guardar el valor.
					// Con lo cual debo llamar a la funcion que mete el nuevo valor
					// en la posicion correspondientedesable; hehehe diente de sable lo pillas ?
					
					ControladorInterficie.actualitzaNom();
					
					
					ControladorInterficie.VistaModificarPerfil23();
					dispose();
				}
			}
		});
		
		
	}
}
