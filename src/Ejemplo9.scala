import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Created by danielriquelme on 20-01-19.
 */
object Ejemplo9 {

  def operacionLenta9 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 2
    "hola 1"
  }

  def operacionLenta9_1 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 2
    //"hola 2"
    throw new Exception("error 2")
  }

  def operacionLenta9_2 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 3
    "hola 3"
  }

  def main(args: Array[String]) {

    val f1 = Ejemplo9.operacionLenta9
    val f2 = Ejemplo9.operacionLenta9_1
    val f3 = Ejemplo9.operacionLenta9_2

    val f4 = for {
      resultado1 <- f1
      resultado2 <- f2
      resultado3 <- f3
    } yield (resultado1, resultado2, resultado3)

    f4 onSuccess {
      case resultado => println(s"El resultado es $resultado")
    }

    f4 recoverWith {
      case error => {
        println(s"Ocurrio el error: $error, pero vamos a seguir con otro futuro")
        f3 map { resultado3 =>
          println(s"El futuro 3 ha terminado: $resultado3")
        }
      }
    }

    println("listo")


    Thread.sleep(10000)
  }
}
