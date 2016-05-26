package Interficie;
//@author Albert Ripol

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class Elements3 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elements3 frame = new Elements3();
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
	public Elements3() {
		setTitle("Elements");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnEntitats = new JToggleButton("Entitats");
		btnEntitats.setBounds(35, 68, 150, 50);
		contentPane.add(btnEntitats);
		
		JToggleButton btnPerfil = new JToggleButton("Perfil");
		btnPerfil.setBounds(247, 68, 150, 50);
		contentPane.add(btnPerfil);
		
		JToggleButton btnRelacions = new JToggleButton("Relacions");
		btnRelacions.setBounds(35, 142, 150, 50);
		contentPane.add(btnRelacions);
		
		JToggleButton btnPlantilla = new JToggleButton("Plantilla");
		btnPlantilla.setBounds(247, 142, 150, 50);
		contentPane.add(btnPlantilla);
		
		btnEntitats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnPerfil.isSelected() ) btnPerfil.setSelected(false); ;
				if(btnRelacions.isSelected()) btnRelacions.setSelected(false);
				if(btnPlantilla.isSelected()) btnPlantilla.setSelected(false);
			}
		});
		
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEntitats.isSelected() ) btnEntitats.setSelected(false);
				if(btnRelacions.isSelected()) btnRelacions.setSelected(false);
				if(btnPlantilla.isSelected()) btnPlantilla.setSelected(false);
			}
		});
		
		btnRelacions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEntitats.isSelected()) btnEntitats.setSelected(false);
				if(btnPerfil.isSelected() ) btnPerfil.setSelected(false);
				if(btnPlantilla.isSelected()) btnPlantilla.setSelected(false);
			}
		});
		
		btnPlantilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEntitats.isSelected()) btnEntitats.setSelected(false);
				if(btnPerfil.isSelected() ) btnPerfil.setSelected(false);
				if(btnRelacions.isSelected()) btnRelacions.setSelected(false);
			}
		});
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnEntitats.isSelected()){
					ControladorInterficie.setElement3("Entidades");
					ControladorInterficie.VistaEntidades4();
					dispose();
				}
				if(btnPerfil.isSelected()){
					ControladorInterficie.setElement3("Perfil");
					if(ControladorInterficie.getMenu2() == "Crear"){
						ControladorInterficie.VistaIntroduirNom5();
						dispose();
					}
					else{
						ControladorInterficie.VistaSLPerfiles9();
						dispose();
					}
				}
				if(btnPlantilla.isSelected()){
					ControladorInterficie.setElement3("Plantilla");
					if(ControladorInterficie.getMenu2() == "Crear"){
						ControladorInterficie.VistaPlantilla11();
						dispose();
					}
					else{ //Consultar/modificar/borrar Plantilla
						try {
							JFileChooser importar = new JFileChooser();
							importar.setCurrentDirectory(new File("C:\\Users\\chus\\Documents\\PracticaPROPEclipse\\ProjectePROP\\BaseDades\\PlantillaPerfil"));
							importar.showOpenDialog(importar);
							String ruta = importar.getSelectedFile().getAbsolutePath();
							
							if(ControladorInterficie.getMenu2() == "Consultar" || 
							   ControladorInterficie.getMenu2() == "Modificar"){
									
								   ControladorInterficie.loadPP(ruta);
								   ControladorInterficie.VistaConsPlant17();
							}
							else if(ControladorInterficie.getMenu2() == "Borrar"){
								ControladorInterficie.deletePP(ruta);
								ControladorInterficie.VistaMenu2();
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						dispose();
					}
				}
				if(btnRelacions.isSelected()){
					ControladorInterficie.setElement3("Relaciones");
					ControladorInterficie.VistaEntRel7();
					dispose();
				}
			}
		});
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if (ControladorInterficie.getMenu2().equals("Crear")) textField.setText("Selecciona que deseas crear");
		else if (ControladorInterficie.getMenu2().equals("Modificar")) textField.setText("Selecciona que deseas modificar");
		else if (ControladorInterficie.getMenu2().equals("Consultar")) textField.setText("Selecciona que deseas consultar");
		else textField.setText("Selecciona que deseas borrar");
		textField.setBounds(89, 21, 251, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNuevoGrafo = new JButton("Nuevo Grafo");
		btnNuevoGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser absoluto = new JFileChooser();
				JFileChooser directorio = new JFileChooser();
				directorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				absoluto.setCurrentDirectory(new File("C:\\Users\\chus\\Documents\\PracticaPROPEclipse\\ProjectePROP\\BaseDades"));
				directorio.setCurrentDirectory(new File("C:\\Users\\chus\\Documents\\PracticaPROPEclipse\\ProjectePROP\\BaseDades"));
				int res = JOptionPane.showConfirmDialog(null, "Si cambias de grafo, perderás todos los datos ¿Quieres guardar los cambios que has hecho hasta ahora?");
				if (res == 0) {
					absoluto.showSaveDialog(absoluto);
					String path = absoluto.getSelectedFile().getAbsolutePath();
					try {
						ControladorInterficie.saveGraph(path);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					int cargaroimportar = JOptionPane.showOptionDialog(null, "¿Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					//usuario da a importar
					if (cargaroimportar == 0) {
						directorio.showOpenDialog(absoluto);
						path = directorio.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.importaGraph(path);
							} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();
					}
					//cargar
					else {
						absoluto.showOpenDialog(absoluto);
						path = absoluto.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.carregaGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();	
					}
				}
				else if (res == 1) {
					int cargaroimportar = JOptionPane.showOptionDialog(null, "¿Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					if (cargaroimportar == 0) {
						directorio.showOpenDialog(absoluto);
						String path = directorio.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.importaGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();
					}
					//cargar
					else {
						absoluto.showOpenDialog(absoluto);
						String path = absoluto.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.carregaGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();	
					}
				}
			}
		});
		btnNuevoGrafo.setFont(new Font("Arial", Font.PLAIN, 8));
		btnNuevoGrafo.setBounds(0, 0, 79, 31);
		contentPane.add(btnNuevoGrafo);
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ControladorInterficie.setElement3((""));
				ControladorInterficie.VistaMenu2();
				dispose();
			}
		});
	}
}

