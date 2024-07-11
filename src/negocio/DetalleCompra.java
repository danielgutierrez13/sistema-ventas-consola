package negocio;

public class DetalleCompra {
  private Producto producto;
  private int cantidad;
  private double precio;

  public DetalleCompra() {
  }

  public DetalleCompra(Producto producto, int cantidad, double precio) {
    this.producto = producto;
    this.cantidad = cantidad;
    this.precio = precio;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
