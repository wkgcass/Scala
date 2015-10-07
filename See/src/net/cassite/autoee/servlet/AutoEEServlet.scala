package net.cassite.autoee.servlet

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.google.gson.Gson
import net.cassite.autoee.page.event.PageDom
import java.security.DomainCombiner
import javax.servlet.ServletConfig
import net.cassite.autoee.App

/**
 * @author wkgcass
 */
class AutoEEServlet() extends DoAllMethodServlet {
  protected var containerRetriever: ContainerRetriever = _

  override def init(config: ServletConfig): Unit = {
    super.init(config)
    containerRetriever = App.containerRetriever()
  }

  override protected def doAll(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val elemID = req.getParameter("elemID");
    val event = req.getParameter("event");
    val container = containerRetriever(req)

  }
}