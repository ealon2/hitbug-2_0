package domain.imp;

import domain.Criterio;
import domain.Propuesta;
import domain.Propuestas;

/**
 * Todos los curadores deben haber dado +1
 */
public class Unanime implements Criterio {
  /**
   * @param propuesta
   */
  @Override
  public void ejecutar(Propuesta propuesta) {
    if (propuesta.obtenerPlaylist().obtenerCuradores().size() ==
        propuesta.obtenerResultado()){

      //Agregar playlist
      propuesta.obtenerPlaylist()
          .agregarCancion(propuesta.obtenerCancion());

      //Quito del listado Pendiente
      Propuestas.instance().quitarPropuesta(propuesta);
    }

  }
}
