package aplicacion;

import negocio.Cliente;
import negocio.Venta;
import utils.Utils;

public class SistemaVenta {

    private final Utils utils = new Utils();
    private Venta[] ventas;

    private void imprimirMenuVentas() {
        System.out.println("_____________________________________");
        System.out.println("|\t\t\t\tVentas\t\t\t\t|");
        System.out.println("|___________________________________|");
        System.out.println("| 1. Agregar Venta\t\t\t\t\t|");
        System.out.println("| 2. Buscar Venta\t\t\t\t\t|");
        System.out.println("| 3. Actualizar Ventas\t\t\t\t|");
        System.out.println("| 4. Eliminar Venta\t\t\t\t\t|");
        System.out.println("| 5. Listar Ventas\t\t\t\t\t|");
        System.out.println("| 6. Regresar Menu Principal\t\t|");
        System.out.println("|___________________________________|");
    }

    public Venta[] ejecutar(Venta[] ventas) {
        this.ventas = ventas;
        int opcion;

        do {
            imprimirMenuVentas();
            opcion = utils.pedirOpcionNumero(1, 6, "opción del menú de ventas");
            switch (opcion) {
                case 1:
                    System.out.println("Agregando venta ...");
                    break;
                case 2:
                    System.out.println("Buscando venta ...");
                    break;
                case 3:
                    System.out.println("Actualizando venta ...");
                    break;
                case 4:
                    System.out.println("Eliminado venta ...");
                    break;
                case 5:
                    listarVentas(this.ventas);
                    break;
                case 6:
                    System.out.println("Regresando al menú principal ...");
                    break;
                default:
                    System.out.println("Regresando al menú principal ...");
                    break;
            }
        } while (opcion != 6);
        return this.ventas;
    }

    private void ingresarVenta() {
        System.out.println("___________________________________");

        System.out.println("___________________________________");
    }

    private Venta ingresarDatosVenta() {
        Venta venta = new Venta();
        String codigoVenta = utils.pedirPalabra("código de la venta", 100);
        venta.setCodigoVenta(codigoVenta);
        String fecha = utils.pedirPalabra("la fecha", 10);
        venta.setFecha(fecha);
        return venta;
    }

    private void listarVentas(Venta[] ventas) {
        for (int i = 0; i< ventas.length; i++) {
            System.out.println(ventas[i].toString());
        }
    }

}
