package net.cassite.autoee.servlet

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author wkgcass
 */
class HttpArgsBuilder(val req: HttpServletRequest, val res: HttpServletResponse) {
  private val args = new scala.collection.mutable.HashMap[String, Any]
  def apply(argKey: String) = args(argKey)
  def update(argKey: String, argVal: Any): Unit = args(argKey) = argVal
}