package pl.witm.service.lower

import pl.witm.marshalling.Error
import pl.witm.marshalling.Result

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ReminderService {
  def create: ReminderService = new ReminderService
}
class ReminderService {

  def rem(a: Int, b: Int): Future[Either[Error,Result]] = Future {
    b match {
      case b if b == 0 => Left(Error("Wrong input. $b can not be equal 0."))
      case _ => Right(Result(a % b))
    }
  }

}
