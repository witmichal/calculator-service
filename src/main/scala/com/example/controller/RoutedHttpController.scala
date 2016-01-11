package com.example.controller

import akka.actor.{Props, ActorContext, Actor}
import spray.routing._
import com.gettyimages.spray.swagger.SwaggerHttpService
import scala.reflect.runtime.universe._
//import com.example.controller.AddRoute

object RoutedHttpController {
  def props(route: Route): Props = Props(new RoutedHttpController(route))
}

class RoutedHttpController(route: Route) extends Actor with HttpService {


  implicit def actorRefFactory: ActorContext = context

  private val docService = new SwaggerHttpService {
    override def apiTypes: Seq[Type] = Seq(
      typeOf[CalculatorController /*with AddRoute*/ ]
    )
    override def actorRefFactory: ActorContext = context
    override def apiVersion: String = "001"
    override def baseUrl: String = "/"
    override def docsPath: String = "api-docs"
  }

  private val swaggerUi = new SwaggerUIController

  val fullRoute =
        route ~
          docService.routes ~
          swaggerUi.route

  def receive: Receive =
    runRoute(fullRoute)

}
