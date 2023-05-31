package Semana2.Martes;

public class MatrixSum {
  public static void main (String[] args) {
    int randRow = (int)((Math.random() * 10) + 1);                    //--> Tamaño random de filas
    int randColumns = (int)((Math.random() * 10) + 1);                //--> Tamao random de columnas

    int[][] mat1 = genRandMatrix(randRow, randColumns);               //--> Genera una matríz 
    int[][] mat2 = genRandMatrix(randRow, randColumns);               //--> Genera otra matríz
    int[][] sumMat = sumMatrix(mat1, mat2);                           //--> Obtiene la suma de las matríces

    System.out.println("MATRIX 1");
    printMatrix(mat1);
    System.out.println("MATRIX 2");
    printMatrix(mat2);
    System.out.println("MATRIX 3");
    printMatrix(sumMat);
  }

  /**
   *  Suma dos matríces y retorna una nueva con el resultado
   * @param matrix1 -> La matriz 1
   * @param matrix2 -> La matriz 2
   * @return -> Una matriz que contiene el resultado de la suma de ambas matríces
   */
  public static int[][] sumMatrix (int[][] matrix1, int[][] matrix2) {
    if (matrix1.length != matrix2.length)                                   //--> Si no coinciden los tamaños finaiza
      return null;
    int[][] resultMatrix = new int[matrix1.length][matrix1[0].length];      //--> Crea una nuev matríz
    for (int i = 0; i < matrix1.length; i++)
      for (int j = 0; j < matrix1[i].length; j++)
        resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];                 //-->
    return resultMatrix;
  }

  /**
   * Genera una matríz de números aleatorios
   * @param rows El tamaño de las filas
   * @param columns El tamaño de las columnas
   * @return Una matríz generada aleatoriamente
   */
  public static int[][] genRandMatrix (int rows, int columns) { 
    int[][] matrix = new int[rows][columns];
    for (int i = 0; i < matrix.length; i++) 
      for (int j = 0; j < matrix[i].length; j++)
        matrix[i][j] = (int)((Math.random() * 20) + 1);
    return matrix;
  }

  /**
   * Imprime una matriz
   * @param matrix la matriz a imprimir
   */
  public static void printMatrix (int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
} 