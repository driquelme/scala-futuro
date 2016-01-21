import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-16.
 */
object Ejemplo2 {

  def operacionLenta2 = Future {

    //Operación que bloquea
    Thread.sleep(3000);

    //Resultado
    "hola"

  }

  def main(args: Array[String]) {

    val f = Ejemplo2.operacionLenta2

    f onSuccess {
      case resultado => println(resultado)
    }

    println("listo")


    Thread.sleep(5000);
  }
}
