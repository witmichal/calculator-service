package com.example.api

import com.example.core.Config
import spray.routing.HttpService

abstract class InjectedHttpService(val conf: Config) extends HttpService {
  val config = conf
}

