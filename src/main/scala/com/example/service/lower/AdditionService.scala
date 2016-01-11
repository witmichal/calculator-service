package com.example.service.lower

import com.example.marshalling.Result

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object AdditionService {
  def create: AdditionService = new AdditionService
}

class AdditionService {
  def add(a: Int, b: Int): Future[Result] = Future { Result(a + b) }
}