package com.example.service.lower

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import com.example.marshalling.Result

object MultiplicationService {
  def create: MultiplicationService = new MultiplicationService
}

class MultiplicationService {

  def mul(a: Int, b: Int): Future[Result] = Future { Result(a * b) }

}
