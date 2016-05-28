package Interficie;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EntRel7 extends JFrame {
//Entitat - Relacio
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntRel7 frame = new EntRel7();
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
	public EntRel7() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnAutor = new JToggleButton("Autor");
		btnAutor.setBounds(142, 15, 150, 50);
		contentPane.add(btnAutor);
		
		JToggleButton btnConferencia = new JToggleButton("Conferencia");
		btnConferencia.setBounds(142, 68, 150, 50);
		contentPane.add(btnConferencia);
		
		JToggleButton btnTerme = new JToggleButton("Terme");
		btnTerme.setBounds(142, 122, 150, 50);
		contentPane.add(btnTerme);
		
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnConferencia.isSelected() ) btnConferencia.setSelected(false); ;
				if(btnTerme.isSelected()) btnTerme.setSelected(false);
			}
		});
		
		btnConferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected() ) btnAutor.setSelected(false);
				if(btnTerme.isSelected()) btnTerme.setSelected(false);
			}
		});
		
		btnTerme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected()) btnAutor.setSelected(false);
				if(btnConferencia.isSelected() ) btnConferencia.setSelected(false);
			}
		});
		
		if (ControladorInterficie.getMenu2().equals("Borrar")) btnConferencia.setEnabled(false);
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected()){
					ControladorInterficie.setEntRel7("Autor");
					ControladorInterficie.VistaSLEntidades6();
					dispose();
				}
				else if(btnConferencia.isSelected()){
					ControladorInterficie.setEntRel7("Conferencia");
					ControladorInterficie.VistaSLEntidades6();
					dispose();
				}
				else if(btnTerme.isSelected()){
					ControladorInterficie.setEntRel7("Terme");
					ControladorInterficie.VistaSLEntidades6();
					dispose();
				}
				else {
					JOptionPane.showOptionDialog(null, "Has de seleccionar algun tipo de Entidad", "", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {} , JOptionPane.NO_OPTION);
				}
			}
		});
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaElementos3();
				dispose();
			}
			
		});
	}
}
