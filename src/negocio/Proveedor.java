package negocio;

public class Proveedor {
  private String ruc;
  private String razonSocial;
  private String email;
  private String telefono;
  private String direccion;

  public Proveedor() {
  }

  public Proveedor(String ruc, String razonSocial, String email, String telefono, String direccion) {
    this.ruc = ruc;
    this.razonSocial = razonSocial;
    this.email = email;
    this.telefono = telefono;
    this.direccion = direccion;
  }

  public String getRuc() {
    return ruc;
  }

  public void setRuc(String ruc) {
    this.ruc = ruc;
  }

  public String getRazonSocial() {
    return razonSocial;
  }

  public void setRazonSocial(String razonSocial) {
    this.razonSocial = razonSocial;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
}
