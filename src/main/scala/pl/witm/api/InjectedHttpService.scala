package pl.witm.api

import pl.witm.core.Config
import spray.routing.HttpService

abstract class InjectedHttpService(val conf: Config) extends HttpService {
  val config = conf
}

