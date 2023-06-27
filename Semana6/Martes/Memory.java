package Semana6.Martes;

public class Memory {
  // constantes
  public static final int DDR3 = 0;
  public static final int DDR4 = 1;
  public static final int DDR5 = 2;
  public static final int MIN_RAM = 8;
  public static final int MAX_RAM = 64;

  public static final int DEFAULT_DDR = DDR3;
  public static final int DEFAULT_RAM = MIN_RAM;

  private static final String[] ramTypes;

  static {
    ramTypes = new String[3];
    ramTypes[0] = "DDR3";
    ramTypes[1] = "DDR4";
    ramTypes[2] = "DDR5";
  }
  
  // atributos
  public String ramTypeString;
  public int memory;


  public Memory (int ramType, int memory) {
    setRamType(ramType);
    setMemory(memory);
  }

  @Override
  public String toString () {
    return (
      "'MemoryType': " + ramTypeString + '\n' +
      "'Memory': " + memory + "GB \n"
    );
  }

  public void setRamType (int ramType) {
    ramTypeString = (ramType >= DDR3 && ramType <= DDR5) ? (ramTypes[ramType]) : (ramTypes[DDR3]);
  }

  public void setMemory (int memory) {
    this.memory = (memory >= MIN_RAM && memory <= MAX_RAM) ? (memory) : (MIN_RAM);
  }

  public String getMemoryType () { return ramTypeString; }
}
