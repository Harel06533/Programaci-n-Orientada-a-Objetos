package Semana1.Miercoles;

import javax.swing.JOptionPane;

public class FullName {
  public static void main (String[] args) {
    String firstName = JOptionPane.showInputDialog("Enter your first name");
    String pLastName = JOptionPane.showInputDialog("Enter parent's last name");
    String mLastName = JOptionPane.showInputDialog("Enter mother's last name");
    
    String fullName = String.format("%s %s %s", firstName, pLastName, mLastName);
    JOptionPane.showMessageDialog(null, fullName);
  }
}