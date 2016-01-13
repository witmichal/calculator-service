package pl.witm.service.lower

import pl.witm.marshalling.Result

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object AdditionService {
  def create: AdditionService = new AdditionService
}

class AdditionService {
  def add(a: Int, b: Int): Future[Result] = Future { Result(a + b) }
}