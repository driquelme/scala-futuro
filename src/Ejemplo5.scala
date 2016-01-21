import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Created by danielriquelme on 20-01-16.
 */
object Ejemplo5 {

  def operacionLenta5 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 1
    "hola 1"
  }

  def operacionLenta5_1 = Future {

    //Operación que bloquea
    Thread.sleep(1000);

    //Resultado 2
    "hola 2"
  }

  def main(args: Array[String]) {

    val f1 = Ejemplo5.operacionLenta5
    val f2 = Ejemplo5.operacionLenta5_1

    val f3 = f1 map { resultado1 =>
      f2 map { resultado2 =>

        println(s"El resultado1 fue: $resultado1")
        println(s"El resultado2 fue: $resultado2")

      }
    }

    println("listo")


    Thread.sleep(10000)
  }
}
