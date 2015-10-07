package net.cassite.autoee.page.dom

import scala.collection.mutable.ListBuffer

/**
 * @author wkgcass
 */
protected class DomList {
  val list = ListBuffer[dom]()
  def +(dom: dom) = {
    list.append(dom)
    this
  }

  def +(plainText: String) = {
    list.append(Plain(plainText))
    this
  }
}