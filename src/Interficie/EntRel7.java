package Interficie;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class EntRel7 extends JFrame {
//Entitat - Relacio
	private JPanel contentPane;
	private JTextField txtEligeUnTipo;

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
		setTitle("Relaciones");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnAutor = new JToggleButton("Autor-Paper");
		btnAutor.setBounds(10, 95, 120, 50);
		contentPane.add(btnAutor);
		
		JToggleButton btnConferencia = new JToggleButton("Conferencia-Paper");
		btnConferencia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConferencia.setBounds(151, 95, 131, 50);
		contentPane.add(btnConferencia);
		
		JToggleButton btnTerme = new JToggleButton("Terme-Paper");
		btnTerme.setBounds(304, 95, 120, 50);
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
		JButton btnNuevoGrafo = new JButton("Nuevo Grafo");
		btnNuevoGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser absoluto = new JFileChooser();
				JFileChooser directorio = new JFileChooser();
				directorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				absoluto.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\"));
				directorio.setCurrentDirectory(new File(System.getProperty("user.dir")+"\\BaseDades\\"));
				int res = JOptionPane.showConfirmDialog(null, "Si cambias de grafo, perderás todos los datos ¿Quieres guardar los cambios que has hecho hasta ahora?");
				if (res == 0) {
					//Si guarda
					int result = absoluto.showSaveDialog(absoluto);
					if (result == JFileChooser.CANCEL_OPTION) {
						ControladorInterficie.VistaElementos3();
						dispose();
					}
					else {
						String path = absoluto.getSelectedFile().getAbsolutePath();
						try {
							ControladorInterficie.saveGraph(path);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						ControladorInterficie.VistaMenu2();
						dispose();
					}
					int cargaroimportar = JOptionPane.showOptionDialog(null, "¿Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					//usuario da a importar
					if (cargaroimportar == 0) {
						result = directorio.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = directorio.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.importaGraph(path);
								} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
					//cargar
					else {
						result = absoluto.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
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
				else if (res == 1) {
					int cargaroimportar = JOptionPane.showOptionDialog(null, "¿Quieres cargar o importar un grafo?", "Cargar/Importar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Importar","Cargar"} , JOptionPane.NO_OPTION);
					if (cargaroimportar == 0) {
						int result = directorio.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
							String path = directorio.getSelectedFile().getAbsolutePath();
							try {
								ControladorInterficie.importaGraph(path);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							ControladorInterficie.VistaMenu2();
							dispose();
						}
					}
					//cargar
					else {
						int result = absoluto.showOpenDialog(absoluto);
						if (result == JFileChooser.CANCEL_OPTION) {
							ControladorInterficie.VistaElementos3();
							dispose();
						}
						else {
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
			}
		});
		
		btnNuevoGrafo.setFont(new Font("Arial", Font.PLAIN, 8));
		btnNuevoGrafo.setBounds(0, 0, 79, 31);
		contentPane.add(btnNuevoGrafo);
		
		txtEligeUnTipo = new JTextField();
		txtEligeUnTipo.setEditable(false);
		txtEligeUnTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEligeUnTipo.setText("Elige un tipo de relaci\u00F3n");
		txtEligeUnTipo.setBounds(125, 39, 181, 31);
		contentPane.add(txtEligeUnTipo);
		txtEligeUnTipo.setColumns(10);
		
	}
}
