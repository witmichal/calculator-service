package com.example.core

import com.example.service.higher.CalculatorService
import com.example.service.lower._

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

