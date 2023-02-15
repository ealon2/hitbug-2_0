package domain;

import java.util.ArrayList;

public class Propuesta {

  private final Usuario propietario;
  private final Playlist playlist;
  private final Cancion cancion;
  private ArrayList<Voto> votos;

  public Propuesta(Usuario propietario,Cancion unaCancion, Playlist playlist){
    this.propietario = propietario;
    this.playlist = playlist;
    this.cancion = unaCancion;
    this.votos = new ArrayList<>();
    Propuestas.instance().agregarPropuesta(this);
  }

  public void agregarVoto(Voto voto){
    this.votos.add(voto);
    this.ejecutar();
  }

  public void quitarVoto(Voto voto) {
    this.votos.remove(voto);
    //Ante cada voto, se ejecutan los criterios
    this.ejecutar();
  }

  public Playlist obtenerPlaylist(){
    return playlist;
  }

  public int obtenerResultado(){
    return votos.stream()
        .mapToInt(voto -> voto.obtenerValor())
        .sum();
  }

  public Cancion obtenerCancion() {
    return cancion;
  }

  public void ejecutar(){
    this.playlist.ejecutarCriterios(this);
  }

  public Usuario obtenerPropietario() {
    return propietario;
  }
}
