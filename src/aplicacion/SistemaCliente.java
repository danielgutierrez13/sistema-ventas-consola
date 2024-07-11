package aplicacion;

import negocio.Cliente;
import utils.Utils;

public class SistemaCliente {

  private final Utils utils = new Utils();
  private Cliente[] clientes;

  public void imprimirMenuClientes() {
    System.out.println("_____________________________________");
    System.out.println("|\t\t\t\tClientes\t\t\t|");
    System.out.println("|___________________________________|");
    System.out.println("| 1. Agregar Cliente\t\t\t\t|");
    System.out.println("| 2. Buscar Cliente\t\t\t\t\t|");
    System.out.println("| 3. Actualizar Cliente\t\t\t\t|");
    System.out.println("| 4. Eliminar Cliente\t\t\t\t|");
    System.out.println("| 5. Listar Cliente\t\t\t\t\t|");
    System.out.println("| 6. Regresar Menu Principal\t\t|");
    System.out.println("|___________________________________|");
  }

  public Cliente[] ejecutar(Cliente[] clientes) {
    this.clientes = clientes;
    int opcion;
    do {
      imprimirMenuClientes();
      opcion = utils.pedirOpcionNumero(1, 6, "opción del menu de clientes");
      switch (opcion) {
        case 1:
          ingresarClientes();
          break;
        case 2:
          buscarCliente();
          break;
        case 3:
          actualizarCliente();
          break;
        case 4:
          eliminarCliente();
          break;
        case 5:
          listarCliente();
          break;
        default:
          System.out.println("Saliendo del menu de clientes...");
          break;
      }
    } while (opcion != 6);
    return this.clientes;
  }

  private void ingresarClientes() {
    System.out.println("___________________________________");
    Cliente cliente = ingresarDatosCliente();
    Cliente[] clientesAux = clientes.clone();
    clientes = new Cliente[clientesAux.length + 1];
    System.arraycopy(clientesAux, 0, clientes, 0, clientesAux.length);
    clientes[clientesAux.length] = cliente;
    System.out.println("Cliente ingresado: " + cliente);
    System.out.println("___________________________________");
  }

  private void buscarCliente() {
    System.out.println("___________________________________");
    String dni = utils.pedirPalabra("el dni del cliente a buscar", 8);
    int index = buscarPosicionCliente(dni);
    if (index != -1) {
      System.out.println("Cliente encontrado: " + clientes[index].toString());
    } else {
      System.out.println("Cliente no encontrado");
    }
    System.out.println("___________________________________");
  }

  private void actualizarCliente() {
    System.out.println("___________________________________");
    String dni = utils.pedirPalabra("el dni del cliente a actualizar", 8);
    int index = buscarPosicionCliente(dni);
    if (index != -1) {
      Cliente cliente = ingresarDatosCliente();
      clientes[index] = cliente;
      System.out.println("Cliente actualizado: " + cliente);
    } else {
      System.out.println("Cliente no encontrado");
    }
    System.out.println("___________________________________");
  }

  private void eliminarCliente() {
    System.out.println("___________________________________");
    Cliente[] clientesAux = clientes.clone();
    String dni = utils.pedirPalabra("el dni del cliente a eliminar", 8);
    int index = buscarPosicionCliente(dni);
    if (index != -1) {
      System.out.println("Cliente eliminado: " + clientes[index].toString());
      clientes = new Cliente[clientesAux.length - 1];
      int contador = 0;
      for (Cliente cliente : clientesAux) {
        if (!cliente.getDni().equals(dni)) {
          clientes[contador] = cliente;
          contador++;
        }
      }
    } else {
      System.out.println("Cliente no encontrado");
    }
    System.out.println("___________________________________");
  }

  public void listarCliente() {
    System.out.println("___________________________________");
    for (Cliente cliente : clientes) {
      System.out.println(cliente.toString());
    }
    System.out.println("___________________________________");
  }

  private int buscarPosicionCliente(String dni) {
    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i].getDni().equals(dni)) {
        return i;
      }
    }
    return -1;
  }

  private Cliente ingresarDatosCliente() {
    String nombre = utils.pedirPalabra("el nombre del cliente", 100);
    String apellido = utils.pedirPalabra("el apellido del cliente", 100);
    String dni = utils.pedirPalabra("el dni del cliente", 8);
    String direccion = utils.pedirPalabra("la direccion del cliente", 100);
    String telefono = utils.pedirPalabra("el telefono del cliente", 15);
    return new Cliente(dni, nombre, apellido, direccion, telefono);
  }
}
