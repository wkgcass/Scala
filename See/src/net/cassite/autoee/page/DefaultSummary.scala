package net.cassite.autoee.page

import net.cassite.autoee.page.event.PageAction
import net.cassite.autoee.page.event.PageActionMethod

/**
 * @author wkgcass
 */
class DefaultSummary extends Summary {
  val actions = new scala.collection.mutable.ListBuffer[PageAction]

  override def +=(elemID: String, method: PageActionMethod, args: String*) {
    actions += new PageAction(elemID, method, args)
  }

  override def list() = actions.toList
}