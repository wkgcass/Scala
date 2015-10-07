package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class textarea extends dom("textarea") {

}

/**
 * @author wkgcass
 */
object textarea {
  def apply(id: String = null, name: String = null, cls: String = null, innerHTML: String = null) = {
    val t = new textarea
    t id id
    t name name
    t cls cls
    t {
      Plain(innerHTML)
    }
    t
  }
}