package Semana2.Martes;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Grades {
  public static void main (String[] args) {
    int gradeQuant = (int)(validUserInput("Enter number of grades"));                 //--> Obtiene el input del usuario
    if (gradeQuant == -1)                                                                         //--> Si fue "esc" finaliza
      return;
    float[] gradeArray = new float[gradeQuant];                                                   //--> Genera un arreglo con el tamaño dado
    float median;
    int iteration = 0;

    while (iteration != gradeQuant) {                                                             //--> Itera mientras la iteración y el tamaño no coincidan
      float currGrade = validUserInput("Enter iteration #" + (iteration + 1));
      if (currGrade == -1)
        return;
      gradeArray[iteration] = currGrade;
      iteration++;
    }

    Arrays.sort(gradeArray);                                                                      //--> Acomoda el arreglo
    String stringArrayFormat = formatFloatArray(gradeArray);                                      //--> Retorna un String como "arreglo" para imprimir
    paneInfo(stringArrayFormat, "Array of grades");

    median = (gradeQuant % 2 != 0) ? (gradeArray[gradeQuant / 2]) : (gradeArray[gradeQuant / 2] + gradeArray[(gradeQuant / 2) - 1]) / 2; //--> Calcula la mediana
    paneInfo(median + "", "Median of Array");
  }

  /* Crea un string para dar formato a un arrelgo de floats de la forma -> "[a, b, c]" */
  public static String formatFloatArray (float[] array) {
    String output = "[ ";
    for (int i = 0; i < array.length; i++) {
      output += (array[i] + ", ");
    }
    output += " ]";
    return output;
  }

  /* Valida una entrada de usuario usando JOptionPane y solo retorna ya que sea válida */
  public static float validUserInput (String baseMessage) {
    float input;
    while (true) {

      String strInput = paneInput(baseMessage);
      if (strInput == null)
        return -1;

      if (strInput.isEmpty()) {
        paneError("Empty value not valid");
        continue;
      }

      try {
        input = Float.parseFloat(strInput);
        if (input <= 0) {
          paneError("Negative Value or 0 are not valid");
          continue;
        }
      } catch (NumberFormatException e) {
        paneError("Invalid format");
        continue;
      }
      break;
    }
    return input;
  }

  public static String paneInput (String message) {
    return (JOptionPane.showInputDialog(message));
  }

  public static void paneInfo (String message, String title) {
    JOptionPane.showMessageDialog(null, message);
  }

  public static void paneError (String message) {
    JOptionPane.showMessageDialog(null, message, "ERROR", 0);
  }
}