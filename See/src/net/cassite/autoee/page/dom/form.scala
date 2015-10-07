package net.cassite.autoee.page.dom

/**
 * @author wkgcass
 */
class form extends dom("form") {
  def action(act: String) = update("action", act);
  def method(m: String) = update("method", m)
}

/**
 * @author wkgcass
 */
object form {
  def apply(id: String = null, name: String = null, cls: String = null, action: String = null, method: String = null) = {
    val f = new form
    f id id
    f name name
    f cls cls
    f action action
    f method method
    f
  }
}