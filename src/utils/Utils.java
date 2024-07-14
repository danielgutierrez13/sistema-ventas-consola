package utils;

import java.util.Scanner;

public class Utils {

  public String pedirPalabra(String men, int tamanio) {
    Scanner lec = new Scanner(System.in);
    String palabra;
    boolean bandera;
    do {
      System.out.print(">Ingrese " + men + ": ");
      palabra = lec.nextLine().toLowerCase().trim();
      bandera = palabra.length() > tamanio || palabra.isEmpty();
      if (bandera) {
        System.out.println("Caracteres o tamaño no permitido");
      }
    } while (bandera);

    return palabra;
  }

  public int pedirOpcionNumero(int li, int ls, String men) {
    Scanner lec = new Scanner(System.in);
    System.out.print(">Ingrese " + men + ": ");
    int opcionMenu = lec.nextInt();
    while (opcionMenu < li || opcionMenu > ls) {
      System.out.print(">Ingrese una " + men + " valida entre " + li + " y " + ls + ": ");
      opcionMenu = lec.nextInt();
    }
    return opcionMenu;
  }

  public double pedirDecimal(String men) {
    Scanner lec = new Scanner(System.in);
    System.out.print(">Ingrese " + men + ": ");
    double valor = lec.nextDouble();
    return valor;
  }
}
