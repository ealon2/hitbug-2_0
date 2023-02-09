package domain;

import java.util.ArrayList;

public class Propuesta {

  private final Playlist playlist;
  private final Usuario creador;

  private ArrayList<Voto> votos;

  public Propuesta(Usuario creador, Playlist playlist){
    this.playlist = playlist;
    this.creador = creador;
  }

  public void agregarVoto(Voto voto){
    this.votos.add(voto);
    //Ante cada voto, se ejecutan los criterios
    this.playlist.ejecutarCriterios(this);
  }

  public void quitarVoto(Voto voto) {
    this.votos.remove(voto);
    //Ante cada voto, se ejecutan los criterios
    this.playlist.ejecutarCriterios(this);
  }
}
