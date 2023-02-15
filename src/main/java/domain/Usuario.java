package domain;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

  private String email;
  private Notificacion notificacion;
  private List<Notificacion> notificaciones;
  public Usuario(String email){
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}
