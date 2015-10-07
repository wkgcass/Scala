package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class ul extends dom("ul") {

}

/**
 * @author wkgcass
 */
object ul {
  def apply(id: String = null, name: String = null, cls: String = null) = {
    val u = new ul
    u id id
    u name name
    u cls cls
    u
  }
}