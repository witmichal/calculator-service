package pl.witm.api

import pl.witm.app.Core
import pl.witm.controller.{RoutedHttpController, CalculatorController}
import pl.witm.core.CoreServices
import spray.routing.RouteConcatenation

/**
  * The trait extends RouteConcatenation just for consistency with \"Authoring API\"
  */
trait Api extends RouteConcatenation {
  this: CoreServices with Core =>

  val routes = (new CalculatorController(calculatorService)).route

  val rootController = system.actorOf(RoutedHttpController.props(routes)) // Core.system

}
