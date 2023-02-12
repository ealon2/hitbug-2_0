import domain.Propuestas;

public class Application {
  public static void main(String[] args) {
    //cron
    Propuestas.instance().ejecutarPropuestasPendientes();
  }
}
