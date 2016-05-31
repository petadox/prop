package Interficie;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Principal1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTtol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal1 frame = new Principal1();
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
	public Principal1() {
		setTitle("Principal1");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTtol = new JTextField();
		txtTtol.setHorizontalAlignment(SwingConstants.CENTER);
		txtTtol.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTtol.setEditable(false);
		txtTtol.setText("T\u00EDtol");
		txtTtol.setBounds(10, 28, 414, 52);
		contentPane.add(txtTtol);
		txtTtol.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStart.setBounds(118, 127, 189, 64);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorInterficie.cargarTodasPlantillas();
				} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
					e1.printStackTrace();
				}
				ControladorInterficie.VistaGrafo8();
				dispose();
			}
		});
	}
}
