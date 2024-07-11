package negocio;

public class Venta {
  private String codigoVenta;
  private String fecha;
  private Cliente cliente;
  private double totalVenta;
  private DetalleVenta[] detalleVenta;

  public Venta() {
  }

  public Venta(String codigoVenta, String fecha, Cliente cliente, double totalVenta, DetalleVenta[] detalleVenta) {
    this.codigoVenta = codigoVenta;
    this.fecha = fecha;
    this.cliente = cliente;
    this.totalVenta = totalVenta;
    this.detalleVenta = detalleVenta;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta) {
    this.codigoVenta = codigoVenta;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public double getTotalVenta() {
    return totalVenta;
  }

  public void setTotalVenta(double totalVenta) {
    this.totalVenta = totalVenta;
  }

  public DetalleVenta[] getDetalleVenta() {
    return detalleVenta;
  }

  public void setDetalleVenta(DetalleVenta[] detalleVenta) {
    this.detalleVenta = detalleVenta;
  }
}