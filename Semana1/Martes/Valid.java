package Semana1.Martes; 
public class Valid {
  public static void main (String[] args) {
    double a = 0.5;
    double b = .5;
    double c = 9.3e12;
    double d = 9.3e-13;
    int e = 12345678;
    double g = 0.8E+0.8;                        //--> No es válido ya que .8 no es notación científica válida
    double h = 0.8E 8;                          //--> No es un valor válido
    int i = 05_15;
    int j = 018CDF;                             //--> No está especificado el hexadecimál
    long k = 0XBC5DA;
    long l = 0x87e3a;
    long m = 234567L;
    int n = 0_B11;
    int o = 010101;
    int p = 0_577;
    double q = .00.8E2;                         //--> El token .8E2 después del .00 no es un punto válido
    double r = .3e3f;
    int s = 0b111;
    long t = 12_234L;
    long z = 123456789_L;                       //--> Los guiones bajos deben ser en medio de los números
  }
}