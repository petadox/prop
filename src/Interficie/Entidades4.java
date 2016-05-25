package Interficie;
//@author Eduard Maestro
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
@SuppressWarnings("serial")
public class Entidades4 extends JFrame {
	private JPanel contentPane;
	private JTextField txtSeleccionaUnaEntidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entidades4 frame = new Entidades4();
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
	public Entidades4() {
		setTitle("Entidades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btnAutor = new JToggleButton("Autor");
		btnAutor.setBounds(43, 68, 150, 50);
		contentPane.add(btnAutor);
		
		JToggleButton btnConferencia = new JToggleButton("Conferencia");
		btnConferencia.setBounds(240, 68, 150, 50);
		contentPane.add(btnConferencia);
		
		JToggleButton btnPaper = new JToggleButton("Paper");
		btnPaper.setBounds(43, 142, 150, 50);
		contentPane.add(btnPaper);
		
		JToggleButton btnTerme = new JToggleButton("Terme");
		btnTerme.setBounds(240, 142, 150, 50);
		contentPane.add(btnTerme);
		
		JButton btnBack = new JButton(new ImageIcon("back.jpg"));
		btnBack.setBounds(10, 215, 131, 31);
		contentPane.add(btnBack);
		
		JButton btnNext = new JButton(new ImageIcon("next.jpg"));
		btnNext.setBounds(293, 215, 131, 31);
		contentPane.add(btnNext);
		
		txtSeleccionaUnaEntidad = new JTextField();
		txtSeleccionaUnaEntidad.setEditable(false);
		txtSeleccionaUnaEntidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSeleccionaUnaEntidad.setText("Selecciona una entidad");
		txtSeleccionaUnaEntidad.setBounds(133, 11, 167, 31);
		contentPane.add(txtSeleccionaUnaEntidad);
		txtSeleccionaUnaEntidad.setColumns(10);
		
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnConferencia.isSelected() ) btnConferencia.setSelected(false); ;
				if(btnPaper.isSelected()) btnPaper.setSelected(false);
				if(btnTerme.isSelected()) btnTerme.setSelected(false);
			}
		});
		
		btnConferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected() ) btnAutor.setSelected(false);
				if(btnPaper.isSelected()) btnPaper.setSelected(false);
				if(btnTerme.isSelected()) btnTerme.setSelected(false);
			}
		});
		
		btnPaper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected()) btnAutor.setSelected(false);
				if(btnConferencia.isSelected() ) btnConferencia.setSelected(false);
				if(btnTerme.isSelected()) btnTerme.setSelected(false);
			}
		});
		
		btnTerme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected()) btnAutor.setSelected(false);
				if(btnConferencia.isSelected() ) btnConferencia.setSelected(false);
				if(btnPaper.isSelected()) btnPaper.setSelected(false);
			}
		});
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAutor.isSelected())ControladorInterficie.setEntidades4("Autor");
				else if(btnPaper.isSelected())ControladorInterficie.setEntidades4("Paper");
				else if(btnConferencia.isSelected())ControladorInterficie.setEntidades4("Conferencia");
				else ControladorInterficie.setEntidades4("Terme");
				
				if (ControladorInterficie.getMenu2().equals("Crear")) { 
					if(ControladorInterficie.getElement3().equals("Entidades") ||
						ControladorInterficie.getElement3().equals("Perfiles") ||
						ControladorInterficie.getElement3().equals("Plantillas")) {
							ControladorInterficie.VistaIntroduirNom5();
					}
					else ControladorInterficie.VistaEntRel7();
				}
				else if (ControladorInterficie.getMenu2().equals("Consultar")) {
					if (ControladorInterficie.getElement3().equals("Entidades")) ControladorInterficie.VistaSLEntidades6();
					else if (ControladorInterficie.getElement3().equals("Perfiles")) ControladorInterficie.VistaSLPerfiles9();
					else if (ControladorInterficie.getElement3().equals("Plantillas"))
						try {
							ControladorInterficie.VistaSLPlantilla16();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					else ControladorInterficie.VistaEntRel7();
				}
				else if (ControladorInterficie.getMenu2().equals("Modificar")) {
					if (ControladorInterficie.getElement3().equals("Entidades")) ControladorInterficie.VistaSLEntidades6();
					else if (ControladorInterficie.getElement3().equals("Perfiles")) ControladorInterficie.VistaSLPerfiles9();
					else if (ControladorInterficie.getElement3().equals("Plantillas"))
						try {
							ControladorInterficie.VistaSLPlantilla16();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					else ControladorInterficie.VistaEntRel7();
				}
				else {
					if (ControladorInterficie.getElement3().equals("Entidades")) ControladorInterficie.VistaSLEntidades6();
					else if (ControladorInterficie.getElement3().equals("Perfiles")) ControladorInterficie.VistaSLPerfiles9();
					else if (ControladorInterficie.getElement3().equals("Plantillas"))
						try {
							ControladorInterficie.VistaSLPlantilla16();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					else ControladorInterficie.VistaEntRel7();
				}
				
				
				
				dispose();
			}
		});
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//ControladorInterficie.setEntidades4((""));
				ControladorInterficie.VistaElementos3();
				dispose();
			}
		});
	}
}


