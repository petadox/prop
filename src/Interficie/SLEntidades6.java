package Interficie;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
public class SLEntidades6 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
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
		scrollPane.setBounds(169, 31, 226, 215);
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
						// TODO Auto-generated catch block
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
		
		
		list.setModel(dlm);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(10, 64, 125, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
				}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
				for (int i = 0; i < conferencies.size(); i++) {
					textField.setText("Conferencias");
					dlm.addElement(conferencies.get(i).second);	
					}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Terme")) {
				for (int i = 0; i < termes.size(); i++) {
					textField.setText("Termes");
					dlm.addElement(termes.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntidades4().equals("Paper")) {
				for (int i = 0; i < papers.size(); i++) {
					textField.setText("Papers");
					dlm.addElement(papers.get(i).second);
				}
			}
		}
		else if (ControladorInterficie.getElement3().equals("Relaciones")) {
			if (ControladorInterficie.getEntRel7().equals("Autor")) {
				textField.setText("Autores");
				for (int i = 0; i < autores.size(); i++) {
				dlm.addElement(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Conferencia")) {
				for (int i = 0; i < conferencies.size(); i++) {
					textField.setText("Conferencias");
					dlm.addElement(conferencies.get(i).second);	
					}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Terme")) {
				for (int i = 0; i < termes.size(); i++) {
					textField.setText("Termes");
					dlm.addElement(termes.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getEntRel7().equals("Paper")) {
				for (int i = 0; i < papers.size(); i++) {
					textField.setText("Papers");
					dlm.addElement(papers.get(i).second);
				}
			}
		}
		
		else if (ControladorInterficie.getElement3().equals("Plantilla")) {
			if (ControladorInterficie.getTipusPlant().equals("Autor")) {
				textField.setText("Autores");
				for (int i = 0; i < autores.size(); i++) {
				dlm.addElement(autores.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Conferencia")) {
				for (int i = 0; i < conferencies.size(); i++) {
					textField.setText("Conferencias");
					dlm.addElement(conferencies.get(i).second);	
					}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Terme")) {
				for (int i = 0; i < termes.size(); i++) {
					textField.setText("Termes");
					dlm.addElement(termes.get(i).second);
				}
			}
			
			else if (ControladorInterficie.getTipusPlant().equals("Paper")) {
				for (int i = 0; i < papers.size(); i++) {
					textField.setText("Papers");
					dlm.addElement(papers.get(i).second);
				}
			}
		}
		
		
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		             int index = list.locationToIndex(e.getPoint());
		             String nomEnt = dlm.getElementAt(index);
	            	 ControladorInterficie.setNombreEntidad(nomEnt);
	            	 if (ControladorInterficie.getElement3().equals("Entidades")) {
			             if (ControladorInterficie.getMenu2().equals("Consultar")) {
			            	 	ControladorInterficie.setSLEntidades6(ControladorInterficie.getEntidades4());
			            	 	if (ControladorInterficie.getEntidades4().equals("Autor")) {
			            	 		ControladorInterficie.setEntidades6Int(autores.get(index).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			            	 		ControladorInterficie.setEntidades6Int(conferencies.get(index).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			            	 		ControladorInterficie.setEntidades6Int(termes.get(index).first);
			            	 	}
			            	 	else {
			            	 		ControladorInterficie.setEntidades6Int(papers.get(index).first);
			            	 	}
			            	 	ControladorInterficie.VistaConsultar(); 
			            	 	dispose();
			             }
			             else if (ControladorInterficie.getMenu2().equals("Borrar")) {
			            	 int dialog = JOptionPane.OK_CANCEL_OPTION;
			               	 int result = JOptionPane.showConfirmDialog(null, "¿ Seguro que quieres borrar el nodo indicado?","", dialog);
			               	 //Le ha dado a aceptar
			               	 if (result == 0) {
			               		 dlm.remove(index);
			               		if (ControladorInterficie.getEntidades4().equals("Autor")) {
				               		 ControladorInterficie.borrarNode(nomEnt,autores.get(index).first,0);
				               		 ControladorInterficie.cargarArrays();
				               		 ControladorInterficie.ordenarVector();
				               		 ArrayList<Pair<Integer,String>> autores = ControladorInterficie.getAutors();
				               		 for (int i = 0; i < autores.size(); i++) {
				               			 dlm.addElement(autores.get(i).second);
				               		 }
			               		} 
			               		if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
				               		 ControladorInterficie.borrarNode(nomEnt,conferencies.get(index).first,1);
				               		 ControladorInterficie.cargarArrays();
				               		 ControladorInterficie.ordenarVector();
				               		 ArrayList<Pair<Integer,String>> conferencies = ControladorInterficie.getConferencies();
				               		 for (int i = 0; i < autores.size(); i++) {
				               			 dlm.addElement(conferencies.get(i).second);
				               		 }
				                }
			               		if (ControladorInterficie.getEntidades4().equals("Terme")) {
				               		 ControladorInterficie.borrarNode(nomEnt,termes.get(index).first,2);
				               		 ControladorInterficie.cargarArrays();
				               		 ControladorInterficie.ordenarVector();
				               		 ArrayList<Pair<Integer,String>> termes = ControladorInterficie.getTermes();
				               		 for (int i = 0; i < autores.size(); i++) {
				               			 dlm.addElement(termes.get(i).second);
				               		 }
				                }
			               		if (ControladorInterficie.getEntidades4().equals("Paper")) {
				               		 ControladorInterficie.borrarNode(nomEnt,papers.get(index).first,3);
				               		 ControladorInterficie.cargarArrays();
				               		 ControladorInterficie.ordenarVector();
				               		 ArrayList<Pair<Integer,String>> papers = ControladorInterficie.getPapers();
				               		 for (int i = 0; i < autores.size(); i++) {
				               			 dlm.addElement(papers.get(i).second);
				               		 }
			               		}
			               	 }
			               	 //si le ha dado a cancelar se cierra el dialogo
			             }       
			             else if (ControladorInterficie.getMenu2().equals("Modificar")) {
			            	 	ControladorInterficie.setSLEntidades6(ControladorInterficie.getEntidades4());
			            	 	if (ControladorInterficie.getEntidades4().equals("Autor")) {
			            	 		ControladorInterficie.setEntidades6Int(autores.get(index).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			            	 		ControladorInterficie.setEntidades6Int(conferencies.get(index).first);
			            	 	}
			            	 	else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			            	 		ControladorInterficie.setEntidades6Int(termes.get(index).first);
			            	 	}
			            	 	else {
			            	 		ControladorInterficie.setEntidades6Int(papers.get(index).first);
			            	 	}
			            	 	ControladorInterficie.VistaIntroduirNom5(); 
			            	 	dispose();
			             }
	            	 }
	            	 else if (ControladorInterficie.getElement3().equals("Relaciones")) {
	            		 if (ControladorInterficie.getEntRel7().equals("Autor")) {
	            			 ControladorInterficie.setIdNodo(autores.get(index).first);
	            			 ControladorInterficie.setEntidades4(ControladorInterficie.getEntRel7());
	            			 if (ControladorInterficie.getMenu2().equals("Borrar")) ControladorInterficie.VistaConsultar(); 
	            			 else {
	            				 ControladorInterficie.setEntRel7("Paper");
	            				 ControladorInterficie.VistaSLEntidades6();
	            			 }
	            			 dispose();
	            		 }
	            		 else if (ControladorInterficie.getEntRel7().equals("Conferencia")) {
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
	            			 ControladorInterficie.setIdNodo(termes.get(index).first);
	            			 ControladorInterficie.setEntidades4(ControladorInterficie.getEntRel7());
	            			 ControladorInterficie.setEntRel7("Paper");
	            			 if (ControladorInterficie.getMenu2().equals("Borrar")) ControladorInterficie.VistaConsultar(); 
	            			 else {
	            				 ControladorInterficie.setEntRel7("Paper");
	            				 ControladorInterficie.VistaSLEntidades6();
	            			 }
	            			 dispose();
	            		 }
	            		 else {
	            			 ControladorInterficie.setIdPaper(papers.get(index).first);
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
	} 
}