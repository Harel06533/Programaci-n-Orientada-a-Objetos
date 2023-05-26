package Semana1.Jueves;

import javax.swing.JOptionPane;

public class MonthDays {
  public static int monthDays (String month, int year) {
    switch (month) {

      case "ENERO", "MARZO", "JULIO", "AGOSTO", "OCTUBRE", "DICIEMBRE":                         //--> Caso de 31 días
        return 31;

      case "ABRIL", "JUNIO", "SEPTIEMBRE", "NOVIEMBRE":                                         //--> Caso de 30 días
        return 30;

      case "FEBRERO":                                                                           //--> Caso de febrero (En base al año, determina si es o no bisisesto)
        int febDays = (year % 4 != 0 || year % 400 != 0 && year % 100 == 0) ? (28) : (29);
        return febDays;

      default:
        return -1;
    }
  }
  public static void main (String[] args) {
    String month = JOptionPane.showInputDialog("Enter month").toUpperCase().trim();
    int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year"));
    int days = monthDays(month, year);

    String output = "Not Valid entry";
    if (days != -1)
      output = String.format("Month is %s, has %d days and year is %d", month, days, year);
    JOptionPane.showMessageDialog(null, output);
  }
}