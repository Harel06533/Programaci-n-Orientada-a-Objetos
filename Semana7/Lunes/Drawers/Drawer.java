package Semana7.Lunes.Drawers;

public class Drawer<T> {
  // atributos
  private T object;

  // constructor
  public Drawer () {
    object = null;
  }

  // tostring
  @Override
  public String toString () {
    String output = "Is empty";

    if (object != null) {
      if (object instanceof Drawer) {
        Drawer<?> drawer = (Drawer<?>)object;
        output = "Drawer contains a Drawer of " + drawer.peek().toString();
      } else {
        output = "Object of " + object.toString();
      }
    }
    return output;
  }
  
  // añade un único objeto al Drawer
  public void insert (T object) {
    if (this.object == null) {
      this.object = object;
    }
  }
  
  // retorna el dato del Drawer sin sacarlo (observa)
  public T peek () {
    return (object);
  }

  // saca y retorna del dato del Drawer
  public T pull () {
    T toRemove = object;
    object = null;
    return (toRemove);
  }
}
