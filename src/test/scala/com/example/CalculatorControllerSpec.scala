package com.example

import com.example.api.Api
import com.example.app.{Core}
import com.example.core.CoreServices
import com.example.web.Web
import org.scalatest.{Matchers, FlatSpec}
import spray.testkit.{ScalatestRouteTest}

class CalculatorControllerSpec extends FlatSpec with Matchers with ScalatestRouteTest
  with CoreServices with Api with Core with Web {

  def actorRefFactory = system

  "CalculatorController" should "return JSON containing result of addition operation" in {
    Post("/calc/add/13/2") ~> routes ~> check {
      responseAs[String] should include(""" "value": 15""")
    }
  }

  it should "return JSON containing result of subtraction operation" in {
    Post("/calc/sub/13/2") ~> routes ~> check {
      responseAs[String] should include(""" "value": 11""")
    }
  }

  it should "return JSON containing result of multiplication operation" in {
    Post("/calc/mul/13/2") ~> routes ~> check {
      responseAs[String] should include(""" "value": 26""")
    }
  }

  it should "return JSON containing result of division operation" in {
    Post("/calc/div/13/2") ~> routes ~> check {
      responseAs[String] should include(""" "value": 6""")
    }
  }

  it should "return JSON containing result of reminder operation" in {
    Post("/calc/rem/13/2") ~> routes ~> check {
      responseAs[String] should include(""" "value": 1""")
    }
  }

  it should "display help information" in {
    Get("/calc/help") ~> routes ~> check {
      responseAs[String] should include("""The Calculator service""")
    }
  }

}