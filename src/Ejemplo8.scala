import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-18.
 */
object Ejemplo8 {

  def operacionLenta8 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 2
    "hola 1"
  }

  def operacionLenta8_1 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 2
    //"hola 2"
    throw new Exception("error 2")
  }

  def operacionLenta8_2 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 3
    "hola 3"
  }

  def main(args: Array[String]) {

    val f1 = Ejemplo8.operacionLenta8
    val f2 = Ejemplo8.operacionLenta8_1
    val f3 = Ejemplo8.operacionLenta8_2

    val f4 = for {
      resultado1 <- f1
      resultado2 <- f2
      resultado3 <- f3
    } yield (resultado1, resultado2, resultado3)

    f4 onSuccess {
      case resultado => println(s"El resultado es $resultado")
    }

    f4 onFailure {
      case error => println(s"El error es $error")
    }

    println("listo")


    Thread.sleep(10000)
  }
}
