package pe.developez.jsfwithoutparams.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import pe.developez.jsfwithoutparams.model.Persona;
import pe.developez.jsfwithoutparams.dao.PersonaDAO;

@ManagedBean
@ViewScoped
public class PersonaRegistroBean implements Serializable {

  private PersonaDAO personaDAO = new PersonaDAO();
  private Persona persona;

  @PostConstruct
  public void postConstruct() {
    persona = new Persona();
  }

  public void guardar() throws IOException {
    System.out.println(persona);
    personaDAO.insertar(persona);
    System.out.println("Persona insertada correctamente.");
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(ec.getRequestContextPath() + "/personas");
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

}
