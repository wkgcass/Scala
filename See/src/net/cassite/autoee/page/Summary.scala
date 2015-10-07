package net.cassite.autoee.page

import net.cassite.autoee.page.event.PageActionMethod
import net.cassite.autoee.page.event.PageAction

/**
 * @author wkgcass
 */
trait Summary {
  def +=(elemID: String, method: PageActionMethod, args: String*): Unit
  def list: List[PageAction]
  override def toString = {
    val sb = new StringBuilder
    sb ++= "dom:["
    var isFirst = true
    list.foreach { a =>
      if (isFirst) {
        isFirst = false
      } else {
        sb ++= ","
      }
      sb ++= a.toString
    }
    sb ++= "]"
    sb.toString
  }
}