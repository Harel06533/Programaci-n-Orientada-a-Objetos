package Semana6.Martes;

public class USB {
  // constantes
  public static final int USB_2_0 = 0; 
  public static final int USB_3_0 = 1;
  public static final int USB_3_1 = 2;
  public static final int USB_3_2 = 3;

  public static final int DEFAULT_USB_TYPE = USB_2_0;

  private static final String[] usbTypes;

  static {
    usbTypes = new String[4];
    usbTypes[0] = "USB 2.0";
    usbTypes[1] = "USB 3.0";
    usbTypes[2] = "USB 3.1";
    usbTypes[3] = "USB 3.2";
  }

  // atributos
  private String typeString;

  public USB (int type) {
    setType(type);
  }

  @Override
  public String toString () {
    return ("'USB type': " + typeString + '\n');
  }

  public void setType (int type) {
    typeString = (type >= USB_2_0 && type <= USB_3_2) ? (usbTypes[type]) : (usbTypes[USB_2_0]);
  }

  public String getType () {
    return (typeString);
  }
}
