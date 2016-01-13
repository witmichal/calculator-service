package pl.witm.web

import pl.witm.api.Api
import pl.witm.app.Core
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

trait Web {
  this: Api with Core =>

  implicit val timeout = Timeout(5.seconds)

  IO(Http) ? Http.Bind(rootController, interface = "localhost", port = 8081)
}


