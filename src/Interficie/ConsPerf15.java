package Interficie;
//@author Eduard Maestro
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.List;
@SuppressWarnings("serial")
public class ConsPerf15 extends JFrame {
	
	private void llenarList(ArrayList<ArrayList<String>> MatriuCamps, ArrayList<String> NomsArray, List list) {
		int t = MatriuCamps.size();
		for (int i = 0; i < t; ++i) {
			list.add(""); // Linea blanca entre tipo y tipo, tipo heheh;
			list.add(NomsArray.get(i));
			for (int j = 0; j < MatriuCamps.get(i).size(); ++j) {
				list.add(MatriuCamps.get(i).get(j));
				
			}
			
		}
	}
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsPerf15 frame = new ConsPerf15();
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
	public ConsPerf15() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardarYSalir = new JButton("GuardarYSalir");
		btnGuardarYSalir.setBounds(245, 24, 130, 41);
		contentPane.add(btnGuardarYSalir);
		
		JButton btnModificarPerfil = new JButton("Modificar Perfil");
		btnModificarPerfil.setBounds(245, 76, 130, 41);
		contentPane.add(btnModificarPerfil);
		
		JButton btnBorrarPerfil = new JButton("Borrar Perfil");
		btnBorrarPerfil.setBounds(245, 128, 130, 41);
		contentPane.add(btnBorrarPerfil);
		
		List list = new List();
		list.setBounds(43, 24, 150, 195);
		contentPane.add(list);
		
		
		list.add(ControladorInterficie.getNomPerfil());
		list.add(ControladorInterficie.getNomPlantilla());
		
		
		ArrayList<ArrayList<String>> ArrayDeCamps = new ArrayList<>();
		ArrayList<String> ArrayDeNoms = new ArrayList<>();
		ArrayDeCamps = ControladorInterficie.getCampPle();
		ArrayDeNoms = ControladorInterficie.getNomPath();
		llenarList(ArrayDeCamps,ArrayDeNoms,list);
		
		
		
		btnGuardarYSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorInterficie.saveP();
				} catch (IOException | FicheroYaExistente | FicheroNoExiste e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ControladorInterficie.VistaMenu2();
				dispose();
				// ++ Save AND Exit --> Exito asegurado tito
			}
			
		});
		
		btnModificarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
				ControladorInterficie.VistaModificarPerfil23();
				dispose();
			}
			
		});
		
		btnBorrarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (ControladorInterficie.getMenu2().equals("Consultar") &&
						ControladorInterficie.getElement3().equals("Perfil")) {
					try {
						ControladorInterficie.deleteP(System.getProperty("user.dir")+"\\BaseDades\\Perfil\\" + ControladorInterficie.getNomPerfil() + ".txt");
					} catch (FicheroNoExiste | IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					ControladorInterficie.VistaConsPlant17();
				} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				
				// ++ Borrizar perfil; hehehe
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
		
	}
}