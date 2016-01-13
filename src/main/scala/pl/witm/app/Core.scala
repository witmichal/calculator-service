package pl.witm.app

import akka.actor.ActorSystem


trait Core {
  implicit def system: ActorSystem
}


trait BootedCore extends Core {

  implicit lazy val system = ActorSystem("calculator-api")

  sys.addShutdownHook(system.terminate())

}