package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class a extends dom("a") {
  def href(h: String) = update("href", h)
}

/**
 * @author wkgcass
 */
object a {
  def apply(id: String = null, name: String = null, cls: String = null, href: String = null) = {
    val a = new a
    a id id
    a name name
    a cls cls
    a href href
    a
  }
}