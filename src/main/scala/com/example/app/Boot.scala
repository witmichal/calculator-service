package com.example.app

import com.example.api.Api
import com.example.core.CoreServices
import com.example.web.Web

object Boot extends App with CoreServices with Api with BootedCore with Web