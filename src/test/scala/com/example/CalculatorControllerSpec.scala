package com.example

import com.example.api.Api
import com.example.app.{Core}
import com.example.core.CoreServices
import com.example.web.Web
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class CalculatorControllerSpec extends Specification with Specs2RouteTest
  with CoreServices with Api with Core with Web {

  def actorRefFactory = system

  "CalculatorController" should {

    "return JSON containing result of addition operation" in {
      Post("/calc/add/13/2") ~> routes ~> check {
        responseAs[String] must contain(""" "value": 15""")
      }
    }

    "return JSON containing result of subtraction operation" in {
      Post("/calc/sub/13/2") ~> routes ~> check {
        responseAs[String] must contain(""" "value": 11""")
      }
    }

    "return JSON containing result of multiplication operation" in {
      Post("/calc/mul/13/2") ~> routes ~> check {
        responseAs[String] must contain(""" "value": 26""")
      }
    }

    "return JSON containing result of division operation" in {
      Post("/calc/div/13/2") ~> routes ~> check {
        responseAs[String] must contain(""" "value": 6""")
      }
    }

    "return JSON containing result of reminder operation" in {
      Post("/calc/rem/13/2") ~> routes ~> check {
        responseAs[String] must contain(""" "value": 1""")
      }
    }

    "display help information" in {
      Get("/calc/help") ~> routes ~> check {
        responseAs[String] must contain("""The Calculator service""")
      }
    }

  }
}