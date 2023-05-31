package Semana2.Martes;

public class Pyramid {
  public static void main (String[] args) {
    int randRow = (int)((Math.random() * 20) + 2);      //--> Genera un tamaño de filas aleatorio
    int[][] matrix = new int[randRow][];                //--> Crea una matriz basada en el tamaño

    for (int i = 0; i < matrix.length; i++) {           
      matrix[i] = new int[i + 1];                       //--> Por cada iteración, el tamaño de cada subarreglo vale i + 1
      for (int j = 0; j < matrix[i].length; j++) 
        matrix[i][j] = i + 1;                           //--> El valor de cada elemento de la matriz es i + 1
    }

    /* Imprime */
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++)
        System.out.print(matrix[i][j] + " ");
      System.out.println();
    }
  }
}