import domain.*;
import domain.imp.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class EnunciadoTest {

  ArrayList<Cancion> canciones;
  ArrayList<Usuario> curadores;
  Cancion unaCancion;
  Usuario unCurador;
  @BeforeEach
  void setUp(){
    canciones = mock(ArrayList.class);
    curadores = mock(ArrayList.class);
    unaCancion = mock(Cancion.class);
    unCurador = mock(Usuario.class);
    // stubbing appears before the actual execution
    when(canciones.get(0)).thenReturn(unaCancion);
    when(curadores.get(0)).thenReturn(unCurador);
  }

  @Test
  @DisplayName("Como persona usuaria, crear una playlist indicando sus canciones y curadores")
  public void crearUnaPlaylist(){
    Playlist unaPlaylist = new Playlist(canciones,curadores);
    assertNotNull(unaPlaylist);
  }

  @Test
  @DisplayName("Como person usuaria, seguir una playlist")
  public void seguirUnaPlaylist(){
    Usuario unSeguidor = mock(Usuario.class);
    Playlist unaPlaylist = new Playlist(canciones,curadores);
    unaPlaylist.agregarSeguidor(unSeguidor);
    assertEquals(unSeguidor, unaPlaylist.obtenerSeguidores().get(0));
  }

  @Test
  @DisplayName("Como person usuaria, reproducir una playlist en sus distintos modos")
  public void reproducirUnaPlaylist(){
    Playlist unaPlaylist = new Playlist(canciones,curadores);
    Estricto modoEstricto = new Estricto();
    Estricto modoSugerido = new Estricto();
    Estricto modoTotal = new Estricto();

    modoEstricto.ejecutar(unaPlaylist);
    modoSugerido.ejecutar(unaPlaylist);
    modoTotal.ejecutar(unaPlaylist);
    //TODO: Evaluar como testearlo
  }

  @Test
  @DisplayName("Como persona seguidora, proponer una cancion a una playlist")
  public void crearPropuestaEnUnaPlaylist(){

    Playlist unaPlaylist = new Playlist(canciones,curadores);

    //TODO: Asumo que existe un Builder que valida que el usuario
    // sea seguidor de la playlist para efectuar una propuesta
    Propuesta unaPropuesta = new Propuesta(unaCancion,unaPlaylist);
    assertNotNull(unaPropuesta);
  }

  @Test
  @DisplayName("Como persona curadora, poder dar una +1 o -1 a una cancion")
  public void votarPropuestaEnUnaPlaylist(){

    Playlist unaPlaylist = new Playlist(canciones,curadores);

    //TODO: Asumo que existe un Builder que valida que el usuario
    // sea seguidor de la playlist para efectuar una propuesta
    Propuesta unaPropuesta = new Propuesta(unaCancion,unaPlaylist);
    assertNotNull(unaPropuesta);

    Aprobar unaAprobacion = new Aprobar();
    Desaprobar unaDesaprobacion = new Desaprobar();

    unaAprobacion.aplicar(unaPropuesta);
    unaDesaprobacion.aplicar(unaPropuesta);
  }

  @Test
  @DisplayName("Como persona curadora, cambiar el Criterio de Aceptacion o de Rechazo")
  public void cambiarCriterioDeAprobacionRechazo() {

    Playlist unaPlaylist = new Playlist(canciones,curadores);
    Criterio unCriterioDeAprobacion = new Unanime();
    Criterio unCriterioDeRechazo = new Umbral();
    Criterio nuevoCriterio = new Unanime();

    unaPlaylist.agregarCriterio(unCriterioDeAprobacion);
    unaPlaylist.agregarCriterio(unCriterioDeRechazo);

    //Asumo que existe una validacion previa desde un Builder
    //Donde se contempla los criterios cargados
    unaPlaylist.agregarCriterio(nuevoCriterio);
  }

  @Test
  @DisplayName("Como persona curadora, poder cambiar o remover mi voto")
  public void cambiarMiEleccionEnElVoto() {

    Playlist unaPlaylist = new Playlist(canciones,curadores);
    Propuesta unaPropuesta = new Propuesta(unaCancion,unaPlaylist);
    Voto unVoto = new Aprobar();

    //Puedo agregar un voto
    unaPropuesta.agregarVoto(unVoto);

    //Puedo quitar un voto
    unaPropuesta.quitarVoto(unVoto);

    //Puedo cambiar de eleccion
    unVoto.aplicar(unaPropuesta);
    unVoto.desaplicar(unaPropuesta);
  }

  @Test
  @DisplayName("Como persona usuaria, quiero que la playlista se actualice automaticamente ni bien algun criterio es alcanzado")
  public void actualizarPlaylistAnteCadaCriterioAlcanzado() {
    //Esto ya lo probamos con la aprobacion
  }

}
