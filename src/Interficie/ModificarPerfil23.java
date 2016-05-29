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
public class ModificarPerfil23 extends JFrame {
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
	public ModificarPerfil23() {
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
						ControladorInterficie.VistaConsPerf15();
					} catch (NumberFormatException e) {
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
		
		// Aqui tengo que conseguir los datos para llenar
		dlm.addElement(ControladorInterficie.getNomPerfil());
		dlm.addElement(ControladorInterficie.getNomPlantilla());
		
		ArrayList<ArrayList<String>> ArrayDeCamps = new ArrayList<>();
		ArrayList<String> ArrayDeNoms = new ArrayList<>();
		ArrayDeCamps = ControladorInterficie.getCampPle();
		ArrayDeNoms = ControladorInterficie.getNomPath();
		llenarList(ArrayDeCamps,ArrayDeNoms,dlm);
		
		
		
		
		
		
	/*	MouseListener mouseListener = new MouseAdapter() {
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
			               		 if (ControladorInterficie.getEntidades4().equals("Autor")) {
			               			ControladorInterficie.setIdNodo(autores.get(index).first);
			               			if (ControladorInterficie.esUltimaRel()) {
			               				JOptionPane.showMessageDialog(null, "No puedes borrar este autor, es el último autor de un paper.");
			               			}
			               			else {
			               				ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),autores.get(index).first,0);
			               				ControladorInterficie.VistaSLEntidades6();
			               				dispose();
			               			}
			               		 }
			               		 else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
			               			ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),conferencies.get(index).first,1);
			               			ControladorInterficie.VistaSLEntidades6();
			               			dispose();
		               			}
			               		 else if (ControladorInterficie.getEntidades4().equals("Terme")) {
			               			ControladorInterficie.borrarNode(ControladorInterficie.getNombreEntidad(),termes.get(index).first,2);
			               			ControladorInterficie.VistaSLEntidades6();
			               			dispose();
		               			}
			               		 else if (ControladorInterficie.getEntidades4().equals("Paper")) {
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
			 */
	}
	
	private void llenarList(ArrayList<ArrayList<String>> MatriuCamps, ArrayList<String> NomsArray, DefaultListModel list) {
		int t = MatriuCamps.size();
		for (int i = 0; i < t; ++i) {
			if (i != 0) list.addElement(""); // Linea blanca entre tipo y tipo, tipo heheh;
			list.addElement(NomsArray.get(i));
			for (int j = 0; j < MatriuCamps.get(i).size(); ++j) {
				list.addElement(MatriuCamps.get(i).get(j));
				
			}
		}
	}
	
}