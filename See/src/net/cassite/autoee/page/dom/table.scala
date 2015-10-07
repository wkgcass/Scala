package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class table extends dom("table") {

}

/**
 * @author wkgcass
 */
object table {
  def apply(id: String = null, name: String = null, cls: String = null) = {
    val t = new table
    t id id
    t name name
    t cls cls
    t
  }
}