package net.cassite.autoee.page

import javax.servlet.http.HttpServletRequest
import net.cassite.autoee.page.event.PageDom

/**
 * @author wkgcass
 */
abstract class DomContainer(
    map: Map[String, PageDom]) {
  def apply(alias: String): PageDom
}