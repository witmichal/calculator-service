package pl.witm.core

import pl.witm.service.higher.CalculatorService
import pl.witm.service.lower._
import scaldi.{Injectable, Module}

trait CoreServices extends Injectable {

  class DiModule extends Module {
    bind[DivisionService] to injected [DivisionService]
    bind[AdditionService] to injected [AdditionService]
    bind[SubtractionService] to injected [SubtractionService]
    bind[MultiplicationService] to injected [MultiplicationService]
    bind[ReminderService] to injected [ReminderService]
    bind[CalculatorService] to injected [CalculatorService]
  }

  implicit val injector = new DiModule

  val calculatorService = inject[CalculatorService]

}

