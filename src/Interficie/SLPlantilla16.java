package Interficie;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")
public class SLPlantilla16 extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SLPlantilla16 frame = new SLPlantilla16();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FicheroNoExiste 
	 */
	public SLPlantilla16() throws FicheroNoExiste, IOException {
		setTitle("SLPlantilla16");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		/*contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);*/
		

		
		JFileChooser importar = new JFileChooser();
		importar.showOpenDialog(importar);
		String ruta = importar.getSelectedFile().getAbsolutePath();
		
		if(ControladorInterficie.getMenu2() == "Consultar" || 
		   ControladorInterficie.getMenu2() == "Modificar"){
			   ControladorInterficie.loadPP(ruta);
		}
		else if(ControladorInterficie.getMenu2() == "Borrar"){
			ControladorInterficie.deletePP(ruta);
		}
		//ControladorInterficie.VistaConsPlant17();
		dispose();
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