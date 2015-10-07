package net.cassite.autoee.page.dom

import scala.collection.mutable.ListBuffer
import net.cassite.autoee.page.event.On

/**
 * @author wkgcass
 */

class dom(private val elementName: String) {
  val on = new On(this)
  protected val children = ListBuffer[dom]()
  protected val attrs = scala.collection.mutable.LinkedHashMap[String, String]()
  protected def apply(attrName: String) = attrs.get(attrName);
  def update(name: String, value: String) = {
    if (value != null) {
      attrs(name) = value.trim()
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
      children += d
    }
    this
  }
  def apply(list: DomList) = {
    list.list.foreach { dom => children += dom }
    this
  }

  def cls = apply("class")
  def cls(classes: String) = update("class", classes)
  def name = apply("name")
  def name(nameVal: String) = update("name", nameVal)
  def id = apply("id")
  def id(idVal: String) = update("id", idVal)

  override def toString = {
    val sb = new StringBuilder
    sb ++= "<" ++= elementName
    for ((k, v) <- attrs) {
      sb ++= " " ++= k ++= "=\"" ++= v ++= "\""
    }
    if (children.length == 0)
      sb ++= " />"
    else {
      sb ++= ">"
      children.foreach { child => sb ++= child.toString }
      sb ++= "</" ++= elementName ++= ">"
    }
    sb.toString
  }
}

object dom {
  def apply(elementName: String) = new dom(elementName)
  implicit def typeConvertor(d: dom) = d.children.toList
}