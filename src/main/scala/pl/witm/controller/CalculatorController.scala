package pl.witm.controller

import javax.ws.rs.Path

import akka.actor.{ActorRefFactory}
import pl.witm.marshalling.{Error, Result}
import pl.witm.service.higher.CalculatorService
import com.wordnik.swagger.annotations.{ApiImplicitParam, ApiImplicitParams, ApiOperation, Api}
import spray.http.MediaTypes
import spray.routing._
import MediaTypes._
import scala.concurrent.ExecutionContext.Implicits.global

// spray-json
import spray.httpx.SprayJsonSupport._
import pl.witm.marshalling.ResponseJsonProtocol._

@Api(
  value = "/calc",
  description = "Calculator service",
  produces = "application/json, text/xml"
)
class CalculatorController(calculatorService: CalculatorService)(implicit val actorRefFactory: ActorRefFactory)
  extends HttpService with HelpRoute with CalculatorPath with Serviced
  with AddRoute with SubRoute with MulRoute with DivRoute with RemRoute {

  override val service = calculatorService

  val route =
    addRoute ~
    subRoute ~
    mulRoute ~
    divRoute ~
    remRoute ~
    help

}

trait CalculatorPath {
  val basePath: String = "calc"
}

/**
  * Every first-order controller is being serviced by only one service. That is the reason for this trait.
  */
trait Serviced {
  def service: CalculatorService
}

trait AddRoute extends HttpServiceBase {
  this: CalculatorPath with Serviced =>

  @Path("/add/{a}/{b}")
  @ApiOperation(value = "Add two integers.", notes = "Returns result of addition operation.", httpMethod = "POST", response =
    classOf[String])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "a", value = "aa", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "b", value = "bb", required = true, dataType = "string", paramType = "path")
  ))
  def addRoute: Route = post {
    path( basePath / "add" / IntNumber / IntNumber ) { (a, b) =>
      respondWithMediaType(`application/json`) {
        complete {
          service.add(a, b)
        }
      }
    }
  }

}

trait SubRoute extends HttpServiceBase {
  this: CalculatorPath with Serviced =>

  @Path("/sub/{a}/{b}")
  @ApiOperation(value = "Subtracts two integers.", notes = "Returns result of subtraction operation.", httpMethod = "POST", response =
    classOf[String])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "a", value = "aa", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "b", value = "bb", required = true, dataType = "string", paramType = "path")
  ))
  def subRoute: Route = post {
    path( basePath / "sub" / IntNumber / IntNumber ) { (a, b) =>
      respondWithMediaType(`application/json`) {
        complete {
          service.sub(a, b)
        }
      }
    }
  }

}

trait MulRoute extends HttpServiceBase {
  this: CalculatorPath with Serviced =>

  @Path("/mul/{a}/{b}")
  @ApiOperation(value = "Multiplicates two integers.", notes = "Returns result of multiplication operation.", httpMethod = "POST", response =
    classOf[String])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "a", value = "aa", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "b", value = "bb", required = true, dataType = "string", paramType = "path")
  ))
  def mulRoute: Route = post {
    path( basePath / "mul" / IntNumber / IntNumber ) { (a, b) =>
      respondWithMediaType(`application/json`) {
        complete {
          service.mul(a,b)
        }
      }
    }
  }

}

trait DivRoute extends HttpServiceBase {
  this: CalculatorPath with Serviced =>

  @Path("/div/{a}/{b}")
  @ApiOperation(value = "Divides two integers.", notes = "Returns result of division operation.", httpMethod = "POST", response =
    classOf[String])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "a", value = "aa", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "b", value = "bb", required = true, dataType = "string", paramType = "path")
  ))
  def divRoute: Route = post {
    path( basePath / "div" / IntNumber / IntNumber ) { (a, b) =>
      respondWithMediaType(`application/json`) {
        complete {
          service.div(a,b)
        }
      }
    }
  }

}

trait RemRoute extends HttpServiceBase {
  this: CalculatorPath with Serviced =>

  @Path("/rem/{a}/{b}")
  @ApiOperation(value = "Reminder of two integers.", notes = "Returns result of reminder operation.", httpMethod = "POST", response =
    classOf[String])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "a", value = "aa", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "b", value = "bb", required = true, dataType = "string", paramType = "path")
  ))
  def remRoute: Route = post {
    path(basePath / "rem" / IntNumber / IntNumber) { (a, b) =>
      respondWithMediaType(`application/json`) {
        complete {
          service.rem(a, b)
        }
      }
    }
  }
}

trait HelpRoute extends HttpServiceBase {  this: CalculatorPath =>

  @Path("/help")
  @ApiOperation(
    value = "Returns core information about the services.",
    notes = "xyz notes",
    httpMethod = "GET",
    response = classOf[String]
  )
  def help: Route = get {
    path( basePath / "help") {
      respondWithMediaType(`text/xml`) {
        complete {
          <html>
            <h1>The Calculator service offers five operations:</h1>
            <ul>
              <li>Addition</li>
              <li>Subtraction</li>
              <li>Multiplication</li>
              <li>Division</li>
              <li>Reminder</li>
            </ul>
          </html>
        }
      }
    }
  }

}
