/**
 * Created by danielriquelme on 20-01-16.
 */
object Ejemplo1 {

  def operacionLenta1 = {

    //Operación que bloquea
    Thread.sleep(5000);

    //Resultado
    "hola"

  }

  def main(args: Array[String]) {

    Ejemplo1.operacionLenta1

    println("listo")

  }
}

