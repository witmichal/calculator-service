package com.example.core

import com.example.service.higher.CalculatorService
import com.example.service.lower._

trait CoreServices {

  private val divisionService = DivisionService.create
  private val reminderService = ReminderService.create

  val calculatorService = new CalculatorService(
    divisionService: DivisionService,
    reminderService: ReminderService
  )

}

trait Config {
  def additionService: AdditionService
  def subtractionService: SubtractionService
  def multiplicationService: MultiplicationService
}

object SimpleConfig extends Config {
  override def additionService = AdditionService.create
  override def subtractionService = SubtractionService.create
  override def multiplicationService: MultiplicationService = MultiplicationService.create
}
