package Semana6.Lunes;

public class TestAn {

  public static HelloWorld spanishGreeting = new HelloWorld() {
    private String greet = "Hola";
    @Override
    public void greet () {
      System.out.println(greet);
    }

    @Override
    public void greetSomeone (String someone) {
      System.out.println(greet + " " + someone);
    }
  };

  public static HelloWorld englishGreeting = new HelloWorld() {
    String greet = "Hello";
    @Override
    public void greet () {
      System.out.println(greet);
    }

    @Override
    public void greetSomeone (String someone) {
      System.out.println(greet + " " + someone);
    }
  };

  public static HelloWorld frenchGreeting = new HelloWorld() {
    String greet = "bonjour"; 

    @Override
    public void greet () {
      System.out.println(greet);
    }

    @Override
    public void greetSomeone (String someone) {
      System.out.println(greet + " " + someone);
    };
  };

  public static Person professor = new Person (33, Person.MALE) {
    public void work () {
      System.out.println("Professor is teaching");
    }
  };

  public static Person student = new Person (18, Person.FEMALE) {
    public void work () {
      System.out.println("Student is learning at class");
    }
  };

  public static void main(String[] args) {
    frenchGreeting.greet();
    spanishGreeting.greet();
    englishGreeting.greet();

    frenchGreeting.greetSomeone("Jean");
    spanishGreeting.greetSomeone("Juan");
    englishGreeting.greetSomeone("John");

    System.out.println();

    professor.work();
    student.work();
  }
}
