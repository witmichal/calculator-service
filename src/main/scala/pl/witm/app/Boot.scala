package pl.witm.app

import pl.witm.api.Api
import pl.witm.core.CoreServices
import pl.witm.web.Web

object Boot extends App with CoreServices with Api with BootedCore with Web