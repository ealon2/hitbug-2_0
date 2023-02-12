package domain.imp;

import domain.Criterio;
import domain.Propuesta;
import domain.Propuestas;

/**
 * Con mas de N-1's, la cancion es rechazada
 */
public class Umbral implements Criterio {
  /**
   * @param propuesta
   */
  @Override
  public void ejecutar(Propuesta propuesta) {
    if (propuesta.obtenerResultado() ==
        (- propuesta.obtenerPlaylist().obtenerCuradores().size() - 1)
        ) {
      //Quito del listado Pendiente
      Propuestas.instance().quitarPropuesta(propuesta);
    }
  }
}
