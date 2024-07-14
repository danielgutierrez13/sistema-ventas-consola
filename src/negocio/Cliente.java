package negocio;

public class Cliente {

  private String dni;
  private String nombres;
  private String apellidos;

  public Cliente() {
  }

  public Cliente(String dni, String nombres, String apellidos) {
    this.dni = dni;
    this.nombres = nombres;
    this.apellidos = apellidos;
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

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  @Override
  public String toString() {
    return "{ " + "DNI = " + this.dni + ", Nombres = "
            + this.nombres + ", Apellidos = " + this.apellidos + " }";
  }
}
