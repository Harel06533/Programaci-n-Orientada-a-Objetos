package Semana6.Martes;

import java.util.HashMap;


public class CPU {
  // constantes
  public static final int INTEL = 0;
  public static final int AMD = 1;

  public static final int INTEL_I3 = 2;
  public static final int INTEL_I5 = 3;
  public static final int INTEL_I7 = 4;
  public static final int INTEL_I9 = 5;

  public static final int AMD_RYZEN_3 = 6;
  public static final int AMD_RYZEN_5 = 7;
  public static final int AMD_RYZEN_7 = 8;
  public static final int AMD_RYZEN_9 = 9;

  
  public static final int MIN_CORES = 4;
  public static final int MAX_CORES = 24;
  
  public static final double MIN_SPEED = 2.0;
  public static final double MAX_SPEED = 5.0;
  
  public static final int DEFAULT_BRAND = INTEL;
  public static final int DEFAULT_VERSION = INTEL_I3;

  private static final HashMap<Integer, String> coreInfoMap;

  static {
    coreInfoMap = new HashMap<>();
    coreInfoMap.put(INTEL_I3, "Intel i3");
    coreInfoMap.put(INTEL_I5, "Intel i5");
    coreInfoMap.put(INTEL_I7, "Intel i7");
    coreInfoMap.put(INTEL_I9, "Intel i9");
    
    coreInfoMap.put(AMD_RYZEN_3, "AMD Ryzen 3");
    coreInfoMap.put(AMD_RYZEN_5, "AMD Ryzen 5");
    coreInfoMap.put(AMD_RYZEN_7, "AMD Ryzen 7");
    coreInfoMap.put(AMD_RYZEN_9, "AMD Ryzen 9");
  }

  // atributos
  private int brand;
  private int cores;
  private double speed;
  private String model;

  public CPU (int brand, int version, int cores, double speed) {
    setModel(brand, version);
    setCores (cores);
    setSpeed(speed);
  }

  @Override
  public String toString () {
    return (
      "'model': " + model + '\n' +
      "'cores': " + cores + '\n' +
      "'speed': " + speed + '\n'
    );
  }
  
  public void setModel (int brand, int version) {
    this.brand = (brand == INTEL || brand == AMD) ? (brand) : (INTEL);
    int minVersion = (this.brand == INTEL) ? (INTEL_I3) : (AMD_RYZEN_3);
    int maxVersion = (this.brand == INTEL) ? (INTEL_I9) : (AMD_RYZEN_9);

    if (version >= minVersion && version <= maxVersion) 
      model = coreInfoMap.get(version);
    else 
      model = coreInfoMap.get(minVersion);
    
  }

  public void setCores (int cores) {
    this.cores = (cores >= MIN_CORES && cores <= MAX_CORES) ? (cores) : (MIN_CORES);
  }

  public void setSpeed (double speed) {
    this.speed = (speed >= MIN_SPEED && speed <= MAX_SPEED) ? (speed) : (MIN_SPEED);
  }
}
