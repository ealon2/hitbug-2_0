package domain;

import java.util.ArrayList;
import java.util.List;

public class Propuestas {

  private static final Propuestas instance = new Propuestas();
  private final List<Propuesta> propuestasPendientes;

  private Propuestas(){
    propuestasPendientes = new ArrayList<>();
  }

  public static Propuestas instance(){
    return instance;
  }

  public void agregarPropuesta(Propuesta propuesta){
    this.propuestasPendientes.add(propuesta);
  }

  public void quitarPropuesta(Propuesta propuesta){
    this.propuestasPendientes.remove(propuesta);
  }

  public void ejecutarPropuestasPendientes(){
    propuestasPendientes.forEach(
        propuesta -> propuesta.ejecutar()
    );
  }
}
