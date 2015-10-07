package net.cassite.autoee.page.event

import com.google.gson.Gson

/**
 * @author wkgcass
 */
class PageAction(
    val elemID: String,
    val method: PageActionMethod,
    val args: Seq[String]) {

  override def toString = {
    val map = new java.util.LinkedHashMap[String, Object]
    map.put("elemID", elemID)
    map.put("method", method)
    val argList = new java.util.ArrayList[String]
    args.foreach { arg => argList.add(arg) }
    map.put("args", argList)
    import net.cassite.autoee.page.event.PageAction._
    gson.toJson(map)
  }
}

/**
 * @author wkgcass
 */
object PageAction {
  val gson = new Gson
}