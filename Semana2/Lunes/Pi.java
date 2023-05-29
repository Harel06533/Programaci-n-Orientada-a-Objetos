package Semana2.Lunes;

import javax.swing.JOptionPane;

public class Pi {

  public static void main (String[] args) {
    int iterations = 0;
    double result = 0.0;
    do {
      try {
        iterations = Integer.parseInt(JOptionPane.showInputDialog("Enter Pi iterations"));
      } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid input", "Warning", JOptionPane.ERROR_MESSAGE);
      }
    } while(iterations <= 0);

    for (int i = 0; i < iterations; i++) 
      result += (Math.pow(-1, i) / ((2 * i) + 1)); 
    result *= 4;
    JOptionPane.showMessageDialog(null, String.format("%.10f", result), "Result", 1);
  }
}