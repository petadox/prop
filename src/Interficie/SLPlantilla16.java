package Interficie;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
import java.awt.ScrollPane;
import javax.swing.JList;
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
	}
}