package net.cassite.autoee.page.dom

import scala.collection.mutable.ListBuffer
import net.cassite.autoee.page.event.On
import net.cassite.autoee.page.event.PageDom

/**
 * @author wkgcass
 */

class dom(private val elementName: String) {
  val on = new On(this)
  protected val childrenList = ListBuffer[dom]()
  protected val attrMap = scala.collection.mutable.LinkedHashMap[String, String]()
  protected def apply(attrName: String) = attrMap.get(attrName);
  def update(name: String, value: String) = {
    if (value != null) {
      attrMap(name) = value.trim()
    }
    this
  }
  def +(that: dom) = {
    val list = new DomList
    list + this
    list + that
    list
  }
  def +(plainText: String) = {
    val list = new DomList
    list + this
    list + plainText
    list
  }
  def ::(plainText: String) = {
    val list = new DomList
    list + plainText
    list + this
    list
  }
  def apply(d: dom) = {
    if (!d.isInstanceOf[Plain] || (d.toString() != null && d.toString() != "")) {
      childrenList += d
    }
    this
  }
  def apply(list: DomList) = {
    list.list.foreach { dom => childrenList += dom }
    this
  }

  def cls = apply("class")
  def cls(classes: String) = update("class", classes)
  def name = apply("name")
  def name(nameVal: String) = update("name", nameVal)
  def id = apply("id")
  def id(idVal: String) = update("id", idVal)

  def children = childrenList.toList
  def attrs = attrMap

  override def toString = {
    val sb = new StringBuilder
    sb ++= "<" ++= elementName
    for ((k, v) <- attrMap) {
      sb ++= " " ++= k ++= "=\"" ++= v ++= "\""
    }
    if (childrenList.length == 0)
      sb ++= " />"
    else {
      sb ++= ">"
      childrenList.foreach { child => sb ++= child.toString }
      sb ++= "</" ++= elementName ++= ">"
    }
    sb.toString
  }
}

object dom {
  def apply(elementName: String) = new dom(elementName)
}