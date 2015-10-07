package net.cassite.autoee.page

/**
 * @author wkgcass
 */
class EmptySummary extends Summary {
  def +=(elemID: String, method: net.cassite.autoee.page.event.PageActionMethod, args: String*): Unit = {}
  def list: List[net.cassite.autoee.page.event.PageAction] = Nil
}