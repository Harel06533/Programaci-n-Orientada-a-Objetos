package Semana4.Martes;

import Semana4.Martes.Person.*;

public class TestPerson {
  public static void main (String[] args) {
    Person p = new Person("Harel Alejandro", "Olguín", "Gaytán", 19, Person.MALE); 
    Person p2 = p.clone();
  
    Student s = new Student("Miguel", "Hernández", "Sosa", 23, Student.OTHER_GENDER, Student.SOFTWARE, 114, 4);
    Student s2 = s.clone();

    Teacher t = new Teacher("Laura", "López", "Santana", 20, Teacher.FEMALE, 6, Teacher.DOCTOR, Teacher.DESI);
    Teacher t2 = t.clone();

    System.out.println(p);
    System.out.println(p2);
    System.out.println(p.equals(p2));

    System.out.println(s);
    System.out.println(s2);
    System.out.println(s.equals(s2));

    System.out.println(t);
    System.out.println(t.equals(t2));

    p = t; //--> Es válido, ya que una super clase puede apuntar a una subclase (Puesto que la subclase tiene las mismas propiedades)
    //t = p; //--> No es válido ya que Teacher es una subclase de Person y no puede apuntar a la clase padre puesto que no comparten lo mismo
    //t = s; //--> Igual que el segundo caso

  }
}