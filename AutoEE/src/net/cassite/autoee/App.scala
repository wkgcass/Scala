package net.cassite.autoee

import net.cassite.autoee.servlet.Router
import net.cassite.autoee.servlet.Router

/**
 * @author wkgcass
 */
class App {
  private val plugins = new scala.collection.mutable.ListBuffer[RequestParser];
  private val routers = new scala.collection.mutable.LinkedHashMap[String, Router]

  def apply(reqParser: RequestParser): Unit = {
    plugins += reqParser
  }

  def apply(route: String, router: Router): Unit = {
    routers(route) = router
  }
}