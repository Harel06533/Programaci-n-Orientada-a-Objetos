package Semana5.Martes.Devices.Components;

public interface Battery {
  // batería con la que comienzan todos los dispositivos
  public static final int INITIAL_BATTERY = 50;
  public static final int MAX_BATTERY = 100;

  // setea la capacidad
  public abstract int getCapacity ();

  // obtiene el porcentaje de carga
  public abstract int getPercentage ();

  // conecta y carga
  public abstract void connectCharge (int minutes);
}

