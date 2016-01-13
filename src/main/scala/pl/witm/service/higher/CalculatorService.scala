package pl.witm.service.higher

import pl.witm.marshalling.Error
import pl.witm.marshalling.Result
import pl.witm.service.lower._
import scala.concurrent.Future

/**
  * Some kind of higher-order service that's dependent on other - lower-level services.
  */
class CalculatorService(
                         additionService: AdditionService,
                         divisionService: DivisionService,
                         multiplicationService: MultiplicationService,
                         reminderService: ReminderService,
                         subtractionService: SubtractionService
                       ) {

  def add(a: Int, b: Int): Future[Result] = additionService.add (a,b)
  def sub(a: Int, b: Int): Future[Result] = subtractionService.sub (a,b)
  def mul(a: Int, b: Int): Future[Result] = multiplicationService.mul (a,b)
  def rem(a: Int, b: Int): Future[Either[Error,Result]] = reminderService.rem (a,b)
  def div(a: Int, b: Int): Future[Either[Error,Result]] = divisionService.div (a,b)

}
