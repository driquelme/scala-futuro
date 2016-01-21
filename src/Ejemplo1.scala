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


/**
 * DestroyJavaVM is a thread that unloads the Java VM on program exit.
 *  Most of the time it should be waiting, until apocalypse of your VM.

  Signal Dispatcher is a thread that handles the native signals sent by the OS to your jvm.

  Finalizer threads pull objects from the finalization queue and calls it finalize method.

  Reference Handler is a high-priority thread to enqueue pending References.
    Its defined in java.lang.ref.References.java
 */
