package Semana5.Martes.Devices.Components;

public interface Ethernet { 
  public static final int FAST_ETHERNET = 100;
  public static final int GIGABIT_ETHERNET = 1000;

  // retorna la velocidad de ethernet
  public int getSpeed (); 

  // retorna si está o no conectado
  public boolean isConnected ();
}
