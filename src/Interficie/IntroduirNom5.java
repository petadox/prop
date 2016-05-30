package Interficie;
//@author Albert Ripol

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
public class IntroduirNom5 extends JFrame {

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
	public IntroduirNom5() {
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
		txtIntrodueixElNom.setText("Introdueix el nom");
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
		
		JToggleButton tglbtnAI = new JToggleButton("AI");
		tglbtnAI.setBounds(20, 166, 50, 23);
		contentPane.add(tglbtnAI);
		
		JToggleButton tglbtnDataMining = new JToggleButton("DataMining");
		tglbtnDataMining.setBounds(82, 166, 85, 23);
		contentPane.add(tglbtnDataMining);
		
		JToggleButton tglbtnDatabase = new JToggleButton("Database");
		tglbtnDatabase.setBounds(172, 166, 79, 23);
		contentPane.add(tglbtnDatabase);
		
		JToggleButton tglbtnInformationalRetrieval = new JToggleButton("InformationRetrieval");
		tglbtnInformationalRetrieval.setBounds(261, 166, 131, 23);
		contentPane.add(tglbtnInformationalRetrieval);
		
		tglbtnAI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnDataMining.isSelected() ) tglbtnDataMining.setSelected(false); ;
				if(tglbtnDatabase.isSelected()) tglbtnDatabase.setSelected(false);
				if(tglbtnInformationalRetrieval.isSelected()) tglbtnInformationalRetrieval.setSelected(false);
			}
		});
		
		tglbtnDataMining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnAI.isSelected() ) tglbtnAI.setSelected(false);
				if(tglbtnDatabase.isSelected()) tglbtnDatabase.setSelected(false);
				if(tglbtnInformationalRetrieval.isSelected()) tglbtnInformationalRetrieval.setSelected(false);
			}
		});
		
		tglbtnDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnDataMining.isSelected()) tglbtnDataMining.setSelected(false);
				if(tglbtnAI.isSelected() ) tglbtnAI.setSelected(false);
				if(tglbtnInformationalRetrieval.isSelected()) tglbtnInformationalRetrieval.setSelected(false);
			}
		});
		
		tglbtnInformationalRetrieval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnDataMining.isSelected()) tglbtnDataMining.setSelected(false);
				if(tglbtnAI.isSelected() ) tglbtnAI.setSelected(false);
				if(tglbtnDatabase.isSelected()) tglbtnDatabase.setSelected(false);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setNom5(nom.getText());
				ControladorInterficie.VistaEntidades4();
				dispose();
			}
		});
		
		if (ControladorInterficie.getMenu2().equals("Modificar") || !ControladorInterficie.getElement3().equals("Entidades")) {
			tglbtnInformationalRetrieval.setEnabled(false);
			tglbtnAI.setEnabled(false);
			tglbtnDatabase.setEnabled(false);
			tglbtnDataMining.setEnabled(false);
		}
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg")); 
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nom.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Introduce un nombre, porfavor");
				}
				else{
					ControladorInterficie.setNom5(nom.getText());
					if(ControladorInterficie.getMenu2() == "Crear" && ControladorInterficie.getElement3() == "Perfil"){
						ControladorInterficie.VistaEntidades4();
					}
					else if(ControladorInterficie.getMenu2() == "Modificar" && ControladorInterficie.getElement3() == "Entidades") {
						ControladorInterficie.modificarNode();
					}
					else {
						if (ControladorInterficie.getEntidades4() == "Autor") { try {
							if (tglbtnAI.isSelected()) ControladorInterficie.addNode("Autor", nom.getText(),"AI");
							else if (tglbtnDatabase.isSelected()) ControladorInterficie.addNode("Autor", nom.getText(),"Database");
							else if (tglbtnDataMining.isSelected()) ControladorInterficie.addNode("Autor", nom.getText(),"DataMining");
							else if (tglbtnInformationalRetrieval.isSelected()) ControladorInterficie.addNode("Autor", nom.getText(),"InformationalRetrieval");
							else ControladorInterficie.addNode("Autor", nom.getText(),"");
						} catch (IOException e1) {
							e1.printStackTrace();
						} }
						else if (ControladorInterficie.getEntidades4() == "Conferencia") { try {
							if (tglbtnAI.isSelected()) ControladorInterficie.addNode("Conferencia", nom.getText(),"AI");
							else if (tglbtnDatabase.isSelected()) ControladorInterficie.addNode("Conferencia", nom.getText(),"Database");
							else if (tglbtnDataMining.isSelected()) ControladorInterficie.addNode("Conferencia", nom.getText(),"DataMining");
							else if (tglbtnInformationalRetrieval.isSelected()) ControladorInterficie.addNode("Conferencia", nom.getText(),"InformationalRetrieval");
							else ControladorInterficie.addNode("Conferencia", nom.getText(),"");
						} catch (IOException e1) {
							e1.printStackTrace();
						} }
						else if (ControladorInterficie.getEntidades4() == "Paper") { try {
							if (tglbtnAI.isSelected()) ControladorInterficie.addNode("Paper", nom.getText(),"AI");
							else if (tglbtnDatabase.isSelected()) ControladorInterficie.addNode("Paper", nom.getText(),"Database");
							else if (tglbtnDataMining.isSelected()) ControladorInterficie.addNode("Paper", nom.getText(),"DataMining");
							else if (tglbtnInformationalRetrieval.isSelected()) ControladorInterficie.addNode("Paper", nom.getText(),"InformationalRetrieval");
							else ControladorInterficie.addNode("Paper", nom.getText(),"");
						} catch (IOException e1) {
							e1.printStackTrace();
						} }
						else if (ControladorInterficie.getEntidades4() == "Terme") { try {
							if (tglbtnAI.isSelected()) ControladorInterficie.addNode("Terme", nom.getText(),"AI");
							else if (tglbtnDatabase.isSelected()) ControladorInterficie.addNode("Terme", nom.getText(),"Database");
							else if (tglbtnDataMining.isSelected()) ControladorInterficie.addNode("Terme", nom.getText(),"DataMining");
							else if (tglbtnInformationalRetrieval.isSelected()) ControladorInterficie.addNode("Terme", nom.getText(),"InformationalRetrieval");
							else ControladorInterficie.addNode("Terme", nom.getText(),"");
						} catch (IOException e1) {
							e1.printStackTrace();
						} }
						ControladorInterficie.VistaMenu2();
						dispose();
					}
				}
			}
		});
	}
}
