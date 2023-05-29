package Semana2.Lunes;

import javax.swing.JOptionPane;

public class Price {
  public static void main (String[] args) {
    double price = 0;
    while (true) {
      String stringPrice = paneInput("Enter price value");
      if (stringPrice == null) {
        paneMessage("Program Terminated", "EXIT");
        return;
      }

      if (stringPrice.isEmpty()) {
        paneError("Empty input not valid");
        continue;
      }

      try {
        price = Double.parseDouble(stringPrice);
        if (price <= 0) {
          paneError("Negative or 0 numbers are not valid");
          continue;
        }
      } catch (NumberFormatException e) {
        paneError("Invalid input format");
        continue;
      }
      break;
    }
    price += (price * 0.16);
    paneMessage(String.format("$%.2f", price), "Price with IVA");
  }

  /* Método para obtener un input de JOptionPane */
  public static String paneInput (String message) {
    return (JOptionPane.showInputDialog(message));
  }

  /* Método para mostrar un error de JOptionPane */
  public static void paneError (String output) {
    JOptionPane.showMessageDialog(null, output, "ERROR", 0);
  }

  /* Método para mostrar un mensaje de JOptionPane */
  public static void paneMessage(String output, String title) {
    JOptionPane.showMessageDialog(null, output, title, 1);
  }
}