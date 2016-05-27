package Interficie;
//@author Eduard Maestro
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.List;
@SuppressWarnings("serial")
public class ConsPerf15 extends JFrame {
	
	private void llenarList(ArrayList<ArrayList<String>> MatriuCamps, ArrayList<String> NomsArray, List list) {
		int t = MatriuCamps.size();
		for (int i = 0; i < t; ++i) {
			list.add(""); // Linea blanca entre tipo y tipo, tipo heheh;
			System.out.println("Añado: " +NomsArray.get(i)+ "");
			list.add(NomsArray.get(i));
			for (int j = 0; j < MatriuCamps.get(i).size(); ++j) {
				System.out.println("Añado 2o bucle: " +MatriuCamps.get(i).get(j)+ "");
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
				
				// ++ Modificar Perfiel;
			}
			
		});
		
		btnBorrarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (ControladorInterficie.getMenu2().equals("Consultar") &&
						ControladorInterficie.getElement3().equals("Perfil")) {
					try {
						ControladorInterficie.deleteP("/BaseDades/Perfil/" + ControladorInterficie.getNomPerfil() + ".txt");
					} catch (FicheroNoExiste | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					ControladorInterficie.VistaConsPlant17();
				} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
				// ++ Borrizar perfil; hehehe
			}
			
		});
	}
}