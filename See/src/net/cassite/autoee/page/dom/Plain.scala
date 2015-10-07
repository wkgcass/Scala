package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class Plain(private val text: String) extends dom("") {
  override def toString() = text
}

object Plain {
  def apply(text: String) = new Plain(text)
}