package Semana6.Martes;

import java.util.HashMap;

public class Motherboard {
  //constantes
  public static final int ASUS = 0;
  public static final int ASROCK = 1;
  public static final int BIOSTAR = 2;
  public static final int EVGA = 3;
  public static final int GIGABYTE = 4;
  public static final int MSI = 5;
  public static final int INTEL = 6;
  
  private static final HashMap<Integer, String> modelBrandMap;

  static {
    modelBrandMap = new HashMap<>();
    modelBrandMap.put(ASUS, "Asus");
    modelBrandMap.put(ASROCK, "ASRock");
    modelBrandMap.put(BIOSTAR, "Biostar");
    modelBrandMap.put(EVGA, "EVGA");
    modelBrandMap.put(GIGABYTE, "Gigabyte");
    modelBrandMap.put(INTEL, "Intel");
  }

  //atributos
  private String brandString;
  private String modelString;
  private String memoryType;
  private int socket;

  private CPU processor;
  private Storage storage;
  private Memory memory;
  private USB[] usbPorts = new USB[6]; 

  public Motherboard () {
    String modelString = "ROG A-9";
    int brand = ASUS;
    int socket = 1;
    CPU processor = new CPU(CPU.DEFAULT_BRAND, CPU.DEFAULT_VERSION, CPU.MIN_CORES, CPU.MIN_SPEED);
    Memory memory = new Memory(Memory.DEFAULT_DDR, Memory.DEFAULT_RAM);
    Storage storage = new Storage(Storage.DEFAULT_DISK, Storage.DEFAULT_CAPACITY);
    USB[] usbPorts = new USB[6];
    for (int i = 0; i < usbPorts.length; i++) {
      usbPorts[i] = new USB(USB.DEFAULT_USB_TYPE);
    }
    setComponents(brand, modelString, socket, processor, memory, storage, usbPorts);
  }

  public Motherboard (int brand, String model, int socket, CPU processor, Memory memory, Storage storage, USB[] usbPorts) {
    setComponents(brand, model, socket, processor, memory, storage, usbPorts);
  }

  public String toString () {
    String usbInfo = "[" + usbPorts[0].getType();
    for (int i = 1; i < usbPorts.length; i++) {
      usbInfo += ", " + usbPorts[i].getType();
    }
    usbInfo += "]";
    return (
      "MODEL:\n" + brandString + " " + modelString + '\n' +
      "\nCPU SOCKET:\n" + processor.toString() + '\n' +
      "\nMEMORY:\n" + memory.toString() + '\n' +
      "\nSTORAGE:\n" + storage.toString() + '\n' +
      "\nUSB_INFO:\n" + usbInfo
    );
  }

  public void setComponents (int brand, String model, int socket, CPU processor, Memory memory, Storage storage, USB[] usbPorts) {
    brandString = modelBrandMap.get(brand);
    modelString = model;
    this.socket = socket;
    this.processor = processor;
    this.memory = memory;
    this.memoryType = memory.getMemoryType();
    this.storage = storage;
    this.usbPorts = usbPorts;
  }
}
