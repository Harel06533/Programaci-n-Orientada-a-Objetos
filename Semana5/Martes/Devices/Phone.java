package Semana5.Martes.Devices;

import Semana5.Martes.Devices.Components.Battery;
import Semana5.Martes.Devices.Components.Wireless;

public class Phone extends ElectronicDevice implements Battery, Wireless {
  // constantes
  public static final int LTE = 0;
  public static final int FIVE_G = 1;
  public static final int WIFI = 2;

  public static final int DEFAULT_FABRICANT = SAMSUNG;
  public static final int MIN_SIZE = 45;
  public static final int MAX_SIZE = 600;

  public static final int APPLE_CAPACITY = 1000;
  public static final int SAMSUNG_CAPACITY = 689;


  // guarda las opciones de red
  protected static final String[] networkOptions = {"LTE", "5G", "WIFI"};

  // atributos
  protected String networkType;
  protected int currentBattery;
  protected int capacity;

  private int appCounter = 0;

  // inicializa un teléfono
  public Phone (int fabricantID, int screenSize) {
    setFabricant(fabricantID);
    setOS();
    setScreenSize(screenSize);
    setNetworkType(LTE);
    currentBattery = INITIAL_BATTERY;
  } 

  // toString()
  @Override
  public String toString () {
    if (!isTurnedOn) return ("No está encendido");
    String networkState = (!isNetworkConnected) ? ("No está conectado a la red") : (networkType); 
    return (super.toString() + String.format("'charge': %d percent\n'network': %s\n'apps': %d\n", 
    currentBattery, networkState, appCounter));
  }

  // setea el fabricante (Apple o Samsung), si no es válido el ID, por default setea Samsung
  @Override
  public void setFabricant (int fabricantID) {
    fabricant = deviceInfoMap.get(DEFAULT_FABRICANT);
    if (fabricantID == APPLE || fabricantID == SAMSUNG)
      fabricant = deviceInfoMap.get(fabricantID);
  }

  // setea el sistema operativo, puede ser iOS o Android
  @Override
  protected void setOS () {
    os = (fabricant.equals("Apple")) ? (deviceInfoMap.get(IOS)) : (deviceInfoMap.get(ANDROID));
  }

  // setea el tamaño de la pantalla y lo valida
  @Override
  public void setScreenSize (int screenSize) {
    this.screenSize = validScreenSize(screenSize, MIN_SIZE, MAX_SIZE);
  }

  // setea la interfáz de red y guarda el valor (No sobreescribe el método heredado, solo es )
  @Override
  public void setNetworkType (int networkType) {
    this.networkType = (networkType >= LTE && networkType <= WIFI) ? (networkOptions[networkType]) : (networkOptions[WIFI]);
  }

  // override del método padre

  // carga un tiempo la batería
  @Override
  public void connectCharge (int minutes) {
    currentBattery += minutes;
    if (currentBattery > MAX_BATTERY)
      currentBattery = MAX_BATTERY;
  } 

  // obtiene la batería máxima
  @Override
  public int getCapacity () { return capacity; }

  // obtiene el porcentaje de batería
  @Override
  public int getPercentage () { return currentBattery; }

  // obtiene si está conectado a la red
  @Override
  public boolean isConnected () { return isNetworkConnected; }

  // instala una aplicación
  public void installApp () { appCounter++; }

  // desinstala una aplicación
  public void uninstallApp () { appCounter--; }
}
