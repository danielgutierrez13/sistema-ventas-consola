package aplicacion;

import negocio.Cliente;
import negocio.DetalleVenta;
import negocio.Producto;
import negocio.Venta;
import utils.Utils;

public class SistemaVenta {

    private final Utils utils = new Utils();
    private final SistemaCliente sistemaCliente = new SistemaCliente();
    private final SistemaProducto sistemaProducto = new SistemaProducto();

    private Venta[] ventas;
    private Producto[] productos;
    private Cliente[] clientes;

    private void imprimirMenuVentas() {
        System.out.println("_____________________________________");
        System.out.println("|\t\t\t\tVentas\t\t\t\t|");
        System.out.println("|___________________________________|");
        System.out.println("| 1. Agregar Venta\t\t\t\t\t|");
        System.out.println("| 2. Listar Ventas\t\t\t\t\t|");
        System.out.println("| 3. Regresar Menu Principal\t\t|");
        System.out.println("|___________________________________|");
    }

    public Object[] ejecutar(Venta[] ventas, Producto[] productos, Cliente[] clientes) {
        this.ventas = ventas;
        this.productos = productos;
        this.clientes = clientes;

        int opcion;

        do {
            imprimirMenuVentas();
            opcion = utils.pedirOpcionNumero(1, 3, "opción del menú de ventas");
            switch (opcion) {
                case 1:
                    ingresarVenta();
                    break;
                case 2:
                    listarVentas(this.ventas);
                    break;
                default:
                    System.out.println("Regresando al menú principal ...");
                    break;
            }
        } while (opcion != 3);

      Object[] object = {this.ventas, this.productos};
      return object;
    }

    private void ingresarVenta() {
        System.out.println("___________________________________");
        Venta venta = ingresarDatosVenta();
        Venta[] ventasAux = ventas.clone();
        ventas = new Venta[ventasAux.length + 1];
        System.arraycopy(ventasAux, 0, ventas, 0, ventasAux.length);
        ventas[ventasAux.length] = venta;
        System.out.println("Venta ingresada: " + venta);
        System.out.println("___________________________________");
    }


    private void listarVentas(Venta[] ventas) {
        for (int i = 0; i< ventas.length; i++) {
            System.out.println(ventas[i].toString());
        }
    }

    private Venta ingresarDatosVenta() {
        Venta venta = new Venta();
        String codigoVenta = utils.pedirPalabra("código de la venta", 100);
        venta.setCodigoVenta(codigoVenta);
        String fecha = utils.pedirPalabra("la fecha", 10);
        venta.setFecha(fecha);
        sistemaCliente.listarCliente(this.clientes);
        Cliente cliente;
        do {
          cliente = sistemaCliente.buscarCliente(this.clientes);
        } while (cliente == null);
        venta.setCliente(cliente);

        int numeroDetalle = utils.pedirOpcionNumero(1, 100, "la cantidad de items que registrara");

        DetalleVenta[] detalleVenta = new DetalleVenta[numeroDetalle];
        for (int i = 0; i < numeroDetalle; i++) {
          detalleVenta[i] = ingresarDetalle();
        }
        venta.setDetalleVenta(detalleVenta);
        venta.calcularTotalVenta();
        return venta;
    }

    private DetalleVenta ingresarDetalle() {
        DetalleVenta detalleVenta = new DetalleVenta();
        sistemaProducto.listarProductos(this.productos);
        Producto producto;
        do {
          producto = sistemaProducto.buscarProducto(this.productos);
        } while (producto == null);
        detalleVenta.setProducto(producto);
        int cantidad;
        do {
          cantidad = utils.pedirOpcionNumero(1, 100, "la cantidad de productos considerando el stock");
        } while (producto.getStock() < cantidad);
        detalleVenta.setCantidad(cantidad);
        detalleVenta.setPrecio(cantidad * producto.getPrecio());
        disminuirStock(producto, cantidad);
        return detalleVenta;
    }

    public void disminuirStock(Producto productos, int cantidad) {
      int posicion = sistemaProducto.buscarPosicionProducto(this.productos, productos.getCodigo());
      this.productos[posicion].setStock(this.productos[posicion].getStock() - cantidad);
    }
}
