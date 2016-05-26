package Interficie;
//@author Eduard Maestro
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.List;
@SuppressWarnings("serial")
public class ConsPlant17 extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsPlant17 frame = new ConsPlant17();
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
	public ConsPlant17() {
		setTitle("Consultar Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardarYSalir = new JButton("Guardar y salir");
		btnGuardarYSalir.setBounds(245, 24, 130, 41);
		contentPane.add(btnGuardarYSalir);
		
		JButton btnModificarPerfil = new JButton("Modificar Plantilla");
		btnModificarPerfil.setBounds(245, 76, 130, 41);
		contentPane.add(btnModificarPerfil);
		
		JButton btnGenerarPerfil = new JButton("Generar Perfil");
		btnGenerarPerfil.setBounds(245, 128, 130, 41);
		contentPane.add(btnGenerarPerfil);
		
		JButton btnBorrarPlantilla = new JButton("Borrar Plantilla");
		btnBorrarPlantilla.setBounds(245, 180, 130, 41);
		contentPane.add(btnBorrarPlantilla);
		
		List list = new List();
		list.setBounds(38, 26, 150, 195);
		contentPane.add(list);
		
		list.add(ControladorInterficie.getNomPlantilla());
		list.add(ControladorInterficie.getTipusPlantilla());
		
		ArrayList<ArrayList<String>> todaPlantilla = new ArrayList<ArrayList<String>>();
		
		if(ControladorInterficie.getMenu2().equals("Crear") && 
		   ControladorInterficie.getElement3().equals("Plantilla"))todaPlantilla = ControladorInterficie.getCamp12();
		else{
			//ControladorInterficie.setCamp(nom, descripcio, path, quant, minim);
		}
		for (int i = 0; i < todaPlantilla.size(); ++i ) {
			list.add("");
			for (int j = 0; j < 5; ++j) {
				// Alomejor la n y el 5 vayan cambiaditos;
				list.add(todaPlantilla.get(i).get(j)); // No se si va, creo que si;
			}
		}
		
		btnGuardarYSalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorInterficie.savePP();
					ControladorInterficie.borrarCamp12();
				} catch (IOException | FicheroNoExiste | FicheroYaExistente e1) {
					e1.printStackTrace();
				}
				ControladorInterficie.VistaMenu2();
				dispose();
			}
		});
		
		btnModificarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.VistaModPlantilla18();
				dispose();
				
				// ++ ModificarPlant;
				
			}
			
		});
		
		btnGenerarPerfil.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ControladorInterficie.setconsplant17("GenerarPerfil");
				ControladorInterficie.VistaSLEntidades6();
				dispose();
			}
			
			// ++ Generar Perfil;
			
		});
		
		btnBorrarPlantilla.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (ControladorInterficie.getMenu2().equals("Consultar") &&
						ControladorInterficie.getElement3().equals("Plantilla")) {
					try {
						ControladorInterficie.deletePP("BaseDades/PlantillaPerfil/"+ControladorInterficie.getNomPlantilla()+".txt");
					} catch (FicheroNoExiste | IOException e1) {
						e1.printStackTrace();
					}
				}
				ControladorInterficie.VistaMenu2();
				dispose();
				// ++ Borrar Plantilla;
			}
		});
		
		
	}
}