package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class SelfClose(elementName: String) extends dom(elementName) {
  override def toString() = {
    val sb = new StringBuilder
    sb ++= "<" ++= elementName
    for ((k, v) <- attrs) {
      sb ++= " " ++= k ++= "=\"" ++= v ++= "\""
    }
    sb ++= ">"
    sb.toString
  }
}