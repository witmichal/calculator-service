package pl.witm.service.lower

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import pl.witm.marshalling.Result

object SubtractionService {
  def create: SubtractionService = new SubtractionService
}

class SubtractionService {
  def sub(a: Int, b: Int): Future[Result] = Future { Result(a - b) }

}
