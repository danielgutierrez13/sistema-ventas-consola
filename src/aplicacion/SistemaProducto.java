package aplicacion;

import negocio.Producto;
import utils.Utils;

public class SistemaProducto {

    private final Utils utils = new Utils();
    private Producto[] productos;

    private void imprimirMenuProductos() {
        System.out.println("_____________________________________");
        System.out.println("|\t\t\t\tProductos\t\t\t|");
        System.out.println("|___________________________________|");
        System.out.println("| 1. Agregar Producto\t\t\t\t|");
        System.out.println("| 2. Buscar Producto\t\t\t\t|");
        System.out.println("| 3. Actualizar Productos\t\t\t|");
        System.out.println("| 4. Eliminar Producto\t\t\t\t|");
        System.out.println("| 5. Listar Producto\t\t\t\t|");
        System.out.println("| 6. Regresar Menu Principal\t\t|");
        System.out.println("|___________________________________|");
    }

    public Producto[] ejecutar(Producto[] productos) {
        this.productos = productos;
        int opcion;
        do {
            imprimirMenuProductos();
            opcion = utils.pedirOpcionNumero(1,6, "opción del menú de productos");

            switch (opcion) {
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    listarProductos(this.productos);
                    break;
                default:
                    System.out.println("Saliendo del menú de productos...");
                    break;
            }
        } while (opcion != 6);
        return this.productos;
    }

    private void ingresarProducto() {
        System.out.println("___________________________________");
        Producto producto = ingresarDatosProducto();
        Producto[] productosAux = productos.clone();
        productos = new Producto[productosAux.length + 1];
        System.arraycopy(productosAux, 0, productos, 0, productosAux.length);
        productos[productosAux.length] = producto;
        System.out.println("Producto ingresado: " + producto);
        System.out.println("___________________________________");
    }

    private Producto ingresarDatosProducto() {
        Producto producto = new Producto();
        String codigoDelProducto = utils.pedirPalabra("codigo del producto", 100);
        producto.setCodigo(codigoDelProducto);
        String descripcionDelProducto = utils.pedirPalabra("descripción del producto", 100);
        producto.setDescripcion(descripcionDelProducto);
        String categoriaDelProducto = utils.pedirPalabra("categoria del producto", 100);
        producto.setCategoria(categoriaDelProducto);
        double precioDelProducto = utils.pedirDecimal("precio del producto");
        producto.setPrecio(precioDelProducto);
        int stockDelProduucto = utils.pedirOpcionNumero(0, 1000, "cantidad de stock del producto");
        producto.setStock(stockDelProduucto);
        return producto;
    }

    private void buscarProducto() {
        System.out.println("___________________________________");
        String codigo = utils.pedirPalabra("codigo del producto a buscar", 100);
        int posicion = buscarPosicionProducto(codigo);
        if (posicion != -1) {
            System.out.println("Producto encontrado: " + productos[posicion].toString());
        } else {
            System.out.println("Producto no encontrado ...");
        }
        System.out.println("___________________________________");
    }

    private int buscarPosicionProducto(String codigo) {
        for (int i = 0; i<productos.length; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

   private void actualizarProducto() {
       System.out.println("___________________________________");
       String codigo = utils.pedirPalabra("código del producto a actualizar", 4);
       int posicion = buscarPosicionProducto(codigo);
       if (posicion != -1) {
           Producto producto = ingresarDatosProducto();
           productos[posicion] = producto;
           System.out.println("Producto actualizado: " + producto);
       } else {
           System.out.println("Producto no encontrado ...");
       }
       System.out.println("___________________________________");
   }

   private void eliminarProducto() {
       System.out.println("___________________________________");
       Producto[] productosAux = productos.clone();
       String codigo = utils.pedirPalabra("codigo del producto a eliminar", 4);
       int posicion = buscarPosicionProducto(codigo);
       if (posicion != -1) {
           System.out.println("Producto eliminado: " + productos[posicion].toString());
           productos = new Producto[productosAux.length - 1];
           int contador = 0;
           for (int i = 0; i<productosAux.length; i++) {
               if (i != posicion) {
                   productos[contador] = productosAux[i];
                   contador++;
               }
           }
       } else {
           System.out.println("Producto no encontrado ...");
       }
       System.out.println("___________________________________");
   }

    public void listarProductos(Producto[] productos) {
        for (int i = 0; i< productos.length; i++) {
            System.out.println(productos[i].toString());
        }
    }
}
