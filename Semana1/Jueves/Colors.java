package Semana1.Jueves;

import javax.swing.JOptionPane;

public class Colors {

  public static double doubleMax3 (double a, double b, double c) {
    double maxAB = (a > b) ? a : b;
    if (maxAB > c)
      return maxAB;
    return c;
  }
  public static void main (String[] args) {
    int rgbColor = Integer.parseInt(JOptionPane.showInputDialog("Enter RGB value in hexadecimal"), 16);
    int redIntense = ((rgbColor & 0xff0000) >> 16);
    int greenIntense = ((rgbColor & 0xff00) >> 8);
    int blueIntense = (rgbColor & 0xff);

    float redPrime = (float)redIntense / 255;
    float greenPrime = (float)greenIntense / 255;
    float bluePrime = (float)blueIntense / 255; 

    double k = (1 - doubleMax3(redPrime, greenPrime, bluePrime));
    double c = ((1 - redPrime - k) / (1 - k));
    double m = ((1 - greenPrime - k) / (1 - k));
    double y = ((1 - bluePrime - k) / (1 - k));

    String rgbOutput = String.format("Red: %d, Green: %d, Blue: %d", redIntense, greenIntense, blueIntense);
    String cmkyOutput = String.format("Cyan: %.2f, Magenta: %.2f, Yellow: %.2f, Black: %.2f", c, m, y, k);

    JOptionPane.showMessageDialog(null, "RGB Output = " + rgbOutput);
    JOptionPane.showMessageDialog(null, "CMYK Output = " + cmkyOutput);
  }
}