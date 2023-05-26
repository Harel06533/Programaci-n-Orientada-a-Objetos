package Semana1.Jueves;

import javax.swing.JOptionPane;

public class TimeDistance {
  public static void main (String[] args) {
    double promVelocity = Double.parseDouble(JOptionPane.showInputDialog("Enter velocity value in km/h"));
    double distance = Double.parseDouble(JOptionPane.showInputDialog("Enter missing distance in km"));
    int time = Integer.parseInt(JOptionPane.showInputDialog("Enter time you expect to arrive in minutes"));

    double expectedTime = (distance/promVelocity);
    boolean arrivesAtTime = (((expectedTime * 60) - (time)) < 0);                                                     //--> (*60) para pasarlo a minutos
    String finalResult = (arrivesAtTime) ? ("You will to arrive at time") : ("You are not going to arrive at time");

    JOptionPane.showMessageDialog(null, finalResult);
  }
}