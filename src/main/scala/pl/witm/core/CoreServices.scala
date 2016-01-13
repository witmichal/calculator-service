package pl.witm.core

import pl.witm.service.higher.CalculatorService
import pl.witm.service.lower._

trait CoreServices {

  private val divisionService = DivisionService.create
  private val multiplicationService = MultiplicationService.create
  private val reminderService = ReminderService.create
  private val subtractionService = SubtractionService.create
  private val additionService = AdditionService.create

  val calculatorService = new CalculatorService(
    additionService: AdditionService,
    divisionService: DivisionService,
    multiplicationService: MultiplicationService,
    reminderService: ReminderService,
    subtractionService: SubtractionService
  )

}

