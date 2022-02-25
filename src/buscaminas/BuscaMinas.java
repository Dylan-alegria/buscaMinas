/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;
import javax.swing.*;
public class BuscaMinas {

    public static void main(String[] args) {
   int filaa = Integer.parseInt(JOptionPane.showInputDialog("intruduce numero filas"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("intruduce numero columnas "));
 
        int Cantminas = Integer.parseInt(JOptionPane.showInputDialog("intruduce numero de minas  "));
 
        if (Cantminas > columna) {
            System.out.println("La cantidad dde minas debe ser menor o igual que la columnas ");
            System.exit(0);
        }
        if (Cantminas < 1) {
 
            System.out.println("La cantidad de minas debe ser mayo a 1  ");
            System.exit(0);
        } else {
            int matriz[][] = new int[filaa][columna];/// matriz que contiene el juego
 
            String matriz2[][] = new String[filaa][columna];/// matriz que se muestra 
 
            for (int x = 0; x < matriz.length; x++) {////////// llena toda la matriz de campos sin minas   
                for (int y = 0; y < matriz[x].length; y++) {
                    matriz[x][y] = 1;
                }
            }
 
            for (int x = 0; x < matriz2.length; x++) {  ///////////////llena la matriz dos de #
                for (int y = 0; y < matriz2[x].length; y++) {
                    matriz2[x][y] = "#";
                }
            }
            int i = 0;
            while (i < Cantminas) {// se llena el campo de minas con la cantidad que el usuario digito
 
                int numero1 = (int) (Math.random() * columna);
                int numero2 = (int) (Math.random() * filaa);
 
                if (matriz[numero2][numero1] != 0) {////// para que las minas nose repitan 
                    matriz[numero2][numero1] = 0;
                    i++;
                }
            }
        ////////////////////// el indice 
            int cont = 0;
            while (cont < columna) {
                System.out.print(cont + "|");
 
                cont++;
            }
            System.out.println();

            //////////////////imprime la matriz que se muestra 
 
            for (String[] fila : matriz2) {        // Para cada fila de la matriz 
                for (String elemento : fila) {    // Para cada elemento de la fila 
 
                    System.out.print(elemento + "|");    // Imprime elemento 
 
                }
                System.out.println();     // Imprime salto de línea 
            }
            boolean salir = false;
            //////////////////validacion de si es mina o no 
 
            while (!salir) {
                int a = Integer.parseInt(JOptionPane.showInputDialog("intruduce numero de la fila "));
                int b = Integer.parseInt(JOptionPane.showInputDialog("intruduce numero  de la columna  "));
                int c = b + 1;
                if (matriz[a][b] == 1) {
                    matriz2[a][b] = "1";
                    int o = -1;
                    int g = a + 1;
                    int p = a - 1;
                    int col = columna - 1;
                    int d = a + 1;
                    int fil = filaa - 1;
                    int z = b + 1;
                    int y = b - 1;
 
                    if (g < col) { /// limite de abajo
                        if (z < fil) {// limites del lado derecho
 
                            if (matriz[a][c] == 1) {//numero de al lado 
 
                                matriz2[a][c] = "1";
                            }
 
                            if (matriz[g][c] == 0) {
                                System.out.println("-------------");
                                matriz2[a][c] = "2";
                            }
 
                            if (p > o) {///limite de arriba
                                if (matriz[p][c] == 0) {
                                    matriz2[a][c] = "2";
                                }
                                if (matriz[p][c] == 0 && matriz[g][c] == 0) {
 
                                    matriz2[a][c] = "3";
 
                                }
                            }
                           // if (fil > a) {
 
                                if (matriz[d][b] == 1) {
                                    matriz2[d][b] = "1";
 
                                }
 
                                if (matriz[d][z] == 0) {
 
                                    matriz2[d][b] = "2";
                                }
                            //}
                            if (y < o) {//limite de lado izquierdo
                                if (matriz[d][y] == 0) {
                                    matriz2[d][b] = "2";
                                }
                                if (matriz[d][y] == 0 && matriz[d][z] == 0) {
 
                                    matriz2[d][b] = "3";
 
                                }
 
                            }
 
                        }
                    }
                    System.out.println("------------------------------------------");
                            ////////////////////// el indice 
            int cont1 = 0;
            while (cont1 < columna) {
                System.out.print(cont1 + "|");
 
                cont1++;
            }
            System.out.println();

/////////////////////////////////////////////////////////////////////////////////////////////////////
                    for (String[] fila : matriz2) {        // Para cada fila de la matriz 
                        for (String elemento : fila) {    // Para cada elemento de la fila 
                            System.out.print(elemento + " ");    // Imprime elemento 
                        }
                        System.out.println();     // Imprime salto de línea 
                    }
 
                } else if (matriz[a][b] == 0) {//////////// imprime cuando el usuario pierde 
                    matriz2[a][b] = "X";
                    System.out.println("------------------------------------------");
                    for (String[] fila : matriz2) {        // Para cada fila de la matriz 
                        for (String elemento : fila) {    // Para cada elemento de la fila 
                            System.out.print(elemento + " ");    // Imprime elemento 
                        }
                        System.out.println();     // Imprime salto de línea 
                    }
                    System.out.println("exploto una mina ");
                    salir = true;
                }
            }
        }
 
    }
}
    
    

