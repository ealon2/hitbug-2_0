import domain.Propuestas;

/** Hitbug 2.0.
 * Desde esta clase se ejecuta la aplicacion.
 * En particular, podemos observar que se debe configurar aca el cron.
 */
public class Application {
  public static void main(String[] args) {
    //cron
    Propuestas.instance().ejecutarPropuestasPendientes();
  }
}
