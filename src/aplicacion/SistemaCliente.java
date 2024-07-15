package aplicacion;

import negocio.Cliente;
import utils.Utils;

public class SistemaCliente {

  private final Utils utils = new Utils();
  private Cliente[] clientes;

  private void imprimirMenuClientes() {
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
          buscarCliente(this.clientes);
          break;
        case 3:
          actualizarCliente();
          break;
        case 4:
          eliminarCliente();
          break;
        case 5:
          listarCliente(this.clientes);
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

  public Cliente buscarCliente(Cliente[] clientes) {
    System.out.println("___________________________________");
    String dni = utils.pedirPalabra("el dni del cliente a buscar", 8);
    int posicion = buscarPosicionCliente(dni, clientes);
    if (posicion != -1) {
      System.out.println("Cliente encontrado: " + clientes[posicion].toString());
    } else {
      System.out.println("Cliente no encontrado ...");
    }
    System.out.println("___________________________________");
    if (posicion != -1) {
      return clientes[posicion];
    } else {
      return null;
    }
  }

  private void actualizarCliente() {
    System.out.println("___________________________________");
    String dni = utils.pedirPalabra("el dni del cliente a actualizar", 8);
    int posicion = buscarPosicionCliente(dni, this.clientes);
    if (posicion != -1) {
      Cliente cliente = ingresarDatosCliente();
      clientes[posicion] = cliente;
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
    int posicion = buscarPosicionCliente(dni, this.clientes);
    if (posicion != -1) {
      System.out.println("Cliente eliminado: " + clientes[posicion].toString());
      clientes = new Cliente[clientesAux.length - 1];
      int contador = 0;
      for (int i = 0; i < clientesAux.length; i++) {
        if (!clientesAux[i].getDni().equals(dni)) {
          clientes[contador] = clientesAux[i];
          contador++;
        }
      }
    } else {
      System.out.println("Cliente no encontrado");
    }
    System.out.println("___________________________________");
  }

  public void listarCliente(Cliente[] clientes) {
    System.out.println("___________________________________");
    for (int i = 0; i<clientes.length; i++) {
      System.out.println(clientes[i].toString());
    }
    System.out.println("___________________________________");
  }

  private int buscarPosicionCliente(String dni, Cliente[] clientes) {
    for (int i = 0; i < clientes.length; i++) {
      if (clientes[i].getDni().equals(dni)) {
        return i;
      }
    }
    return -1;
  }

  private Cliente ingresarDatosCliente() {
    Cliente cliente = new Cliente();
    String nombre = utils.pedirPalabra("el nombre del cliente", 100);
    cliente.setNombres(nombre);
    String apellido = utils.pedirPalabra("el apellido del cliente", 100);
    cliente.setApellidos(apellido);
    String dni = utils.pedirPalabra("el dni del cliente", 8);
    cliente.setDni(dni);
    return cliente;
  }
}
