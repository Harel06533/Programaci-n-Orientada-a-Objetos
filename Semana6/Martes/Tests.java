package Semana6.Martes;

public class Tests {
  public static void main(String[] args) {

    CPU cpu = new CPU(CPU.AMD, CPU.AMD_RYZEN_7, 16, 4.5);
    int memType = Memory.DDR5;
    Memory memory = new Memory(memType, 32);
    Storage storage = new Storage(Storage.SSD, 520);
    USB[] usbPorts = new USB[6];
    for (int i = 0; i < usbPorts.length; i++) {
      usbPorts[i] = new USB((int)(Math.random() * USB.USB_3_2) + USB.USB_2_0);
    }
    Motherboard mb2 = new Motherboard(Motherboard.BIOSTAR, "B-48", 1, cpu, memory, storage, usbPorts);
    System.out.println(mb2);
  }
}
