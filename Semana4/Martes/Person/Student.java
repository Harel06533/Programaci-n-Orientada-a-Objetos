package Semana4.Martes.Person;

public class Student extends Person {

  // ID de cada área de estudio (Para poder ser mapeado rápidamente en un arreglo)
  public static final int SYSTEMS = 0;
  public static final int SOFTWARE = 1;
  public static final int CYBERSECURITY = 3;

  // Atributos de la clase
  private String studyPlan;
  private int studyPlanValue;
  private int credits;
  private int semesters;

  // Arreglo de cadenas que guarda el área de estudio
  private String[] plans = {
    "Systems Engeneering",
    "Software Engeneering",
    "Cybersecurity Engeneering"
  };

  /**
   * Constructor base, hereda el constructor {@code super} de la clase padre {@code Person}, y además añade los parámetros de
   * {@code studyPlanValue}, {@code credits} y {@code semester}.
   * @param firstName Primer nombre
   * @param fLastName Apellido Paterno
   * @param mLastName Apellido Materno
   * @param age Edad
   * @param genderValue ID de género, documentación en {@link #getGender()} 
   * @param studyPlanValue ID del plan de estudio para su mapeo
   * @param credits Número de creditos completados
   * @param semesters Número de semestres cursados
   */
  public Student (String firstName, String fLastName, String mLastName, 
  int age, int genderValue, int studyPlanValue, 
  int credits, int semesters) {
    super(firstName, fLastName, mLastName, age, genderValue);
    setStudyPlan(studyPlanValue);
    setCredits(credits);
    setSemesters(semesters);
  }

  @Override
  public String toString () {
    return (super.toString() + 
    String.format("'Study Plan': %s\n'Credits': %d\n'Semesters': %d\n", studyPlan, credits, semesters) 
    );
  }

  @Override
  public boolean equals (Object o) {
    if (o instanceof Student) {
      Student s = (Student) o; 
      boolean equalPerson = super.equals(s);
      boolean equalPlan = studyPlan.equals(s.getStudyPlan());
      boolean equalCredit = credits == s.getCredits();
      boolean equalSemesters = semesters == s.getSemesters();
      return (equalPerson && equalPlan && equalCredit && equalSemesters);
    }
    return false;
  }

  @Override
  public Student clone () {
    return new Student(super.getFirstName(), super.getFatherName(), super.getMotherName(),
    super.getAge(), super.genderValue, studyPlanValue, credits, semesters 
    );
  }

  // SETTERS

  public void setStudyPlan (int studyPlanValue) {
    if (studyPlanValue >= SYSTEMS && studyPlanValue <= CYBERSECURITY) {
      this.studyPlanValue = studyPlanValue;
      studyPlan = plans[studyPlanValue];
    }
  }

  public void setCredits (int credits) {
    if (credits >= 0) 
      this.credits = credits;
  }

  public void setSemesters (int semesters) {
    if (semesters >= 1 && semesters <= 12)
      this.semesters = semesters;
  }

  // GETTERS
  public String getStudyPlan () {
    return (studyPlan);
  }

  public int getCredits () {
    return (credits);
  }

  public int getSemesters () {
    return (semesters);
  }

}