package Semana5.Martes.Devices;

import java.util.HashMap;

/** Método abstracto para dispositivos electrónicos */
public abstract class ElectronicDevice {
  // constantes para fabricante
  public static final int APPLE = 0;
  public static final int SAMSUNG = 1;
  public static final int HP = 2;
  public static final int DELL = 3;
  public static final int HISENSE = 4;
  public static final int SONY = 5;

  // constantes para el sistema operativo
  public static final int WINDOWS = 6;
  public static final int LINUX = 8;

  public static final int IOS = 9;
  public static final int ANDROID = 10;

  public static final int ANDROID_TV = 11;
  public static final int ROKU = 12;
  public static final int TIZEN = 13;
  public static final int WEB_OS = 14;

  // Constantes para crear un dispositivo
  public static final int PHONE = 15;
  public static final int TABLET = 16;
  public static final int LAPTOP = 17;
  public static final int TV = 18;

  // atributos
  protected String fabricant;                                     //--> Guarda en Texto el fabricante
  protected String os;                                            //--> Guarda en Texto el sistema operativo
  protected int screenSize;                                       //--> Guarda en entero (pixeles) el tamaño de la pantalla
  protected boolean isTurnedOn;                                   //--> Guarda (true, false) si el dispositivo está prendido
  protected boolean isNetworkConnected;                           //--> Guarda (true, false) si el dispositivo está prendido a la red
  protected static HashMap<Integer, String> deviceInfoMap;        //--> Mapa (key, value) que guarda el texto de cada fabricante

  // inicializa el deviceInfoMap globalmente para todas las instancias
  static {
    deviceInfoMap = new HashMap<>();

    // inicializa fabricantes
    deviceInfoMap.put(APPLE, "Apple");
    deviceInfoMap.put(SAMSUNG, "Samsung");
    deviceInfoMap.put(HP, "Hp");
    deviceInfoMap.put(DELL, "Dell");
    deviceInfoMap.put(HISENSE, "Hisense");
    deviceInfoMap.put(SONY, "Sony");

    // inicializa sistemas operativos
    deviceInfoMap.put(WINDOWS, "Windows");
    deviceInfoMap.put(LINUX, "Linux");
    deviceInfoMap.put(IOS, "iOS");
    deviceInfoMap.put(ANDROID, "Android");
    deviceInfoMap.put(ANDROID_TV, "Android TV");
    deviceInfoMap.put(ROKU, "Roku");
    deviceInfoMap.put(TIZEN, "Tizen");
    deviceInfoMap.put(WEB_OS, "WebOS");
  }

  // constructor base, es privado para utilizar el diseño factory (únicamente inicializa valores globales)
  protected ElectronicDevice () {
    isTurnedOn = false;
    isNetworkConnected = false;
  }

  // método factory que crea diferentes dispositivos
  public static ElectronicDevice createDevice (int deviceID, int fabricantID, int screenSize) {
    switch(deviceID) {
      case PHONE: return new Phone(fabricantID, screenSize);
      case TABLET: return new Tablet(fabricantID, screenSize);
      case LAPTOP: return new Laptop(fabricantID, screenSize);
      case TV: return new Television(fabricantID, screenSize);
      default: return null;
    }
  }

  // método toString
  @Override
  public String toString() {
    return (String.format("'fabricant': %s\n'system': %s\n'screen': %dpx\n", fabricant, os, screenSize));
  }

  // Enciende o apaga el dispositivo (es público para acceder mediante factory)
  public void toogleDevice () {
    if (!isTurnedOn) isTurnedOn = true;
    else isTurnedOn = false;
  }

  // Enciende o apaga la conexión a una red
  public void toogleNetwork () {
    if (!isNetworkConnected) isNetworkConnected = true;
    else isNetworkConnected = false;
  }
  
  // método estático protegido para validar el tamaño de la pantalla
  protected static int validScreenSize (int screenSize, int minSize, int maxSize) {
    return ((screenSize >= minSize && screenSize <= maxSize) ? (screenSize) : (minSize));
  }

  // getters
  public String getFabricant () { return fabricant; }
  public String getOS () { return os; }
  public int getScreenSize () { return screenSize; }
  public String getDeviceState () { return (isTurnedOn) ? ("Encendido") : ("Apagado"); }
  public String getNetworkState () { return (isNetworkConnected) ? ("Conectado") : ("Desconectado"); }

  // métodos abstractos
  protected abstract void setFabricant (int fabricantID);
  protected abstract void setOS ();
  protected abstract void setScreenSize (int screenSize);
  protected abstract void setNetworkType (int networkType);
  protected abstract void installApp ();
  protected abstract void uninstallApp();
}
