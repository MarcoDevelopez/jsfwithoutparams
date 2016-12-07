package pe.developez.jsfwithoutparams.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import pe.developez.jsfwithoutparams.dao.PersonaDAO;
import pe.developez.jsfwithoutparams.model.Persona;

@ManagedBean
@ViewScoped
public class PersonaEditarBean implements Serializable {

  private PersonaDAO personaDAO = new PersonaDAO();
  private Persona persona = new Persona();
  private Integer id;

  public void editar() {
    persona = personaDAO.getById(id);
  }
  
  public void actualizar() throws IOException {
    System.out.println(persona);
    personaDAO.actualizar(persona);
    System.out.println("Persona actualizada correctamente.");
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/personas");
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
