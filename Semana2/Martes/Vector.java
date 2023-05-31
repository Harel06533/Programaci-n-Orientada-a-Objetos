package Semana2.Martes;

public class Vector {
  public static void main (String[] args) {
    /* Declaración de Variables */
    int x = 5;
    int maxCounter = 0;
    int oddCounter = 0;
    int maxIndex = 0;
    int oddIndex = 0;
    short[] vector = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 24};
    short[] maxVector;
    short[] oddVector;

    /* Primera iteración - Obtiene los tamaños de cada arreglo */
    for (int i = 0; i < vector.length; i++) {
      if (vector[i] > x) 
        maxCounter++;
      if (vector[i] % 2 != 0)
        oddCounter++;
    }

    /* Aloca espacio en memoria basado en los tamaños obtenidos */
    maxVector = new short[maxCounter]; 
    oddVector = new short[oddCounter];

    /* Segunda iteración - Asigna sus respectivos valores a cada arreglo */
    for (int i = 0; i < vector.length; i++) {
      if (vector[i] > x) {
        maxVector[maxIndex] = vector[i];
        maxIndex++;
      }
      if (vector[i] % 2 != 0) {
        oddVector[oddIndex] = vector[i];
        oddIndex++;
      }
    }
    printArray(maxVector);
    printArray(oddVector);
  }

  /* Método para imprimir un arreglo */
  public static void printArray (short[] array) {
    System.out.print("[ ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(String.format("%d, ", array[i]));
    }
    System.out.println("]");
  }
}