package com.example.api

import com.example.app.Core
import com.example.controller.{RoutedHttpController, CalculatorController}
import com.example.core.CoreServices
import spray.routing.RouteConcatenation

/**
  * The trait extends RouteConcatenation just for consistency with \"Authoring API\"
  */
trait Api extends RouteConcatenation {
  this: CoreServices with Core =>

  val routes = (new CalculatorController(calculatorService)).route

  val rootController = system.actorOf(RoutedHttpController.props(routes)) // Core.system

}
