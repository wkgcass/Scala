package net.cassite.autoee.page.event

import net.cassite.autoee.page.dom.dom
import net.cassite.autoee.page.Summary

/**
 * @author wkgcass
 */
class PageDom(val d: dom, parent: PageDom) {

  var childrenList = new PageDomList(this)
  private val attr = new scala.collection.mutable.LinkedHashMap[String, String]

  private var summary: Summary = null
  private[event] def setSummary(summary: Summary) {
    this.summary = summary
    this.childrenList.setSummary(summary)
  }

  def apply(key: String) = attr(key)
  def update(key: String, value: String) = {
    attr(key) = value
    this.summary += (apply("elemID"), PageActionMethod.attr, key, value)
    this
  }
  def empty() = {
    childrenList = new PageDomList(this)
    summary += (apply("elemID"), PageActionMethod.empty)
    this
  }
  def remove() {
    parent.children.doms.-=(this)
    summary += (apply("elemID"), PageActionMethod.remove)
  }
  def removeAttr(key: String) = {
    if (attr.contains(key)) {
      attr.remove(key)
      summary += (apply("elemID"), PageActionMethod.removeAttr)
    }
    this
  }
  def +(node: dom) = {
    val built = PageDom(node, parent)
    parent.children.doms.insert(parent.children.doms.indexOf(this), built)
    summary += (apply("elemID"), PageActionMethod.after, built.toString)
    this
  }
  def ::(node: dom) = {
    val built = PageDom(node, parent)
    parent.children.doms.insert(parent.children.doms.indexOf(this), built)
    summary += (apply("elemID"), PageActionMethod.before, built.toString)
    this
  }
  def html(node: dom) = {
    this.childrenList = new PageDomList(this)
    this.childrenList.addNode(PageDom(node, this))
    this.summary += (apply("elemID"), PageActionMethod.html, childrenList.toString)
    this
  }
  def html(plain: String) = {
    this.childrenList = new PageDomList(this)
    this.childrenList.addNode(PageDom(plain, this))
    this.summary += (apply("elemID"), PageActionMethod.html, childrenList.toString)
    this
  }

  def children = { childrenList }
  def attrs = attr.toMap

  override def toString = this.d.toString
}

/**
 * @author wkgcass
 */
object PageDom {
  def apply(d: dom, parent: PageDom): PageDom = {
    d("elemID") = d.hashCode.toString
    val built = new PageDom(d, parent)
    d.children.foreach {
      child =>
        built.childrenList.addNode(PageDom(child, built))
    }
    for ((k, v) <- d.attrs) {
      built.attr(k) = v
    }
    built
  }
  def apply(text: String, parent: PageDom) = new PlainPageDom(text, parent)
}