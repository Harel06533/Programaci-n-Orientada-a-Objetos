/* Programa para calcular el precio con IVA (Basado en validaciones) */
/* - Cada salto a la siguiente iteración suelta un mensaje específico basado en todas las posibles excepciones */
package Semana2.Lunes;

import javax.swing.JOptionPane;

public class Price {
  public static void main (String[] args) {
    double price = 0;
    while (true) {                                                            //--> El loop iterará infinitas veces
      String stringPrice = paneInput("Enter price value");
      if (stringPrice == null) {                                              //--> Si la entrada de texto fue null (tecla escape)
        paneMessage("Program Terminated", "EXIT");
        return;                                                               //--> Finaliza el método main
      }

      if (stringPrice.isEmpty()) {                                            //--> Si es una string vacía (Fue la tecla Enter)
        paneError("Empty input not valid");                       
        continue;                                                             //--> Pasa a la siguiente iteración
      }

      try {
        price = Double.parseDouble(stringPrice);                              //--> Intenta parsear el valor a un double
        if (price <= 0) {                                                     //--> Si no regresó excepción pero sí un número negativo:
          paneError("Negative or 0 numbers are not valid");         
          continue;                                                           //--> Pasa a la siguiente iteración
        }
      } catch (NumberFormatException e) {                                     //--> Si saltó una excepción, pasa a la siguiente iteración
        paneError("Invalid input format");
        continue;
      }
      break;                                                                  //--> Si llegó hasta este punto, significa que la entrada fue válida y finaliza el loop
    }
    price += (price * 0.16);                                                  //--> Agrega IVA al precio
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