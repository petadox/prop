package Interficie;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;
import domini.Pair;

public class ElegirPlant extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirPlant frame = new ElegirPlant();
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
	public ElegirPlant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 11, 258, 240);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		list.setModel(dlm);
		if(ControladorInterficie.getEntidades4().equals("Autor")){
			File directorio = new File("BaseDades/PlantillaPerfil/Autor"); //Ruta de la carpeta con archivos
    		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
    		for(int i=0; i<archivos.length; i++){
    			String nom = "";
        		String aux = "";
    			aux = archivos[i];
    			for(int j=0; j<aux.length()-4; j++){
    				nom = nom+aux.charAt(j);
    			}
    			dlm.addElement(nom);
    		}
		}
		if(ControladorInterficie.getEntidades4().equals("Conferencia")){
			File directorio = new File("BaseDades/PlantillaPerfil/Conferencia"); //Ruta de la carpeta con archivos
    		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
    		for(int i=0; i<archivos.length; i++){
    			String nom = "";
        		String aux = "";
    			aux = archivos[i];
    			for(int j=0; j<aux.length()-4; j++){
    				nom = nom+aux.charAt(j);
    			}
    			dlm.addElement(nom);
    		}
		}
		if(ControladorInterficie.getEntidades4().equals("Paper")){
			File directorio = new File("BaseDades/PlantillaPerfil/Paper"); //Ruta de la carpeta con archivos
    		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
    		for(int i=0; i<archivos.length; i++){
    			String nom = "";
        		String aux = "";
    			aux = archivos[i];
    			for(int j=0; j<aux.length()-4; j++){
    				nom = nom+aux.charAt(j);
    			}
    			dlm.addElement(nom);
    		}
		}
		if(ControladorInterficie.getEntidades4().equals("Terme")){
			File directorio = new File("BaseDades/PlantillaPerfil/Terme"); //Ruta de la carpeta con archivos
    		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
    		for(int i=0; i<archivos.length; i++){
    			String nom = "";
        		String aux = "";
    			aux = archivos[i];
    			for(int j=0; j<aux.length()-4; j++){
    				nom = nom+aux.charAt(j);
    			}
    			dlm.addElement(nom);
    		}
		}
		MouseListener mouseListener = new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
	             int index = list.locationToIndex(e.getPoint());
	             String nomEnt = dlm.getElementAt(index);
	             if (ControladorInterficie.getMenu2().equals("Consultar")) {
	            	 	ControladorInterficie.carregaPlantIndex(index);
	            	 	try {
							ControladorInterficie.VistaConsPlant17();
						} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
							e1.printStackTrace();
						}
	            	 	dispose();
	             }
	             else if (ControladorInterficie.getMenu2().equals("Borrar")) {
	            	 int dialog = JOptionPane.OK_CANCEL_OPTION;
	               	 int result = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar el perfil indicado?","", dialog);
	               	 //Le ha dado a aceptar
	               	 if (result == 0) {
	               		if (ControladorInterficie.getEntidades4().equals("Autor")) {
	               			File directorio = new File("BaseDades/PlantillaPerfil/Autor"); //Ruta de la carpeta con archivos
	                		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
	                		String nom = archivos[index];
	                		String ruta = directorio.getPath();
		               		 try {
								ControladorInterficie.deletePP(ruta+nom);
							} catch (FicheroNoExiste | IOException e1) {
								e1.printStackTrace();
							}
		               	}
	               		else if (ControladorInterficie.getEntidades4().equals("Conferencia")) {
	               			File directorio = new File("BaseDades/PlantillaPerfil/Conferencia"); //Ruta de la carpeta con archivos
	                		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
	                		String nom = archivos[index];

	                		String ruta = directorio.getPath();
		               		 try {
								ControladorInterficie.deletePP(ruta+nom);
							} catch (FicheroNoExiste | IOException e1) {
								e1.printStackTrace();
							}
		                }
	               		else if (ControladorInterficie.getEntidades4().equals("Terme")) {
	               			File directorio = new File("BaseDades/PlantillaPerfil/Terme"); //Ruta de la carpeta con archivos
	                		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
	                		String nom = archivos[index];

	                		String ruta = directorio.getPath();
		               		 try {
								ControladorInterficie.deletePP(ruta+nom);
							} catch (FicheroNoExiste | IOException e1) {
								e1.printStackTrace();
							}
		                }
	               		else if (ControladorInterficie.getEntidades4().equals("Paper")) {
	               			File directorio = new File("BaseDades/PlantillaPerfil/Paper"); //Ruta de la carpeta con archivos
	                		String archivos[]=directorio.list(); //aca cargas todos los nombres de los archivos
	                		String nom = archivos[index];

	                		String ruta = directorio.getPath();
		               		 try {
								ControladorInterficie.deletePP(ruta+nom);
							} catch (FicheroNoExiste | IOException e1) {
								e1.printStackTrace();
							}
		                }
	               		dlm.remove(index);
	               	 }
	               	 //si le ha dado a cancelar se cierra el dialogo
	             }
		     }
		 };
		 list.addMouseListener(mouseListener);
	}

}
