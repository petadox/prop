package Interficie;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Excepcions.FicheroNoExiste;
public class SLPerfiles9 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SLPerfiles9 frame = new SLPerfiles9();
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
	public SLPerfiles9() throws FicheroNoExiste, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser absoluto = new JFileChooser();
		absoluto.setCurrentDirectory(new File("C:\\Users\\Albert Ripol\\Desktop\\PracticaProp\\ProjectePROP\\BaseDades"));
		absoluto.showOpenDialog(absoluto);
		String ruta = absoluto.getSelectedFile().getAbsolutePath();
		
		if(ControladorInterficie.getMenu2() == "Consultar" || 
		   ControladorInterficie.getMenu2() == "Modificar"){
			   ControladorInterficie.loadP(ruta);
		}
		else if(ControladorInterficie.getMenu2() == "Borrar"){
			ControladorInterficie.deleteP(ruta);
		}
		dispose();
	}
}