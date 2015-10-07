package net.cassite.autoee.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author wkgcass
 */
class AnyServlet extends HttpServlet {
  protected def doServe(req: HttpServletRequest, res: HttpServletResponse): Unit = {

  }

  protected override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doPost(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doDelete(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doPut(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doHead(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doTrace(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)

  protected override def doOptions(req: HttpServletRequest, resp: HttpServletResponse) = doServe(req, resp)
}