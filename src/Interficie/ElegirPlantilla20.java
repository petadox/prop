	package Interficie;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//Autor Chus

public class ElegirPlantilla20 extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirPlantilla20 frame = new ElegirPlantilla20();
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
	public ElegirPlantilla20() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnUsarExistent = new JToggleButton("Usar existent");
		btnUsarExistent.setBounds(150, 124, 121, 23);
		contentPane.add(btnUsarExistent);
		
		JToggleButton btnCrearNova = new JToggleButton("Crear Nova");
		btnCrearNova.setBounds(150, 52, 121, 23);
		contentPane.add(btnCrearNova);
		
		btnUsarExistent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrearNova.isSelected() ) btnCrearNova.setSelected(false); 
			}
		});
		
		btnCrearNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnUsarExistent.isSelected() ) btnUsarExistent.setSelected(false);
			}
		});
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaEntidades4();
				dispose();
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCrearNova.isSelected()) ControladorInterficie.VistaPlantilla11();
				else if(btnUsarExistent.isSelected())
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
