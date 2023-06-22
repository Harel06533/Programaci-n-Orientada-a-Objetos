package Semana5.Martes.Devices;

/** Clase Tablet extiende a Phone, realmente comparte muchas similitudes */
public class Tablet extends Phone {
  // Constantes 
  public static final int MIN_SIZE = 600;
  public static final int MAX_SIZE = 1200;

  // constructor base, inicializa como un teléfono
  public Tablet (int fabricantID, int screenSize) {
    super(fabricantID, screenSize);
  }

  // setea la red (En este caso, independientemente de la red elejida, siempre será WIFI (Puede mejorarse))
  @Override
  public void setNetworkType (int networkType) {
    this.networkType = networkOptions[WIFI];
  }

  // setea el tamaño de la pantalla (Utiliza el método que retorna un tamaño válido en base a parámetros y lo agrega)
  @Override
  public void setScreenSize (int screenSize) {
    int size = super.validScreenSize(screenSize, MIN_SIZE, MAX_SIZE);
    this.screenSize = size;
  }
}
