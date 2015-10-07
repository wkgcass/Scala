package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class script extends dom("script") {
}

/**
 * @author wkgcass
 */
object script {
  def apply() = new script
}

/**
 * @author wkgcass
 */
object js {
  def apply(src: String = null) = {
    val s = script()
    s("type") = "text/javascript"
    if (src != null)
      s("src") = src
    s
  }
}