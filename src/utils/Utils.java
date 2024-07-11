package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

  private void limpiarConsolaIDENetbeans() {
    try {
      Robot pressbot = new Robot();
      pressbot.keyPress(KeyEvent.VK_CONTROL);
      pressbot.keyPress(KeyEvent.VK_L);
      pressbot.keyRelease(KeyEvent.VK_CONTROL);
      pressbot.keyRelease(KeyEvent.VK_L);
    } catch (AWTException ex) {
      System.out.println("Error al limpiar la pantalla" + ex.getMessage());
    }
  }

  private void limpiarPantallaSistema() {
    for (int i = 0; i < 100; i++) {
      System.out.println();
    }
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void limpiarPantallaSistemaPowerShell() {
    try {
      String sistemaOperativo = System.getProperty("os.name");
      ArrayList<String> comando = new ArrayList<>();
      if (sistemaOperativo.contains("Windows")) {
        comando.add("cmd");
        comando.add("/C");
        comando.add("cls");
      } else {
        comando.add("clear"); // UNIX => MAC, LINUX
      }
      ProcessBuilder pb = new ProcessBuilder(comando);
      Process iniciarProceso = pb.inheritIO().start();
      iniciarProceso.waitFor();
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      System.out.printf("Error al limpiar la pantalla: %s%n", ex.getMessage());
    } catch (Exception ex) {
      System.out.printf("Error al limpiar la pantalla: %s%n", ex.getMessage());
    }
  }
}
