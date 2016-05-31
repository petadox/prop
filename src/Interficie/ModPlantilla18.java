package Interficie;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
@SuppressWarnings("serial")

public class ModPlantilla18 extends JFrame {
	private JPanel contentPane;
	private JTextField txtIntrodueixElNou;
	private JTextField textFieldNom;
	private JTextField txtIntrodueixElNou_1;
	private JTextField textFieldTipus;
	private JTextField txtIntrodueixCampA;
	private JTextField textFieldCamp;
	private JButton btnGo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModPlantilla18 frame = new ModPlantilla18();
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
	public ModPlantilla18() {
		setTitle("ModificarPlantilla18");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnModificarNom = new JToggleButton("Modificar Nom");
		btnModificarNom.setBounds(10, 30, 195, 54);
		contentPane.add(btnModificarNom);
		
		JToggleButton btnModificarTipus = new JToggleButton("Modificar Tipus");
		btnModificarTipus.setBounds(10, 95, 195, 54);
		contentPane.add(btnModificarTipus);
		
		JToggleButton btnModificarCamp = new JToggleButton("Modificar Camp");
		btnModificarCamp.setBounds(10, 160, 195, 54);
		contentPane.add(btnModificarCamp);
		
		txtIntrodueixElNou = new JTextField();
		txtIntrodueixElNou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIntrodueixElNou.setEditable(false);
		txtIntrodueixElNou.setText("Introdueix el nou nom");
		txtIntrodueixElNou.setBounds(215, 30, 209, 31);
		contentPane.add(txtIntrodueixElNou);
		txtIntrodueixElNou.setColumns(10);
		txtIntrodueixElNou.setVisible(false);
		
		textFieldNom = new JTextField();
		textFieldNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNom.setBounds(215, 72, 209, 31);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		textFieldNom.setVisible(false);
		textFieldNom.setText(ControladorInterficie.getNomPlant());
		
		txtIntrodueixElNou_1 = new JTextField();
		txtIntrodueixElNou_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIntrodueixElNou_1.setEditable(false);
		txtIntrodueixElNou_1.setText("Introdueix el nou Tipus");
		txtIntrodueixElNou_1.setBounds(215, 94, 209, 31);
		contentPane.add(txtIntrodueixElNou_1);
		txtIntrodueixElNou_1.setColumns(10);
		txtIntrodueixElNou_1.setVisible(false);
		
		textFieldTipus = new JTextField();
		textFieldTipus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTipus.setBounds(215, 136, 209, 31);
		contentPane.add(textFieldTipus);
		textFieldTipus.setColumns(10);
		textFieldTipus.setVisible(false);
		textFieldTipus.setText(ControladorInterficie.getTipusPlant());
		
		txtIntrodueixCampA = new JTextField();
		txtIntrodueixCampA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIntrodueixCampA.setEditable(false);
		txtIntrodueixCampA.setText("Introdueix Camp a Modificar");
		txtIntrodueixCampA.setBounds(215, 160, 209, 31);
		contentPane.add(txtIntrodueixCampA);
		txtIntrodueixCampA.setColumns(10);
		txtIntrodueixCampA.setVisible(false);
		
		textFieldCamp = new JTextField();
		textFieldCamp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldCamp.setBounds(215, 202, 67, 31);
		contentPane.add(textFieldCamp);
		textFieldCamp.setColumns(10);
		textFieldCamp.setVisible(false);
		
		/*btnGo = new JButton("GO");
		btnGo.setBounds(215, 239, 60, 23);
		contentPane.add(btnGo);
		btnGo.setVisible(false);*/
		
		btnModificarNom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtIntrodueixElNou.setVisible(true);
				textFieldNom.setVisible(true);
				txtIntrodueixElNou_1.setVisible(false);
				textFieldTipus.setVisible(false);
				txtIntrodueixCampA.setVisible(false);
				textFieldCamp.setVisible(false);
				
				btnModificarTipus.setSelected(false);
				btnModificarCamp.setSelected(false);
			}
		});
		
		btnModificarTipus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtIntrodueixElNou.setVisible(false);
				textFieldNom.setVisible(false);
				txtIntrodueixElNou_1.setVisible(true);
				textFieldTipus.setVisible(true);
				txtIntrodueixCampA.setVisible(false);
				textFieldCamp.setVisible(false);
				
				btnModificarNom.setSelected(false);
				btnModificarCamp.setSelected(false);
			}
		});
		
		btnModificarCamp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				txtIntrodueixElNou.setVisible(false);
				textFieldNom.setVisible(false);
				txtIntrodueixElNou_1.setVisible(false);
				textFieldTipus.setVisible(false);
				txtIntrodueixCampA.setVisible(true);
				textFieldCamp.setVisible(true);
				
				btnModificarNom.setSelected(false);
				btnModificarTipus.setSelected(false);
				btnGo.setVisible(true);
			}
		});
		
		/*btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModCampPlantilla18b obj = new ModCampPlantilla18b();
				obj.setVisible(true);
			}
		});*/
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//modificar el nom de la plantilla
				String s = textFieldNom.getText();
				if(s.isEmpty()){}
				else {
					ControladorInterficie.setNomPlant11(s);
				}
				
				//modificar el tipus de la plantilla
				s = textFieldTipus.getText();
				if(s.isEmpty()){}
				else{
					if(s.equals("Autor") || s.equals("Conferencia") || s.equals("Terme") || s.equals("Paper")) {
						if(s.equals(ControladorInterficie.getTipusPlant())){}
						else{
							int resp = JOptionPane.showConfirmDialog(null,"Si cambia el tipus es borraran TOTS els camps de la plantilla. Vol procedir?", "Alerta!", JOptionPane.YES_NO_OPTION);
							if(resp == 1){ //resp = no
								textFieldTipus.setText(ControladorInterficie.getTipusPlantilla());
							}
							else{ //resp = si
								ControladorInterficie.setTipusPlant11(s);
								ControladorInterficie.borrarCamp12();
							}
						}
					}
					else JOptionPane.showMessageDialog(null, "Tipus no val·lid. Tipus valids: Autor, Conferencia, Terme i Paper");
				}
				
				//modificar un camp de la plantilla
				s = textFieldCamp.getText();
				if(s.isEmpty()){
					ControladorInterficie.cargarPlantilla();
					try {
						ControladorInterficie.VistaConsPlant17();
					} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
						e1.printStackTrace();
					}
				}
				else{
					ControladorInterficie.setNumCamp(Integer.parseInt(s));
					ControladorInterficie.VistaModCampPlantilla18b();
					dispose();
				}
				
				dispose();
			}
		});
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorInterficie.VistaConsPlant17();
				} catch (NumberFormatException | FicheroNoExiste | IOException e1) {
					e1.printStackTrace();
				}
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
	}
}