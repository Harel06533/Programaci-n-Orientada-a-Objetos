/* Ejercicio1 - Validación de una entrada de texto */
package Semana2.Lunes;

import javax.swing.JOptionPane;

public class Clave {
  public static void main (String[] args) {
    String userKey = "", finalOutput = "", actualKey = "miNoviaHermosa123";
    int tries = 1;
    /**
     * 1. Checa si ya van varios intentos (Muestra un mensaje específico)
     * 2. Si retornó null (Escape) entonces significa que se rindió y finaliza
     * 3. Si quedó vacío signific que puso enter sin avanzar y no avanza los intentos
     * 4. Esto se loopea al menos una vez y si coniciden las claves, finaliza, si no, repite el proceso de nuevo
     */
    do {
      String message = (tries == 1) ? (String.format("Guess the key\nTry #%d", tries)) : (String.format("Wrong, try again\n Try #%d", tries));
      userKey = JOptionPane.showInputDialog(message);

      if (userKey == null) {                                        
        finalOutput = String.format("You didn't guess the key after %d tries", tries); 
        break;
      }

      if (userKey.isEmpty()) 
        continue;
      tries++;
    } while (!userKey.equals(actualKey));

    if (finalOutput.isEmpty())
      finalOutput = String.format("You guess the key: %s, after %d tries", actualKey, tries - 1);
    JOptionPane.showMessageDialog(null, finalOutput);
  }
}