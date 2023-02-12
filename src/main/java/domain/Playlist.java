package domain;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
  private final ArrayList <Cancion> canciones;
  private final ArrayList <Usuario> curadores;
  private final ArrayList <Usuario> seguidores;
  private final ArrayList<Criterio> criterios;

  public Playlist(ArrayList<Cancion> canciones, ArrayList<Usuario> curadores){
    this.seguidores = new ArrayList<>();
    this.criterios = new ArrayList<>();
    this.canciones = canciones;
    this.curadores = curadores;
  }

  public void agregarCriterio(Criterio criterio){
    this.criterios.add(criterio);
  }

  public void agregarSeguidor(Usuario usuario) {
    this.seguidores.add(usuario);
  }

  public List<Usuario> obtenerSeguidores(){
    return seguidores;
  }

  public void ejecutarCriterios(Propuesta propuesta){
    criterios.forEach(
        criterio -> criterio.ejecutar(propuesta)
    );
  }

  public List<Usuario> obtenerCuradores(){
    return curadores;
  }

  public void agregarCancion(Cancion cancion) {
    // validar previamente que la cancion no se encuentra
    // ya dentro del listado
    canciones.add(cancion);
  }
}
