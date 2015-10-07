package net.cassite.autoee.page.event;

import net.cassite.autoee.page.dom._;

/**
 * @author wkgcass
 */
class On(val dom: dom) {
  private val eventMap = new scala.collection.mutable.HashMap[String, Event]
  def update(event: String, eventToDo: Event) = {
    eventMap(event) = eventToDo
    dom
  }
  def apply(event: String) = eventMap(event)
}

/**
 * @author wkgcass
 */
object On {
  implicit def typeConvertor(on: On) = on.eventMap.toMap
}