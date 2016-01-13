package pl.witm.service.lower

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import pl.witm.marshalling.Result

object MultiplicationService {
  def create: MultiplicationService = new MultiplicationService
}

class MultiplicationService {

  def mul(a: Int, b: Int): Future[Result] = Future { Result(a * b) }

}
