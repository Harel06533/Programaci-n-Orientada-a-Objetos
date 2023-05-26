package Semana1.Miercoles;

public class Visual {
  public static void main (String[] args) {
    String s1 = "Hola";
    String s2 = "Hola";                                //--> s1 y s2 apuntan a la misma dirección de memoria
    String s3 = new String("Hola");           //--> Al usar new, se crea un nuevo espacio de memoria

    if (s1 == s2)
      System.out.println("s1 == s2");
    if (s1 == s3)
      System.out.println("s1 == s3");               //--> No imprimirá puesto que son diferentes locaciones en memoria
    
    if (s1.equals(s2))
      System.out.println("s1 equals s2");
    if (s1.equals(s3))
      System.out.println("s1 equals s3");
  }
}