package persistencia;
//@Author Albert Ripol
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import Excepcions.FicheroNoExiste;
import Excepcions.FicheroYaExistente;
public class GestioDades {
	/* Crea un nuevo archivo con el nombre "nombre" y de tipo .txt en el directorio
    "directorio". "directorio" debe ser una ruta correcta, y el archivo solo se creara
    si no hay ningun otro archivo llamado asi. */
   public static void Crear_archivo(String nombre, String directorio) throws IOException, FicheroYaExistente {
   //TODO --> CRIDA IOException si no troba la ruta especificada.
       File archivo = new File(directorio + nombre + ".txt");
       if (!archivo.exists()) {
           try{ archivo.createNewFile();}
           catch(IOException ex){ex.printStackTrace();}
       }
       else throw new FicheroYaExistente("Ya existe un archivo con ese nombre.");
   }
   /* Borra el archivo "nombre" de extension .txt del directorio "directorio", siempre y cuando
   "directorio" sea una ruta valida y el archivo "nombre".txt exista.
    */
   public static void Borrar_archivo(String ruta) throws FicheroNoExiste, IOException {
       File archivo = new File(ruta + ".txt");
       if (!archivo.exists())
           throw new FicheroNoExiste("No existe ningun archivo con ese nombre en el directorio especificado.");
       else {
           boolean borrado = archivo.delete();
           if (!borrado) throw new IOException("No se pudo borrar el fichero.");
       }
   }
   /* Modifica el nombre del fichero "nombre_viejo".txt del directorio "directorio",
   cambiandolo a "nombre_nuevo".txt. Es necesario que "directorio" sea una ruta valida,
   "nombre_viejo".txt exista y "nombre_nuevo".txt no exista. */
   public static void Modificar_nombre_archivo(String nombre_nuevo, String nombre_viejo, String directorio)
       throws FicheroNoExiste, FicheroYaExistente, IOException {
       File f1 = new File(directorio + "/" + nombre_viejo + ".txt");
       File f2 = new File(directorio + "/" + nombre_nuevo + ".txt");
       if (!f1.exists())
           throw new FicheroNoExiste("No existe ningun archivo con ese nombre en el directorio especificado");
       else if (f2.exists())
           throw new FicheroYaExistente("Ya existe un archivo con ese nombre en el directorio indicado.");
       else {
           boolean renombrado = f1.renameTo(f2);
           if (!renombrado) throw new IOException("No se pudo renombrar el fichero.");
       }
   }
   
   /* Escribe al final del archivo "nombre_archivo".txt del directorio "directorio" el string "contenido"
   seguido del string "separador" siempre y cuando "nombre_archivo".txt exista y "directorio" sea una ruta valida.
   Es recomendable usar "\n" como separador. Este se usa introduciendo como separador la palabra "salto". */
   public static void Escribir_string(String contenido, String separador, String nombre_archivo, String directorio)
           throws IOException, FicheroNoExiste {
       File archivo = new File(directorio + nombre_archivo + ".txt");
       if (!archivo.exists())
           throw new FicheroNoExiste("No existe ningun fichero con ese nombre en el directorio indicado.");
       else {
           FileWriter lecturaArchivo = new FileWriter(directorio + nombre_archivo + ".txt", true);
           if (separador.equals("salto")) separador = "\n";
           lecturaArchivo.write(contenido + separador);
           lecturaArchivo.close();
       }
   }
   
   public static String Leer_string(String nombre_archivo, String directorio, String separador, int n_veces)
           throws IOException, FicheroNoExiste {
   //TODO tira NoSuchElementException si en la primera linea no esta el separador indicado.
       File archivo = new File(directorio + "/" + nombre_archivo + ".txt");
       if (!archivo.exists())
           throw new FicheroNoExiste("No existe un fichero con ese nombre en el directorio indicado.");
       else if (separador.equals("salto") || separador.equals("\n")) {
           BufferedReader br = new BufferedReader(new FileReader(archivo));
           String line = br.readLine();
           for (int i = 0; i < n_veces; ++i) {
               line = br.readLine();
           }
           br.close();
           return line;
       } else {
           BufferedReader br = new BufferedReader(new FileReader(archivo));
           String line = br.readLine();
           StringTokenizer st = new StringTokenizer(line, separador);
           while (n_veces > 0) {
               st.nextToken();
               --n_veces;
           }
           br.close();
           return st.nextToken();
       }
   }
public static int getLastId(String tipus) {
	// TODO Auto-generated method stub
	return 0;
}
}
