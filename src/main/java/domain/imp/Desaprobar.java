package domain.imp;
import domain.Voto;

public class Desaprobar extends Voto{
  /**
   * @return
   */
  @Override
  protected int obtenerValor() {
    return -1;
  }

}
