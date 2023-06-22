package Semana5.Martes.Devices;

import Semana5.Martes.Devices.Components.Battery;
import Semana5.Martes.Devices.Components.Ethernet;
import Semana5.Martes.Devices.Components.Wireless;

public class Laptop extends ElectronicDevice implements Battery, Ethernet, Wireless {
  // constantes

  public static final int ETHERNET = 0;
  public static final int WIFI = 1;

  public static final int MIN_SIZE = 1000;
  public static final int MAX_SIZE = 3600;

  public static final int DEFAULT_FABRICANT = DELL;
  public static final int DEFAULT_SPEED = FAST_ETHERNET;


  private static final String networkOptions[] = {"Ethernet", "Wifi"};

  // atributos
  private String networkType;
  private int networkSpeed;
  private int currentBattery;
  private int capacity;
  private int appCounter = 0;

  // constructor base
  public Laptop (int fabricantID, int screenSize) {
    setFabricant(fabricantID);
    setOS();
    setScreenSize(screenSize);
    setNetworkType(ETHERNET);
    currentBattery = INITIAL_BATTERY;
  }

  // tostring
  @Override
  public String toString() {
    if (!isTurnedOn) return ("El dispositivo no está encendido");
    String networkState = (!isNetworkConnected) ? ("La red no está conectada") : (getNetworkInfo());
    return (super.toString() + String.format("'charge': %d percent\n'network': %s\n'apps': %d\n", 
    currentBattery, networkState, appCounter));
  }

  // obtiene información de la conexión ethernet
  private String getNetworkInfo () {
    if (!isNetworkConnected) return "El dispositivo no está conectado";
    if (networkType.equals(networkOptions[WIFI])) return "Wifi";
    return ("Ethernet - 'speed': " + networkSpeed + "mbps");
  }

  // setea el fabricante
  @Override
  protected void setFabricant (int fabricantID) {
    fabricant = deviceInfoMap.get(DEFAULT_FABRICANT);
    if (fabricantID == DELL || fabricantID == HP)
      fabricant = deviceInfoMap.get(fabricantID);
  }

  // implemente el Sistema operativo, no debe llamarse más que una vez para setear por default Windows
  @Override
  protected void setOS () {
    setOS(WINDOWS);
  }

  // sobrecarga, el método es público y permite setear Windows o Linux
  public void setOS (int osID) { 
    os = (osID == WINDOWS || osID == LINUX) ? (deviceInfoMap.get(osID)) : (deviceInfoMap.get(WINDOWS));
  }

  // setea el tamaño de la pantalla
  @Override
  protected void setScreenSize (int screenSize) {
    this.screenSize = super.validScreenSize(screenSize, MIN_SIZE, MAX_SIZE);
  }

  // setea el tipo de red al que está conectado (Puede ser WIFI o ETHERNET)
  @Override
  public void setNetworkType (int networkType) {
    this.networkType = (networkType == ETHERNET || networkType == WIFI) ? (networkOptions[networkType]) : (networkOptions[ETHERNET]);
    if (this.networkType.equals("Ethernet"))
      changeEthernetSpeed(DEFAULT_SPEED);
  }

  // setea una nueva velocidad de la red
  public void changeEthernetSpeed (int speed) {
    if (!networkType.equals("Ethernet")) return;
    networkSpeed = (speed == FAST_ETHERNET || speed == GIGABIT_ETHERNET) ? (speed) : (DEFAULT_SPEED);
  }

  // obtiene la velocidad del internet
  @Override
  public int getSpeed () { return networkSpeed; }

  @Override
  public boolean isConnected () { return isNetworkConnected; }

  @Override
  public int getCapacity() { return capacity; }

  @Override
  public int getPercentage() { return currentBattery; }

  @Override
  public void connectCharge(int minutes) {
    currentBattery += (minutes * 2);
    if (currentBattery > MAX_BATTERY)
      currentBattery = MAX_BATTERY;
  }
  // instala una aplicación
  public void installApp () { appCounter++; }

  // desinstala una aplicación
  public void uninstallApp () { appCounter--; }
}
