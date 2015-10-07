package net.cassite.autoee.page.event;

import net.cassite.autoee.page.dom._
import net.cassite.autoee.page.DomContainer

/**
 * @author wkgcass
 */
class On(val dom: dom) {
  private val eventMap = new scala.collection.mutable.HashMap[String, (DomContainer) => Unit]
  def apply(event: String)(func: (DomContainer) => Unit) = {
    eventMap(event) = func
    dom
  }
}