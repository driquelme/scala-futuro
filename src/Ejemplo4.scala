import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-16.
 */
object Ejemplo4 {

  def operacionLenta4 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Retornamos un exception
    Failure(new Exception("error"))

  }

  def main(args: Array[String]) {

    val f = Ejemplo4.operacionLenta4

    f onSuccess {
      case resultado => println(resultado)
    }

    f onFailure {
      case t => println("Ha ocurrido un error: " + t.getMessage)
    }

    println("listo")


    Thread.sleep(10000)
  }
}
