package net.cassite.autoee.servlet

import javax.servlet.http.HttpServletRequest
import net.cassite.autoee.page.DomContainer

/**
 * @author wkgcass
 */
trait ContainerRetriever {
  def apply(req: HttpServletRequest): DomContainer
}