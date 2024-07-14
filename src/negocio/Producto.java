package negocio;

public class Producto {
  private String codigo;
  private String descripcion;
  private String categoria;
  private double precio;
  private int stock;

  public Producto() {
  }

  public Producto(String codigo, String descripcion, double precio, int stock, String categoria) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.precio = precio;
    this.stock = stock;
    this.categoria = categoria;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "{ " + "Código = " + this.codigo + ", Descripción = "
            + this.descripcion + ", Categoria = " + this.categoria
            + ", Precio = " + this.precio
            + ", Stock = " + this.stock + " }";
  }
}
