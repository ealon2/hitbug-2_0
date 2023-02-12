package domain.imp;

import domain.Voto;

public class Aprobar extends Voto {

  /**
   * @return
   */
  @Override
  protected int obtenerValor() {
    return 1;
  }
}
