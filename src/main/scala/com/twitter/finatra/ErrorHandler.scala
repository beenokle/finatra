package com.twitter.finatra

import com.twitter.app.App

object ErrorHandler extends App with Logging {

  def apply(request: Request, e: Throwable, controllers: ControllerCollection) = {
    log.error(e, s"Internal Server Error with message ${e.getMessage}", Nil)
    request.error = Some(e)
    ResponseAdapter(request, controllers.errorHandler(request))
  }

}
