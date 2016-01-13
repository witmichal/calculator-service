package pl.witm.core

import pl.witm.service.higher.CalculatorService
import pl.witm.service.lower._

trait CoreServices {
  val calculatorService = new CalculatorService
}

trait Config {
  def additionService: AdditionService
  def subtractionService: SubtractionService
  def multiplicationService: MultiplicationService
  def divisionService: DivisionService
  def reminderService: ReminderService
}

object SimpleConfig extends Config {
  override def additionService = AdditionService.create
  override def subtractionService = SubtractionService.create
  override def multiplicationService = MultiplicationService.create
  override def divisionService = DivisionService.create
  override def reminderService = ReminderService.create
}
