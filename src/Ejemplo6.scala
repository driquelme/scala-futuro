import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-16.
 */
object Ejemplo6 {

  def operacionLenta6 = Future {
    //Operación que bloquea
    Thread.sleep(1000);
    //Lanzamos exception
    throw new Exception("error 1")
  }

  def operacionLenta6_1 = Future {
    //Operación que bloquea
    Thread.sleep(1000);
    //Resultado 2
    "hola 2"
  }

  def main(args: Array[String]) {

    val f1 = Ejemplo6.operacionLenta6
    val f2 = Ejemplo6.operacionLenta6_1

    val f3 = f1 fallbackTo f2

    f3 onSuccess {
      case resultado => println(s"El resultado es $resultado")
    }

    println("listo")


    Thread.sleep(10000)
  }
}
