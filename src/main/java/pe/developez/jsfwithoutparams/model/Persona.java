package pe.developez.jsfwithoutparams.model;

public class Persona {

  private Integer id;
  private String nombres;
  private String apellidos;
  private String telefono;

  public Persona() {
    id = 0;
  }

  public Persona(Integer id, String nombres, String apellidos, String telefono) {
    this.id = id;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.telefono = telefono;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }

  @Override
  @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Persona other = (Persona) obj;
    return !(this.id != other.id && (this.id == null || !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "Persona{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono + '}';
  }

}
