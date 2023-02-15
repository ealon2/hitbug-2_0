package domain.imp;

import domain.Voto;

/**
 * Aprobar implica sumar 1 punto.
 */
public class Aprobar extends Voto {

  /**
   * @return El valor del voto.
   *
   */
  @Override
  protected int obtenerValor() {
    return 1;
  }
}
