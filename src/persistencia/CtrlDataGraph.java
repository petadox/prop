/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import domini.Graph;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.InvalidObjectException;

/**
 *
 * @author albert
 */
public class CtrlDataGraph {

    /**
     * Create CtrlDataGraph instance
     *
     */
    public CtrlDataGraph() {
        
    }

    /**
     * Check if the file name.ser exist and can be read
     *
     * @param file is a path of the file wanted to be checked.
     * @return true if exists and can be read, either, false
     */
    public boolean checkSavedGraphFile(File file) {
        return file.exists() && file.canRead();
    }

    /**
     * Save the Graph g creating a Serializable file in savePath
     *
     * @param g is a Graph object
     * @param savePath is a valid Path of the system
     * @throws IOException
     * @throws NotSerializableException: an instance is required to have a
     * Serializable interface.
     * @throws InvalidClassException: there's a serializable exception in the
     * Graph class
     */
    public void saveGraph(Graph g, String savePath) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(savePath);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(g);
        outStream.close();
        fileOut.close();
    }

    /**
     * Load the Graph object stored in path graphPath
     *
     * @param graphPath is a valid path of .ser file
     * @return the object Graph stored in the file name.ser
     * @throws IOException
     * @throws FileNotFoundException: the file doesn't exist
     * @throws InvalidObjectException: error in deserialized object
     */
    public Graph loadGraph(String graphPath) throws IOException {

        Graph g = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(graphPath);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            g = (Graph) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (ClassNotFoundException c) {
            System.out.println("Graph class not found");
        }
        return g;
    }
    
    /**
     * Delete the Graph File .ser stored in graphPath
     * 
     * @param graphPath is a valid path
     */
    public boolean deleteGraphFile(String graphPath) throws IOException {
        File file = new File(graphPath);
        return file.delete();
    }
}
