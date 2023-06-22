package Semana5.Martes;

import Semana5.Martes.Devices.*;

public class TestED {
  // constantes para el teléfono
  public static void main(String[] args) {
    // factory
    ElectronicDevice fPhone = ElectronicDevice.createDevice(ElectronicDevice.PHONE, ElectronicDevice.SAMSUNG, 350);
    ElectronicDevice fTablet = ElectronicDevice.createDevice(ElectronicDevice.TABLET, ElectronicDevice.APPLE, 800);
    ElectronicDevice fLaptop = ElectronicDevice.createDevice(ElectronicDevice.LAPTOP, ElectronicDevice.HP, 1080);
    ElectronicDevice fTelevision = ElectronicDevice.createDevice(ElectronicDevice.TV, ElectronicDevice.SONY, 3070);

    
    /* Probar el teléfono */
    Phone phone = (Phone)fPhone;
    phone.toogleDevice();
    phone.toogleNetwork();
    phone.installApp();
    phone.setNetworkType(Phone.FIVE_G);
    phone.connectCharge(5);
    
    /* Probar la tablet */
    Tablet tablet = (Tablet)fTablet;
    tablet.toogleDevice();
    tablet.toogleNetwork();
    for (int i = 0; i < 4; i++) {
      tablet.installApp();
    }
    tablet.uninstallApp();
    tablet.connectCharge(10);

    /* Probar la laptop */
    Laptop laptop = (Laptop)fLaptop;
    laptop.toogleDevice();
    laptop.toogleNetwork();
    for (int i = 0; i < 10; i++) {
      laptop.installApp();
    }
    laptop.setNetworkType(Laptop.ETHERNET);
    laptop.connectCharge(12);
    laptop.setOS(Laptop.LINUX);

    /* Probar la televisión */
    Television tv = (Television)fTelevision;
    tv.toogleDevice();
    tv.toogleNetwork();
    tv.installApp();
    tv.setNetworkType(Television.ETHERNET);;

    /* Factory */
    ElectronicDevice[] devices = {phone, tablet, laptop, tv};
    for (int i = 0; i < devices.length; i++) {
      System.out.println(devices[i]);
    }
  }
}
