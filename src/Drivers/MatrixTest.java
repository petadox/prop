/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import domini.Matrix;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author Alejandro Ibáñez
 */
public class MatrixTest {
    
    public static void main(String [] args) {
        System.out.println("Puede realizar las siguientes acciones introduciendo el numero indicado: \n"
                + 
                "2.- Añadir un arco a la matriz.\n" +
                "3 - Comprobar si existe un arco determinado .\n" +
                "4 - Eliminar un arco de la matriz.\n" +
                "5 - Transponer una matriz.\n" +
                "6 - Comprobar el número de filas de la matriz.\n" +
                "7 - Comprobar el número de columnas de la matriz.\n" +
                "8 - Comprobar el valor de un arco.\n" +
                "9 - Retornar una fila.\n" +
                "10 - Retornar una columna.\n" +
                "11 - Especificar el tamaño a la matriz.\n" +
                "12 - Copiar el tamaño de la matriz.\n" +
                "13 - Eliminar las relaciones de una fila.\n" +
                "14 - Eliminar las relaciones de una columna.\n" +
                "15 - Añadir un nodo a las filas de la matriz.\n" +
                "16 - Añadir un nodo a las columnas de la matriz.\n" +
              
                
                "Si desea salir del test introduzca un 0. \n");
        Matrix mat;
        mat = new Matrix();
        Scanner in = new Scanner (System.in);
        int op = Integer.parseInt(in.nextLine());
        Boolean end = false;
        while (!end) {
            switch(op) {
                case 1:
                    end = true;
                    break;
                   
                case 2:
                    System.out.print("Introduce el id del primer nodo\n");
                    int id1 = Integer.parseInt(in.nextLine());
                    System.out.print("Introduce el id del segundo nodo\n");
                    int id2 = Integer.parseInt(in.nextLine());
                    mat.afegirArc(id1, id2);
                    System.out.print("Se ha añadido el arco deseado\n");
                    break;
                case 3:
                    System.out.print("Introduce el id del primer nodo\n");
                    int index1 = Integer.parseInt(in.nextLine());
                    System.out.print("Introduce el id del segundo nodo\n");
                    int index2 = Integer.parseInt(in.nextLine());
                    boolean existe = mat.existeixArc(index1, index2);
                    if (existe)System.out.print("Existe el arco indicado\n");
                    else System.out.print("El arco indicado no existe\n");
                    break;
                case 4:
                    System.out.print("Introduce el id del primer nodo a borrar\n");
                    int i1 = Integer.parseInt(in.nextLine());
                    System.out.print("Introduce el id del segundo nodo a borrar\n");
                    int i2 = Integer.parseInt(in.nextLine());
                    mat.esborrarArc(i1, i2);
                    System.out.print("Se ha borrado el arco deseado\n");
                    break;
                    
                case 5:
                    mat.trasposarMatriu();
                    System.out.print("Se ha transpuesto la matriz\n");
                    break;
                    
                case 6:
                    System.out.println ("Devuelve el num de filas: " + mat.getNRows() + "\n");
                    break;
                    
                case 7:
                    System.out.println ("Devuelve el num de columnas: " + mat.getNCols() + "\n");
                    break;
                    
                case 8:
                    System.out.print("Introduce el id del primer nodo a consultar\n");
                    int ind1 = Integer.parseInt(in.nextLine());
                    System.out.print("Introduce el id del segundo nodo a consultar\n");
                    int ind2 = Integer.parseInt(in.nextLine());
                    System.out.println ("La relación entre estos dos nodos es: " + mat.getValue(ind1,ind2) + "\n");
                    break;
                    
                case 9:
                    System.out.print("Introduce la fila a retornar");
                    int i = Integer.parseInt(in.nextLine());
                    mat.getRow(i);
                    break;
                    
                case 10:
                    System.out.print("Introduce la columna a retornar\n");
                    int n = Integer.parseInt(in.nextLine());
                    mat.getCol(n);
                    
                case 11:
                    System.out.print("Introduce el número de filas y columnas que deseas poner\n");
                    int f = Integer.parseInt(in.nextLine());
                    int c = Integer.parseInt(in.nextLine());
                    mat.setTamany(f, c);
                    break;
                    
                case 12:
                    System.out.print("Introduce el numero de filas:\n");
                    int f1 = Integer.parseInt(in.nextLine());
                    System.out.print("Introduce el numero de columnas:\n");
                    int f2 = Integer.parseInt(in.nextLine());
                    Matrix mp = new Matrix();
                    mp.setTamany(f1,f2);
                    mat.copiaTamany(mp);
                    break;
                    
                case 13:
                    System.out.print("Introduce la id del nodo de la fila que quieres borrar\n");
                    int id3 = Integer.parseInt(in.nextLine());
                    mat.borraFila(id3);
                    System.out.print("Se ha borrado la fila indicada\n");
                    break;
                case 14:
                    System.out.print("Introduce la id del nodo de la columna que quieres borrar\n");
                    int id4 = Integer.parseInt(in.nextLine());
                    mat.borraCol(id4);
                    System.out.print("Se ha borrado la columna indicada\n");
                    break;
                    
                case 15:
                    mat.addNodeRow();
                    System.out.print("Se ha añadido el nodo correspondiente a las filas\n");
                    break;
                    
                case 16:
                    mat.addNodeCol();
                    System.out.print("Se ha añadido el nodo correspondiente a las columnas\n");
                    break;
            }
            System.out.println ("Por favor introduce una opcion: ");
            op = Integer.parseInt(in.nextLine());
        }   
    }
}
