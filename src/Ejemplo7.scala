import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-17.
 */
object Ejemplo7 {

  def operacionLenta7 = Future {

    //Operación que bloquea
    Thread.sleep(3000);

    //Resultado 2
    "hola 1"

    throw new Exception("ERROR")

    println("1")
  }

  def operacionLenta7_1 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    println("2")

    //Resultado 2
    "hola 2"
  }

  def operacionLenta7_2 = Future {

    //Operación que bloquea
    Thread.sleep(500);

    println("3")

    //Resultado 3
    "hola 3"
  }

  def main(args: Array[String]) {

    val f1 = Ejemplo7.operacionLenta7
    val f2 = Ejemplo7.operacionLenta7_1
    val f3 = Ejemplo7.operacionLenta7_2

    val f4 = for {
      resultado1 <- f1
      resultado2 <- f2
      resultado3 <- f3
    } yield (resultado1, resultado2, resultado3)

    f4 onSuccess {
      case resultado => println(s"El resultado es $resultado")
    }

    println("listo")


    Thread.sleep(10000)
  }
}
