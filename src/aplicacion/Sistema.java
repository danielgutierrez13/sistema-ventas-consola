package aplicacion;

import negocio.Cliente;
import negocio.Compra;
import negocio.DetalleCompra;
import negocio.DetalleVenta;
import negocio.Producto;
import negocio.Proveedor;
import negocio.Venta;
import utils.Utils;

public class Sistema {

  private final Utils utils = new Utils();
  private final SistemaCliente sistemaCliente = new SistemaCliente();


  public Sistema() {
    ejecutar();
  }

  private void imprimirMenuSistemaVentas() {
    System.out.println("_____________________________________");
    System.out.println("|\t\t\tSistema de Ventas\t\t|");
    System.out.println("|___________________________________|");
    System.out.println("| 1. Clientes\t\t\t\t\t\t|");
    System.out.println("| 2. Proveedores\t\t\t\t\t|");
    System.out.println("| 3. Productos\t\t\t\t\t\t|");
    System.out.println("| 4. Compras\t\t\t\t\t\t|");
    System.out.println("| 5. Ventas\t\t\t\t\t\t\t|");
    System.out.println("| 6. Inventarios\t\t\t\t\t|");
    System.out.println("| 7. Reportes\t\t\t\t\t\t|");
    System.out.println("| 8. Usuarios\t\t\t\t\t\t|");
    System.out.println("| 9. Salir\t\t\t\t\t\t\t|");
    System.out.println("|___________________________________|");
  }

  private void ejecutar() {
    int opcion;

    Cliente[] clientes = new Cliente[0];
    Proveedor[] proveedores = new Proveedor[0];
    Producto[] productos = new Producto[0];
    Compra[] compras = new Compra[0];
    DetalleCompra[] detalleCompras = new DetalleCompra[0];
    Venta[] ventas = new Venta[0];
    DetalleVenta[] detalleVentas = new DetalleVenta[0];

    do {
      imprimirMenuSistemaVentas();
      opcion = utils.pedirOpcionNumero(1, 9, "opción del menu de sistema de ventas");
      switch (opcion) {
        case 1:
          clientes = sistemaCliente.ejecutar(clientes);
          break;
        case 2:
          System.out.printf("Opción %d: Proveedores\n", opcion);
          break;
        case 3:
          System.out.printf("Opción %d: Productos\n", opcion);
          break;
        case 4:
          System.out.printf("Opción %d: Compras\n", opcion);
          break;
        case 5:
          System.out.printf("Opción %d: Ventas\n", opcion);
          break;
        case 6:
          System.out.printf("Opción %d: Inventarios\n", opcion);
          break;
        case 7:
          System.out.printf("Opción %d: Reportes\n", opcion);
          break;
        case 8:
          System.out.printf("Opción %d: Usuarios\n", opcion);
          break;
        default:
          System.out.println("Saliendo del sistema de ventas...");
          break;
      }
    } while (opcion != 9);
  }
}
