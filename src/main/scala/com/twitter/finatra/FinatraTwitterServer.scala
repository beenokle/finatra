package com.twitter.finatra

import com.twitter.app.App
import com.twitter.server.{Stats, Lifecycle, Admin}
import com.twitter.server.{AdminHttpServer => AdmHttpServer}

//Customized TwitterServer Trait
trait FinatraTwitterServer extends App
  with Lifecycle
  with Stats
  with Logging
  with AdmHttpServer
  with Admin

