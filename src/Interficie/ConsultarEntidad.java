package Interficie;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import domini.Pair;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
public class ConsultarEntidad extends JFrame {
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtRelaciones;
	private JTextField txtLabel;
	HashMap<Integer,Float> hmp = new HashMap<Integer,Float>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarEntidad frame = new ConsultarEntidad();
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
	public ConsultarEntidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(59, 17, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNombre.setText("Nombre:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.createHorizontalScrollBar();
		scrollPane.setBounds(173, 114, 197, 137);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		txtRelaciones = new JTextField();
		txtRelaciones.setEditable(false);
		txtRelaciones.setText("Relaciones:");
		txtRelaciones.setBounds(59, 166, 86, 20);
		contentPane.add(txtRelaciones);
		txtRelaciones.setColumns(10);
		
		txtNombre.setText("Nombre");
		//scrollPane.setViewportView(txtNombre);
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaSLEntidades6();
				dispose();
			}
		});
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		list.setModel(dlm);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(173, 11, 197, 41);
		contentPane.add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(ControladorInterficie.getNombreEntidad());
		textArea.setEditable(false);
		scrollPane_1.setViewportView(textArea);
		
		txtLabel = new JTextField();
		txtLabel.setEditable(false);
		txtLabel.setText("Label:");
		txtLabel.setBounds(59, 78, 86, 20);
		contentPane.add(txtLabel);
		txtLabel.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(173, 73, 197, 30);

		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(173, 70, 197, 33);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_2.setViewportView(textArea_1);
		contentPane.add(scrollPane_2);
		
		ControladorInterficie.cargarArrays();
		ArrayList<Pair<Integer,String>> papers = ControladorInterficie.getPapers();
		ArrayList<Pair<Integer,String>> autors = ControladorInterficie.getAutors();
		ArrayList<Pair<Integer,String>> conferencies = ControladorInterficie.getConferencies();
		ArrayList<Pair<Integer,String>> termes = ControladorInterficie.getTermes();


		if (ControladorInterficie.getElement3().equals("Entidades")) {
			String aux = ControladorInterficie.getLabel(ControladorInterficie.getEntidades4(), ControladorInterficie.getEntidades6Int());
			textArea_1.setText(aux);
			switch(ControladorInterficie.getSLEntidades6()) {
				case "Autor":
					ControladorInterficie.cargarMapAutores(ControladorInterficie.getEntidades6Int());
			 		HashMap<Integer,Float> hm = ControladorInterficie.getMapa();
			 		 Iterator<Map.Entry<Integer,Float>> iter = hm.entrySet().iterator();
			         while (iter.hasNext()) {
			             Map.Entry<Integer,Float> entry = iter.next();
			             dlm.addElement(papers.get(entry.getKey()).second);
			         }
			         break;
				case "Conferencia":
					ControladorInterficie.cargarMapConferencias(ControladorInterficie.getEntidades6Int());
			 		HashMap<Integer,Float> h = ControladorInterficie.getMapa();
			 		 Iterator<Map.Entry<Integer,Float>> i = h.entrySet().iterator();
			         while (i.hasNext()) {
			             Map.Entry<Integer,Float> entry = i.next();
			             dlm.addElement(papers.get(entry.getKey()).second);
			         }
			         break;
				case "Terme":
					ControladorInterficie.cargarMapTermes(ControladorInterficie.getEntidades6Int());
			 		HashMap<Integer,Float> hmp = ControladorInterficie.getMapa();
			 		 Iterator<Map.Entry<Integer,Float>> it = hmp.entrySet().iterator();
			         while (it.hasNext()) {
			             Map.Entry<Integer,Float> entry = it.next();
			             dlm.addElement(papers.get(entry.getKey()).second);
			         }
			         break;
				case "Paper":
					ControladorInterficie.relacionesPapers(ControladorInterficie.getEntidades6Int());
					ArrayList<Integer> AP = ControladorInterficie.getRelacionesAP();
					ArrayList<Integer> CP = ControladorInterficie.getRelacionesCP();
					ArrayList<Integer> TP = ControladorInterficie.getRelacionesTP();
					dlm.addElement("AUTORS:");
					for (int k = 0; k < AP.size(); k++) {
						dlm.addElement(autors.get(AP.get(k)).second);
					}
					dlm.addElement("             ");
					dlm.addElement("CONFERENCIES:");
					for (int j = 0; j < CP.size(); j++) {
						dlm.addElement(conferencies.get(CP.get(j)).second);
					}
					dlm.addElement("             ");
					dlm.addElement("TERMES:");
					for (int m = 0; m < TP.size(); m++) {
						dlm.addElement(termes.get(TP.get(m)).second);
					}
					break;
			}
		}
		else if (ControladorInterficie.getElement3().equals("Relaciones")) {
			String aux = ControladorInterficie.getLabel(ControladorInterficie.getEntRel7(), ControladorInterficie.getIdNodo());
			textArea_1.setText(aux);
			switch(ControladorInterficie.getEntRel7()) {
			case "Autor":
				ControladorInterficie.cargarMapAutores(ControladorInterficie.getIdNodo());
		 		hmp = ControladorInterficie.getMapa();
		 		System.out.println(hmp.size());
		 		 Iterator<Map.Entry<Integer,Float>> iter = hmp.entrySet().iterator();
		         while (iter.hasNext()) {
		             Map.Entry<Integer,Float> entry = iter.next();
		             dlm.addElement(papers.get(entry.getKey()).second);
		         }
		         break;
			case "Conferencia":
				ControladorInterficie.cargarMapConferencias(ControladorInterficie.getIdNodo());
		 		hmp = ControladorInterficie.getMapa();
		 		 Iterator<Map.Entry<Integer,Float>> i = hmp.entrySet().iterator();
		         while (i.hasNext()) {
		             Map.Entry<Integer,Float> entry = i.next();
		             dlm.addElement(papers.get(entry.getKey()).second);
		         }
		         break;
			case "Terme":
				ControladorInterficie.cargarMapTermes(ControladorInterficie.getIdNodo());
		 		hmp = ControladorInterficie.getMapa();
		 		 Iterator<Map.Entry<Integer,Float>> it = hmp.entrySet().iterator();
		         while (it.hasNext()) {
		             Map.Entry<Integer,Float> entry = it.next();
		             dlm.addElement(papers.get(entry.getKey()).second);
		         }
		         break;
			}
			MouseListener mouseListener = new MouseAdapter() {
			     public void mouseClicked(MouseEvent e) {
			             Integer index = list.locationToIndex(e.getPoint());
			             int dialog = JOptionPane.OK_CANCEL_OPTION;
		               	 int result = JOptionPane.showConfirmDialog(null, "¿ Seguro que quieres borrar la relacion indicada?","", dialog);
		               	 if (result == 0) {
				             Iterator<Map.Entry<Integer,Float>> it = hmp.entrySet().iterator();
				             Map.Entry<Integer,Float> entry = it.next();
					         for (int i = 0; i < index; ++i) entry = it.next();
				             ControladorInterficie.setIdPaper(entry.getKey());
				             if (ControladorInterficie.potBorrarRel()) {
				            	 dlm.remove(index);
				            	 ControladorInterficie.deleteRelacion();
				             }
				             else {
				            	 JOptionPane.showMessageDialog(null, "No puedes borrar esta relacion, el paper se quedaria sin ningun autor.");
				             }
		               	 }
		     	}
			};
			list.addMouseListener(mouseListener);
		}
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