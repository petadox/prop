package Interficie;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;
import domini.Pair;
import domini.PathException;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
public class SLEntidades6 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SLEntidades6 frame = new SLEntidades6();
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
	public SLEntidades6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 64, 226, 182);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ControladorInterficie.getconsplant17() != null && ControladorInterficie.getconsplant17().equals("GenerarPerfil")) {
					try {
						ControladorInterficie.VistaConsPlant17();
					} catch (NumberFormatException | FicheroNoExiste | IOException e) {
						e.printStackTrace();
					}
				}
				else if (ControladorInterficie.getElement3().equals("Relaciones")) ControladorInterficie.VistaEntRel7();
				else ControladorInterficie.VistaEntidades4();
				dispose();
			}
		});
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		ArrayList<String> aux = new ArrayList<String>();
		
		list.setModel(dlm);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(10, 64, 125, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 24, 159, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_1.getText().length() != 0) {
		            ArrayList<String> novarraylist = new ArrayList<String>();
		            for (int i = 0; i < dlm.size(); ++i) {
		                if (dlm.get(i).contains(textField_1.getText())) novarraylist.add(dlm.get(i));
		            }
		            dlm.removeAllElements();
		            for(int j = 0; j < novarraylist.size(); ++j) dlm.addElement(novarraylist.get(j));
				}
				else {
					dlm.removeAllElements();
					for (int j = 0; j < aux.size(); ++j) dlm.addElement(aux.get(j));
				}
			}
		});
		btnBuscar.setBounds(350, 23, 74, 23);
		contentPane.add(btnBuscar);
		
		ControladorInterficie.cargarArrays();
		ControladorInterficie.ordenarVector();
		ArrayList<Pair<Integer,String>> autores = ControladorInterficie.getAutors();
		ArrayList<Pair<Integer,String>> conferencies = ControladorInterficie.getConferencies();
		ArrayList<Pair<Integer,String>> termes = ControladorInterficie.getTermes();
		ArrayList<Pair<Integer,String>> papers = ControladorInterficie.getPapers();

		if (ControladorInterficie.getElement3().equals("Entidades")) {
			if (ControladorInterficie.getEntidades4().equals("Autor")) {
				textField.setText("Autores");
				for (int i = 0; i < autores.size(); i++) {
					dlm.addElement(autores.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
				textField.setText("Conferencias");
				for (int i = 0; i < conferencies.size(); i++) {
					dlm.addElement(conferencies.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Terme")) {
				textField.setText("Termes");
				for (int i = 0; i < termes.size(); i++) {
					dlm.addElement(termes.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Paper")) {
				textField.setText("Papers");
				for (int i = 0; i < papers.size(); i++) {
					dlm.addElement(papers.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
		}
		else if (ControladorInterficie.getElement3().equals("Relaciones")) {
			if (ControladorInterficie.getEntRel7().equals("Autor")) {
				textField.setText("Autores");
				for (int i = 0; i < autores.size(); i++) {
					dlm.addElement(autores.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Conferencia")) {
				textField.setText("Conferencias");
				for (int i = 0; i < conferencies.size(); i++) {
					dlm.addElement(conferencies.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Terme")) {
				textField.setText("Termes");
				for (int i = 0; i < termes.size(); i++) {
					dlm.addElement(termes.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Paper")) {
				textField.setText("Papers");
				for (int i = 0; i < papers.size(); i++) {
					dlm.addElement(papers.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
		}
		
		else if (ControladorInterficie.getElement3().equals("Plantilla")) {
			if (ControladorInterficie.getTipusPlant().equals("Autor")) {
				textField.setText("Autores");
				for (int i = 0; i < autores.size(); i++) {
					dlm.addElement(autores.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Conferencia")) {
				textField.setText("Conferencias");
				for (int i = 0; i < conferencies.size(); i++) {
					dlm.addElement(conferencies.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Terme")) {
				textField.setText("Termes");
				for (int i = 0; i < termes.size(); i++) {
					dlm.addElement(termes.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Paper")) {
				textField.setText("Papers");
				for (int i = 0; i < papers.size(); i++) {
					dlm.addElement(papers.get(i).second);
					aux.add(autores.get(i).second);
				}
			}
		}
		
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		             int index = list.locationToIndex(e.getPoint());
		             String nomEnt = dlm.getElementAt(index);
	            	 ControladorInterficie.setNombreEntidad(nomEnt);
	            	 boolean trobat = false;
	            	 int l;
	            	 if (ControladorInterficie.getElement3().equals("Entidades")) {
			             if (ControladorInterficie.getMenu2().equals("Consultar")) {
			            	 	ControladorInterficie.setSLEntidades6(ControladorInterficie.getEntidades4());
			            	 	if (ControladorInterficie.getEntidades4().equals("Autor")) {
			            	 		for (l = 0; l < autores.size() && !trobat; ++l) {
			            	 			if (autores.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(autores.get(l).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			            	 		for (l = 0; l < conferencies.size() && !trobat; ++l) {
			            	 			if (conferencies.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(conferencies.get(l).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			            	 		for (l = 0; l < termes.size() && !trobat; ++l) {
			            	 			if (termes.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(termes.get(l).first);
			            	 	}
			            	 	else {
			            	 		for (l = 0; l < papers.size() && !trobat; ++l) {
			            	 			if (papers.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(papers.get(l).first);
			            	 	}
			            	 	ControladorInterficie.VistaConsultar(); 
			            	 	dispose();
			             }
			             else if (ControladorInterficie.getMenu2().equals("Borrar")) {
			            	 int dialog = JOptionPane.OK_CANCEL_OPTION;
			               	 int result = JOptionPane.showConfirmDialog(null, "¿ Seguro que quieres borrar el nodo indicado?","", dialog);
			               	 //Le ha dado a aceptar
			               	 if (result == 0) {
			               		 if (ControladorInterficie.getEntidades4().equals("Autor")) {
			               			for (l = 0; l < autores.size() && !trobat; ++l) {
			            	 			if (autores.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(autores.get(l).first);
			               			ControladorInterficie.setIdNodo(autores.get(l).first);
			               			if (ControladorInterficie.esUltimaRel()) {
			               				JOptionPane.showMessageDialog(null, "No puedes borrar este autor, es el último autor de un paper.");
			               				ControladorInterficie.VistaSLEntidades6();
			               				dispose();
			               			}
			               			else {
			               				ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),autores.get(l).first,0);
			               				ControladorInterficie.VistaSLEntidades6();
			               				dispose();
			               			}
			               		 }
			               		 else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			               			for (l = 0; l < conferencies.size() && !trobat; ++l) {
			            	 			if (conferencies.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(conferencies.get(l).first);
			            	 		ControladorInterficie.setIdNodo(conferencies.get(l).first);
			            	 		if (ControladorInterficie.confBorrable()) {
				               			ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),conferencies.get(l).first,1);
				               			ControladorInterficie.VistaSLEntidades6();
				               			dispose();
			            	 		}
			            	 		else {
			            	 			JOptionPane.showMessageDialog(null, "No puedes borrar esta conferencia, habria papers sin conferencia");
			            	 		}
		               			}
			               		 else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			               			for (l = 0; l < termes.size() && !trobat; ++l) {
			            	 			if (termes.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(termes.get(l).first);
			            	 		ControladorInterficie.setIdNodo(termes.get(l).first);
			               			ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),termes.get(index).first,2);
			               			ControladorInterficie.VistaSLEntidades6();
			               			dispose();
		               			}
			               		 else if (ControladorInterficie.getEntidades4().equals("Paper")) {
			               			for (l = 0; l < papers.size() && !trobat; ++l) {
			            	 			if (papers.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(papers.get(l).first);
			            	 		ControladorInterficie.setIdNodo(papers.get(l).first);
			               			ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),papers.get(index).first,3);
			               			ControladorInterficie.VistaSLEntidades6();
			               			dispose();			               	 
		               			}
			               	 //si le ha dado a cancelar se cierra el dialogo
			               	 }
			             }      
			             else if (ControladorInterficie.getMenu2().equals("Modificar")) {
			            	 	ControladorInterficie.setSLEntidades6(ControladorInterficie.getEntidades4());
			            	 	if (ControladorInterficie.getEntidades4().equals("Autor")) {
			            	 		for (l = 0; l < autores.size() && !trobat; ++l) {
			            	 			if (autores.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(autores.get(l).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			            	 		for (l = 0; l < conferencies.size() && !trobat; ++l) {
			            	 			if (conferencies.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(conferencies.get(l).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			            	 		for (l = 0; l < termes.size() && !trobat; ++l) {
			            	 			if (termes.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(termes.get(l).first);
			            	 	}
			            	 	else {
			            	 		for (l = 0; l < papers.size() && !trobat; ++l) {
			            	 			if (papers.get(l).second.equals(nomEnt)) {
			            	 				trobat = true;
			            	 				--l;
			            	 			}
			            	 		}
			            	 		ControladorInterficie.setEntidades6Int(papers.get(l).first);
			            	 	}
			            	 	ControladorInterficie.VistaIntroduirNom5(); 
			            	 	dispose();
			             }
	            	 }
	            	 else if (ControladorInterficie.getElement3().equals("Relaciones")) {
	            		 if (ControladorInterficie.getEntRel7().equals("Autor")) {
	            			 for (l = 0; l < autores.size() && !trobat; ++l) {
		            	 			if (autores.get(l).second.equals(nomEnt)) {
		            	 				trobat = true;
		            	 				--l;
		            	 			}
		            	 		}
		            	 	 ControladorInterficie.setEntidades6Int(autores.get(l).first);
	            			 ControladorInterficie.setIdNodo(autores.get(l).first);
	            			 ControladorInterficie.setEntidades4(ControladorInterficie.getEntRel7());
	            			 if (ControladorInterficie.getMenu2().equals("Borrar")) ControladorInterficie.VistaConsultar(); 
	            			 else {
	            				 ControladorInterficie.setEntRel7("Paper");
	            				 ControladorInterficie.VistaSLEntidades6();
	            			 }
	            			 dispose();
	            		 }
	            		 else if (ControladorInterficie.getEntRel7().equals("Conferencia")) {
	            			 for (l = 0; l < conferencies.size() && !trobat; ++l) {
		            	 			if (conferencies.get(l).second.equals(nomEnt)) {
		            	 				trobat = true;
		            	 				--l;
		            	 			}
		            	 		}
		            	 	 ControladorInterficie.setEntidades6Int(conferencies.get(l).first);
	            			 ControladorInterficie.setIdNodo(conferencies.get(index).first);
	            			 ControladorInterficie.setEntidades4(ControladorInterficie.getEntRel7());
	            			 if (ControladorInterficie.getMenu2().equals("Borrar")) ControladorInterficie.VistaConsultar(); 
	            			 else {
	            				 ControladorInterficie.setEntRel7("Paper");
	            				 ControladorInterficie.VistaSLEntidades6();
	            			 }
	            			 dispose();
	            		 }
	            		 else if (ControladorInterficie.getEntRel7().equals("Terme")){
	            			 for (l = 0; l < termes.size() && !trobat; ++l) {
		            	 			if (termes.get(l).second.equals(nomEnt)) {
		            	 				trobat = true;
		            	 				--l;
		            	 			}
		            	 		}
		            	 	 ControladorInterficie.setEntidades6Int(termes.get(l).first);
	            			 ControladorInterficie.setIdNodo(termes.get(l).first);
	            			 ControladorInterficie.setEntidades4(ControladorInterficie.getEntRel7());
	            			 if (ControladorInterficie.getMenu2().equals("Borrar")) ControladorInterficie.VistaConsultar(); 
	            			 else {
	            				 ControladorInterficie.setEntRel7("Paper");
	            				 ControladorInterficie.VistaSLEntidades6();
	            			 }
	            			 dispose();
	            		 }
	            		 else {
	            			 for (l = 0; l < papers.size() && !trobat; ++l) {
		            	 			if (papers.get(l).second.equals(nomEnt)) {
		            	 				trobat = true;
		            	 				--l;
		            	 			}
		            	 	 }
		            	 	 ControladorInterficie.setEntidades6Int(papers.get(l).first);
	            			 ControladorInterficie.setIdPaper(papers.get(l).first);
	            			 boolean aux;
	            			 if (ControladorInterficie.getMenu2().equals("Crear")) {
	            				 if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
	            					 if(ControladorInterficie.relacionCorrecta()) ControladorInterficie.newRelacion();
	            					 else JOptionPane.showMessageDialog(null,"El paper ya fue publicado en una conferencia");
	            				 }
	            			 }
	            			 else if (ControladorInterficie.getMenu2().equals("Consultar")) {
	            				 aux = ControladorInterficie.consRelacion();
	            				 int dialog = JOptionPane.INFORMATION_MESSAGE;
				               	 if (aux) JOptionPane.showMessageDialog(null, "Existe la relacion.","", dialog);
				               	 else JOptionPane.showMessageDialog(null, "No existe la relacion.","", dialog);
	            			 }
	            			 else if (ControladorInterficie.getMenu2().equals("Modificar")) ControladorInterficie.modRelacion();
	            			 ControladorInterficie.VistaMenu2();
	            			 dispose();
	            		 }
	            	 } 
	            	 else if (ControladorInterficie.getElement3().equals("Plantilla")) {
	            		 if(ControladorInterficie.getTipusPlant().equals("Autor")) {
	            			 ControladorInterficie.setNom5(autores.get(index).second);
	            			 ControladorInterficie.setIdPerfil(autores.get(index).first);
	            		 }
	            		 else if(ControladorInterficie.getTipusPlant().equals("Conferencia")) {
	            			 ControladorInterficie.setNom5(conferencies.get(index).second);
	            			 ControladorInterficie.setIdPerfil(conferencies.get(index).first);
	            		 }
	            		 else if(ControladorInterficie.getTipusPlant().equals("Paper")) {
	            			 ControladorInterficie.setNom5(papers.get(index).second);
	            			 ControladorInterficie.setIdPerfil(papers.get(index).first);
	            		 }
	            		 else if(ControladorInterficie.getTipusPlant().equals("Terme")) {
	            			 ControladorInterficie.setNom5(termes.get(index).second);
	            			 ControladorInterficie.setIdPerfil(termes.get(index).first);
	            		 }
	            		 
	            		try {
							ControladorInterficie.crearPerfil();
						} catch (NumberFormatException | FicheroNoExiste | IOException | PathException e1) {
							e1.printStackTrace();
						}
	            		ControladorInterficie.VistaConsPerf15();
	            		dispose();
	            	 } 
			     }
			 };
			 list.addMouseListener(mouseListener);
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