package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class div extends dom("div") {

}

/**
 * @author wkgcass
 */
object div {
  def apply(id: String = null, cls: String = null, name: String = null) = {
    val d = new div
    d id id
    d cls cls
    d name name
    d
  }
}