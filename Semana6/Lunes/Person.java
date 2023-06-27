package Semana6.Lunes;

public abstract class Person {
  public static final int MALE = 0;
  public static final int FEMALE = 1;

  private int age; 
  private int gender;
  private String genderString;
  private String[] genders = {"Male", "Female"};

  public Person (int gender, int age) {
    setAge(age);
    setGender(gender);
  }

  public void setAge (int age) {
    this.age = (age >= 0) ? (age) : (1);
  }

  public void setGender (int gender) {
    this.gender = (gender == MALE || gender == FEMALE) ? (gender) : (MALE);
    genderString = genders[this.gender];
  }

  public abstract void work ();
}
