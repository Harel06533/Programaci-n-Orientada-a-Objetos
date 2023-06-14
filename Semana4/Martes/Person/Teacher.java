package Semana4.Martes.Person;

public class Teacher extends Person {
  
  // ID del grado de estudio
  public static final int BACHELOR = 0;
  public static final int MASTER = 1;
  public static final int DOCTOR = 2;

  // ID del departamento
  public static final int DESI = 3;
  public static final int MAF = 4;

  // Arreglo degreeArray para mapear grados y dpArray para mapear departamentos
  private String[] degreeArray = {"Bachelor", "Master", "Doctor"};
  private String[] dpArray = {"DESI", "MAF"};

  // Atributos de la clase
  private int degreeValue;
  private int dpValue;
  private int hours;
  private String degree;
  private String department;

  /**
   * Constructor base, hereda el constructor {@code super} de la clase padre {@code Person}, y además añade los parámetros de
   * {@code hours}, {@code degreeValue} y {@code department}.
   * @param firstName Nombre
   * @param fLastName Apellido paterno
   * @param mLastName Apellido materno
   * @param age Edad
   * @param genderValue ID del género 
   * @param hours Horas de jornada laboral
   * @param degreeValue ID del grado de estudio para mapear
   * @param department ID del departamento para mapear
   */
  public Teacher (String firstName, String fLastName, 
  String mLastName, int age, int genderValue, 
  int hours, int degreeValue, int department) {
    super(firstName, fLastName, mLastName, age, genderValue);
    setHours(hours);
    setDepartment(department);
    setDegree(degreeValue);
  }

  public String toString () {
    return (super.toString() + String.format("'Degree': %s\n'Department': %s\n'Hours': %d\n", degree, department, hours));
  }

  @Override
  public boolean equals (Object o) {
    if (o instanceof Teacher) {
      Teacher t = (Teacher) o; 
      boolean equalPerson = super.equals(t);
      boolean equalDegree = degree.equals(t.getDegree());
      boolean equalDepartment = department.equals(t.getDepartment());
      boolean equalHour = hours == t.getHours();
      return (equalPerson && equalDegree && equalDepartment && equalHour);
    }
    return false;
  }

  @Override
  public Teacher clone () {
    return (new Teacher(super.getFirstName(), super.getFatherName(), super.getMotherName(),
    super.getAge(), super.genderValue, hours, degreeValue, dpValue
    ));
  }

  // Setters

  public void setHours (int hours) {
    if (hours >= 2 && hours <= 12) 
      this.hours = hours;
  }

  public void setDegree (int degreeValue) {
    if (degreeValue >= BACHELOR && degreeValue <= DOCTOR) {
      this.degreeValue = degreeValue;
      degree = degreeArray[this.degreeValue];
    }
  }

  public void setDepartment (int dp) {
    if (dp >= DESI && dp <= MAF) {
      dpValue = dp - 3;
      department = dpArray[dpValue];
    }
  }

  // Getters

  public int getHours () {
    return (hours);
  }

  public String getDegree () {
    return (degreeArray[degreeValue]);
  }

  public String getDepartment () {
    return (dpArray[dpValue]);
  }
}