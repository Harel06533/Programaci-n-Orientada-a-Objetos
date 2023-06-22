package Semana5.Martes.Devices;

import Semana5.Martes.Devices.Components.Wireless;
import Semana5.Martes.Devices.Components.Ethernet;

public class Television extends ElectronicDevice implements Wireless, Ethernet {
  // constantes
  public static final int ETHERNET = 0;
  public static final int WIFI = 1;

  public static final int MIN_SIZE = 2000;
  public static final int MAX_SIZE = 4000;

  public static final int DEFAULT_FABRICANT = SONY;
  public static final int DEFAULT_OS = ROKU;

  public static final int DEFAULT_SPEED = GIGABIT_ETHERNET;

  //atributos
  private int networkSpeed;
  private int appCounter = 0;
  private String networkType;

  private String networkOptions[] = {"Ethernet", "Wifi"};

  // constructor base
  public Television (int fabricantID, int screenSize) {
    setFabricant(fabricantID);
    setScreenSize(screenSize);
    setOS();
    setNetworkType(WIFI);
  }

  // tostring
  @Override
  public String toString() {
    if (!isTurnedOn) return ("El dispositivo no está encendido");
    String networkState = getNetworkInfo();
    return (super.toString() + String.format("'network': %s\n'apps': %d\n", networkState, appCounter));
  }

  // retorna la información de la red
  public String getNetworkInfo () {
    if (!isNetworkConnected) return "El dispositivo no está conectado";
    if (networkType.equals("Wifi")) return "Wifi";
    return ("Ethernet - 'speed': " + networkSpeed + "mbps");
  }
  
  // setea el fabricante 
  @Override
  protected void setFabricant (int fabricantID) {
    fabricant = deviceInfoMap.get(DEFAULT_FABRICANT);
    if (fabricantID >= HISENSE && fabricantID <= SONY)
      fabricant = deviceInfoMap.get(fabricantID);
  }
  
  // setea el sistema operativo (puede ser cualquiera ;default Roku)
  @Override
  protected void setOS () {
    setOS(DEFAULT_OS);
  }

  // sobrecarga, permite instalar un nuevo sistema operativo
  public void setOS (int osID) {
    os = (osID >= ANDROID_TV && osID <= WEB_OS) ? (deviceInfoMap.get(osID)) : (deviceInfoMap.get(DEFAULT_OS));
  }
  
  // setea el tamaño de la pantalla 
  @Override
  public void setScreenSize (int screenSize) {
    this.screenSize = super.validScreenSize(screenSize, MIN_SIZE, MAX_SIZE);
  }
  
  // setea el tipo de internet (Ethernet o Wifi)
  @Override
  public void setNetworkType (int networkType) {
    this.networkType = (networkType == ETHERNET || networkType == WIFI) ? (networkOptions[networkType]) : (networkOptions[ETHERNET]);
    if (this.networkType.equals("Ethernet"))
      changeEthernetSpeed (DEFAULT_SPEED);
  }

  // permite cambiar la velocidad default de Ethernet en caso de estar instalado
  public void changeEthernetSpeed (int speed) {
    if (!networkType.equals("Ethernet")) return;
    networkSpeed = (speed == GIGABIT_ETHERNET || speed == FAST_ETHERNET) ? (speed) : (DEFAULT_SPEED);
  }

  // retorna si el dispositivo está conectado a la red
  @Override
  public boolean isConnected () { return isNetworkConnected; }

  // retorna la velocadad de Ethernet
  @Override
  public int getSpeed () { return networkSpeed; }

  // instala una aplicación
  public void installApp () { appCounter++; }

  // desinstala una aplicación
  public void uninstallApp () { appCounter--; }
} 
