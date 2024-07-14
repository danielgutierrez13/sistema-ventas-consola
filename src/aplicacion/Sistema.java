package aplicacion;

import negocio.Cliente;
import negocio.Producto;
import utils.Utils;

public class Sistema {

  private final Utils utils = new Utils();
  private final SistemaCliente sistemaCliente = new SistemaCliente();
  private final SistemaProducto sistemaProducto = new SistemaProducto();

  private void imprimirMenuSistemaVentas() {
    System.out.println("_____________________________________");
    System.out.println("|\t\t\tSistema de Ventas\t\t|");
    System.out.println("|___________________________________|");
    System.out.println("| 1. Clientes\t\t\t\t\t\t|");
    System.out.println("| 2. Productos\t\t\t\t\t\t|");
    System.out.println("| 3. Ventas\t\t\t\t\t\t\t|");
    System.out.println("| 4. Inventarios\t\t\t\t\t|");
    System.out.println("| 5. Reportes\t\t\t\t\t\t|");
    System.out.println("| 6. Salir\t\t\t\t\t\t\t|");
    System.out.println("|___________________________________|");
  }

  public void ejecutar() {
    int opcion;

    Cliente[] clientes = generarClientes();
    Producto[] productos = generarProductos();
    do {
      imprimirMenuSistemaVentas();
      opcion = utils.pedirOpcionNumero(1, 9, "opción del menu de sistema de ventas");
      switch (opcion) {
        case 1:
          clientes = sistemaCliente.ejecutar(clientes);
          break;
        case 2:
          productos = sistemaProducto.ejecutar(productos);
          break;
        case 3:
          System.out.printf("Opción %d: Ventas\n", opcion);
          break;
        case 4:
          sistemaProducto.listarProductos(productos);
          break;
        case 5:
          System.out.printf("Opción %d: Reportes\n", opcion);
          break;
        default:
          System.out.println("Saliendo del sistema de ventas...");
          break;
      }
    } while (opcion != 6);
  }

  private Cliente[] generarClientes() {
    Cliente cliente1 = new Cliente("72113011", "Benjamin", "Gutierrez");
    Cliente cliente2 = new Cliente("72113010", "Yesmer", "Gutierrez");
    Cliente cliente3 = new Cliente("72113009", "Daniel", "Gutierrez");

    Cliente[] clientes = {cliente1, cliente2, cliente3};
    return clientes;
  }

  private Producto[] generarProductos() {
    Producto producto1 = new Producto("1234", "Lapto HP", 2400, 8, "tecnologia");
    Producto producto2 = new Producto("1357", "Lapto Lenovo", 3650, 10, "tecnologia");
    Producto producto3 = new Producto("2468", "Lapto Toshiba", 2000.50, 8, "tecnologia");

    Producto[] productos = {producto1, producto2, producto3};
    return productos;
  }

}
