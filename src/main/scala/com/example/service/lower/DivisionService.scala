package com.example.service.lower

import com.example.marshalling.{Result, Error}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object DivisionService {
  def create: DivisionService = new DivisionService
}

class DivisionService {

  def div(a: Int, b: Int) : Future[Either[Error,Result]] = Future {
    b match {
      case b if b == 0 => Left(Error("Wrong input. $b can not be equal 0."))
      case _ => Right(Result(a / b))
    }
  }

}
