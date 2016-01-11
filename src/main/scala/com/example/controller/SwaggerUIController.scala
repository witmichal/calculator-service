package com.example.controller

import akka.actor.ActorRefFactory
import spray.routing._

/**
  * Copy-paste from Authoring API (original name: com.mtvi.authapi.api.DocumentationUIService)
  * @param actorRefFactory
  */
class SwaggerUIController (implicit actorRefFactory: ActorRefFactory) extends Directives  {

  def route: Route =
    get {
      pathPrefix("") {
        pathEndOrSingleSlash {
          getFromResource("swagger-ui/index.html")
        }
      } ~
        getFromResourceDirectory("swagger-ui")
    }

}