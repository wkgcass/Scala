package net.cassite.autoee.page.event

import net.cassite.autoee.page.dom._
import net.cassite.autoee.page.Summary

/**
 * @author wkgcass
 */
class PageDomList(private val parent: PageDom) {
  private[event] val doms = new scala.collection.mutable.ListBuffer[PageDom]
  private var summary: Summary = _

  def +(node: dom) = {
    doms.last + node
    this
  }
  def ::(node: dom) = {
    node :: doms(0)
    this
  }
  def -(index: Int) = {
    this.doms(index).remove()
    this
  }
  private[event] def addNode(node: PageDom) {
    doms += node
  }
  private[event] def setSummary(summary: Summary) {
    this.summary = summary
    this.doms.foreach { d => d.setSummary(summary) }
  }
}