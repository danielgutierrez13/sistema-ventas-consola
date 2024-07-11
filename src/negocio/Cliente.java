package negocio;

public class Cliente {

  private String dni;
  private String nombres;
  private String apellidos;
  private String direccion;
  private String telefono;

  public Cliente() {
  }

  public Cliente(String dni, String nombres, String apellidos, String direccion, String telefono) {
    this.dni = dni;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public String toString() {
    return "{ " + "DNI = " + this.dni + ", Nombres = "
            + this.nombres + ", Apellidos = " + this.apellidos
            + ", Direccion = " + this.direccion
            + ", Telefono = " + this.telefono + " }";
  }
}
