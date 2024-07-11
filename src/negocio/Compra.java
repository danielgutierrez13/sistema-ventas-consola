package negocio;

public class Compra {
  private String codigoCompra;
  private String fechaCompra;
  private Proveedor proveedor;
  private double totalCompra;
  private DetalleCompra[] detalleCompra;

  public Compra() {
  }

  public Compra(String codigoCompra, String fechaCompra, Proveedor proveedor, double totalCompra, DetalleCompra[] detalleCompra) {
    this.codigoCompra = codigoCompra;
    this.fechaCompra = fechaCompra;
    this.proveedor = proveedor;
    this.totalCompra = totalCompra;
    this.detalleCompra = detalleCompra;
  }

  public String getCodigoCompra() {
    return codigoCompra;
  }

  public void setCodigoCompra(String codigoCompra) {
    this.codigoCompra = codigoCompra;
  }

  public String getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(String fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public Proveedor getProveedor() {
    return proveedor;
  }

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }

  public double getTotalCompra() {
    return totalCompra;
  }

  public void setTotalCompra(double totalCompra) {
    this.totalCompra = totalCompra;
  }

  public DetalleCompra[] getDetalleCompra() {
    return detalleCompra;
  }

  public void setDetalleCompra(DetalleCompra[] detalleCompra) {
    this.detalleCompra = detalleCompra;
  }
}
