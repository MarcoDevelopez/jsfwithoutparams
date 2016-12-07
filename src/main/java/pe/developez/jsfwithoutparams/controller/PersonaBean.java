package pe.developez.jsfwithoutparams.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pe.developez.jsfwithoutparams.model.Persona;
import pe.developez.jsfwithoutparams.dao.PersonaDAO;

@ManagedBean
@ViewScoped
public class PersonaBean implements Serializable {

  private PersonaDAO personaDAO = new PersonaDAO();
  private List<Persona> lstPersona;
  private Persona persona;

  @PostConstruct
  public void postConstruct() {
    persona = new Persona();
    lstPersona = personaDAO.lista();
  }
  
  public void ver() {
    Integer id = persona.getId();
    persona = personaDAO.getById(id);
  }
  
  public void editar() {
    
  }

  public List<Persona> getLstPersona() {
    return lstPersona;
  }

  public void setLstPersona(List<Persona> lstPersona) {
    this.lstPersona = lstPersona;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

}
