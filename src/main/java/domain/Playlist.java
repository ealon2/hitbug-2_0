package domain;

import java.util.ArrayList;

public class Playlist {
  private ArrayList <Cancion> canciones;
  private ArrayList <Usuario> curadores;
  private ArrayList <Usuario> seguidores;
  private ArrayList<Criterio> criterios;


  Playlist(ArrayList canciones, ArrayList curadores, ArrayList seguidores, ArrayList criterio){
    this.seguidores = seguidores;
    this.criterios = seguidores;
    this.canciones = canciones;
    this.curadores = curadores;
  }

  public void agregarSeguidor(Usuario usuario) {
    seguidores.add(usuario);
  }

  public void ejecutarCriterios(Propuesta propuesta){
    criterios.stream().forEach(
        criterio -> criterio.ejecutar(propuesta)
    );
  }

}
