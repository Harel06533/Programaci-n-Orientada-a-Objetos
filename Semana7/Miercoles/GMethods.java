package Semana7.Miercoles;

import java.util.ArrayList;
import java.util.Stack;

import Semana4.Miercoles.Time.Date;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.ArrayDeque;

import java.util.Collection;

public class GMethods {
  // Imprime cualquier colección de cualquier tipo
  public static <T> void printCollection (Collection<T>collection) {
    for (T object : collection) {
      System.out.println(object);
    }
    System.out.println();
  }

  // retorna la frecuencia de un dato T en una lista de datos T
  public static <T> int frequency (Collection<T> tList, T object) {
    int fq = 0;
      for (T current : tList) {
        if (current.equals(object))
          fq++;
      }
    return fq;
  }

  // copia una colección y la pone en otra
  public static <T> void copyCollection (Collection<T> source, Collection<? super T> dest) {
    for (T elem : source) {
      dest.add(elem);
    }
  }

  // obtiene el número mayor
  public static double greatestNumber (Collection<? extends Number>collection) {
    Number greatest = null;
    if (collection == null) return 0;
    for (Number n : collection) {
      if (greatest == null || n.doubleValue() > greatest.doubleValue())
        greatest = n;
    }
    return greatest.doubleValue();
  }
  
  public static void main (String[] args) {
    ArrayList<Double> list = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();    
    Stack<Date> dateStack = new Stack<>();
    HashSet<String> set = new HashSet<>();

    ArrayDeque<Number> adqNumber = new ArrayDeque<>();
    ArrayDeque<Object> adqObject = new ArrayDeque<>();

    list.add(1.0);
    list.add(4.5);
    list.add(9.3);

    linkedList.add(9);
    linkedList.add(10);
    linkedList.add(15);
    linkedList.add(10);

    dateStack.add(new Date());
    dateStack.add(new Date(30, 02, 2000));
    dateStack.add(new Date(03, Date.APRIL, 2015));

    set.add("Harel");
    set.add("Julio");
    set.add("Julio");

    adqNumber.add(50);
    adqNumber.add(100.5);
    adqNumber.add(3.3);

    copyCollection(adqNumber, adqObject);

    printCollection(adqObject);
    printCollection(list);
    printCollection(linkedList);
    printCollection(dateStack);
    printCollection(set);
    printCollection(adqObject);

    System.out.println(frequency(linkedList, 10));
    System.out.println(greatestNumber(linkedList));
  } 
}
