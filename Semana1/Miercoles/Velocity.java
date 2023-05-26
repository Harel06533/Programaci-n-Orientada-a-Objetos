package Semana1.Miercoles;

import javax.swing.JOptionPane;

public class Velocity {
  public static void main (String[] args) {
    String strDistance = JOptionPane.showInputDialog("Enter the Distance value in Kilometers");       //--> Retorna el user input
    String strInitTime = JOptionPane.showInputDialog("Enter initial time value in minutes");
    String strFinalTime = JOptionPane.showInputDialog("Enter final time value in minutes");

    double distance = Double.parseDouble(strDistance);                                                      //--> Parsea el user input a Double
    double initTime = Double.parseDouble(strInitTime);
    double finalTime = Double.parseDouble(strFinalTime);

    double result = (distance / ((finalTime - initTime) / 60)); 
    String resultDisplay = String.format("The velocity = %.2f km/h", result);
    JOptionPane.showMessageDialog(null, resultDisplay);
  }
}