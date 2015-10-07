package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class link extends dom("link") {
}

/**
 * @author wkgcass
 */
object link {
  def apply() = new link
}

/**
 * @author wkgcass
 */
object css {
  def apply(url: String) = {
    val l = link()
    l("rel") = "stylesheet"
    l("type") = "text/css"
    l("href") = url
    l
  }
}