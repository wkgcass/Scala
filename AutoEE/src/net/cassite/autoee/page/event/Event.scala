package net.cassite.autoee.page.event;

/**
 * @author wkgcass
 */
class Event(val typ: EventType, val method: EventMethod) {

}

/**
 * @author wkgcass
 */
object Event {
  def apply(typ: EventType = EventType.ajax, method: EventMethod = EventMethod.get) = new Event(typ, method)
}