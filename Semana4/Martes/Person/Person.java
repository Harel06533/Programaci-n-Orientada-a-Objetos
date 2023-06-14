package Semana4.Martes.Person;

public class Person {
  // ID para obtener el género (De aquí sale el atributo genderValue)
  public static final int MALE = 0;
  public static final int FEMALE = 1;
  public static final int OTHER_GENDER = 2;

  // Dependiendo del ID, setea o el apellido paterno o el apellido materno
  public static final int SET_FATHER_NAME = 3;
  public static final int SET_MOTHER_NAME = 4;

  // Atributos String
  private String firstName, fLastName, mLastName, gender;

  // Edad
  private int age;

  // El valor del género (Es protected ya que no requiere un Getter, pero sí poder ser utilizado en las clases hijo)
  protected int genderValue;

  // Arreglo que guarda los géneros en un órden para ser mapeado en base a la posición (0 -> Male, 1 -> Female, 2 -> Other)
  private String[] genderArray = {"Male", "Female", "Other"};

  /**
   * Constructor base, setea de manera segura los valores de nombre, edad y género
   * @param firstName Primer Nombre
   * @param fLastName Apellido Paterno
   * @param mLastName Apellido Materno
   * @param age Edad
   * @param genderValue El valor numérico del género (Accedido desde la clase de manera estática)
   * y en base a la entrada, mapea un valor del arreglo de String {@code genderArray} y guarda
  */
  public Person (String firstName, String fLastName, String mLastName, int age, int genderValue) {
    setFirstName(firstName);
    setLastName(fLastName, SET_FATHER_NAME);
    setLastName(mLastName, SET_MOTHER_NAME);
    setGender(genderValue);
    setAge(age);
  }

  public String toString () {
    return (String.format("\n'Name': %s\n'Father Name': %s\n'Mother Name': %s\n'Age': %d\n'Gender': %s\n",
    firstName, fLastName, mLastName, age, gender 
    ));
  }

  public boolean equals (Object o) {
    if (o instanceof Person) {
      Person p = (Person) o;
      boolean equalName = firstName.equals(p.getFirstName());
      boolean equalFatherName = fLastName.equals(p.getFatherName());
      boolean equalMotherName = mLastName.equals(p.getMotherName());
      boolean equalGender = gender.equals(p.getGender());
      boolean equalAge = age == p.getAge();
      return (equalName && equalFatherName && equalMotherName && equalGender && equalAge);
    }
    return false;
  }

  public Person clone () {
    return new Person(firstName, fLastName, mLastName, age, genderValue);
  }

  /**
   * Setter que asigna el valor {@code String} al primer nombre
   * @param firstName Cadena del primero nombre
   */
  public void setFirstName (String firstName) {
    this.firstName = firstName;
  }

  /**
   * Setter que asigna el valor {@code String} al apellido (Puede ser materno o paterno)
   * @param lastName Cadena del apellido
   * @param ID Determina si el apellido es paterno o materno
   */
  public void setLastName (String lastName, int ID) {
    if (ID == SET_FATHER_NAME)
      fLastName = lastName;

    if (ID == SET_MOTHER_NAME)
      mLastName = lastName;
  }

  /**
   * Asigna el género en la posición del arreglo de {@code String} de géneros pasando como parámetro el {@code genderValue}
   * @param genderValue El ID que determina el género
   */
  public void setGender(int genderValue) {
    if (genderValue >= MALE && genderValue <= OTHER_GENDER) {
      this.genderValue = genderValue;
      gender = genderArray[this.genderValue]; 
    }
  }

  // Setea el año
  public void setAge (int age) {
    if (age >= 1 && age <= 115) {
      this.age = age;
    }
  }

  /* GETTERS */

  public String getFirstName () {
    return (firstName);
  }

  public String getFatherName () {
    return (fLastName);
  }

  public String getMotherName () {
    return (mLastName);
  }

  public String getGender () {
    return (gender);
  }

  public int getAge () {
    return (age);
  }
}