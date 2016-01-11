package com.example.marshalling

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import spray.json.DefaultJsonProtocol._

object ResponseJsonProtocol extends DefaultJsonProtocol {
  implicit val resultFormat = jsonFormat1(Result)
}

case class Result(value: Int)
case class Error(message: String)
object Error {
  implicit def userJsonFormat: RootJsonFormat[Error] = jsonFormat1(Error.apply)
}