package negocio;

public class DetalleVenta {
  private int cantidad;
  private double precio;
  private Producto producto;

  public DetalleVenta() {
  }

  public DetalleVenta(int cantidad, double precio, Producto producto) {
    this.cantidad = cantidad;
    this.precio = precio;
    this.producto = producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }
}
