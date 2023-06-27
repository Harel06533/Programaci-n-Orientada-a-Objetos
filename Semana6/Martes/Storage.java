package Semana6.Martes;

public class Storage {
  // constantes
  public static final int HDD = 0;
  public static final int SSD = 1;
  public static final int MIN_CAPACITY = 480;
  public static final int MAX_CAPACITY = 10000;

  public static final int DEFAULT_DISK = HDD;
  public static final int DEFAULT_CAPACITY = MIN_CAPACITY;

  private static final String diskTypes[];


  static {
    diskTypes = new String[2];
    diskTypes[0] = "HDD";
    diskTypes[1] = "SSD";
  }
  // atributos
  private String diskTypeString;
  private int capacity;

  public Storage (int diskType, int capacity) {
    setDiskType(diskType);
    setCapacity(capacity);
  }

  @Override
  public String toString () {
    return (
      "'DiskType': " + diskTypeString + '\n' +
      "'Capacitiy': " + capacity + "GB" + '\n'
    );
  }

  public void setDiskType (int diskType) {
    this.diskTypeString = (diskType == HDD || diskType == SSD) ? (diskTypes[diskType]) : (diskTypes[HDD]);
  }

  public void setCapacity (int capacity) {
    this.capacity = (capacity >= MIN_CAPACITY && capacity <= MAX_CAPACITY) ? (capacity) : (MIN_CAPACITY);
  }
}
