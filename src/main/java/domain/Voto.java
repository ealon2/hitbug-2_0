package domain;

public abstract class Voto {

  abstract int obtenerValor();

  public void aplicar(Propuesta propuesta){
    propuesta.agregarVoto(this);
  }

  public void desaplicar(Propuesta propuesta){
    propuesta.quitarVoto(this);
  }
}
