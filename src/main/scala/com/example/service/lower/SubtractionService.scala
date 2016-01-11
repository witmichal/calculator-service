package com.example.service.lower

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import com.example.marshalling.Result

object SubtractionService {
  def create: SubtractionService = new SubtractionService
}

class SubtractionService {
  def sub(a: Int, b: Int): Future[Result] = Future { Result(a - b) }

}
