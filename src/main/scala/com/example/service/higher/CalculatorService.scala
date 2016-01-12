package com.example.service.higher

import com.example.core.Config
import com.example.marshalling.Error
import com.example.marshalling.Result
import scala.concurrent.Future
import scalaz.Reader

/**
  * Some kind of higher-order service that's dependent on other - lower-level services.
  */
class CalculatorService {

  def add(a: Int, b: Int): Reader[Config, Future[Result]] = Reader( (config: Config) =>
    config.additionService.add (a,b) )
  def sub(a: Int, b: Int): Reader[Config, Future[Result]] = Reader( (config: Config) =>
    config.subtractionService.sub (a,b) )
  def mul(a: Int, b: Int): Reader[Config, Future[Result]] = Reader( (config: Config) =>
    config.multiplicationService.mul (a,b) )
  def rem(a: Int, b: Int): Reader[Config, Future[Either[Error,Result]]] = Reader( (config: Config) =>
    config.reminderService.rem (a,b) )
  def div(a: Int, b: Int): Reader[Config, Future[Either[Error,Result]]] = Reader( (config: Config) =>
    config.divisionService.div (a,b) )

}
