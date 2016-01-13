package pl.witm.core

import pl.witm.service.higher.CalculatorService
import pl.witm.service.lower._
import com.google.inject.{Guice, AbstractModule}
import net.codingwell.scalaguice.ScalaModule
import net.codingwell.scalaguice.InjectorExtensions._

trait CoreServices {

  class DiModule extends AbstractModule with ScalaModule {
    def configure = {
      bind[DivisionService]
      bind[AdditionService]
      bind[SubtractionService]
      bind[MultiplicationService]
      bind[ReminderService]
      bind[CalculatorService]
    }
  }

  val injector = Guice.createInjector(new DiModule)

  val calculatorService = injector.instance[CalculatorService]


}

