package net.cassite.autoee.servlet

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServlet

/**
 * @author wkgcass
 */
abstract class DoAllMethodServlet extends HttpServlet {

  protected def doAll(req: HttpServletRequest, resp: HttpServletResponse): Unit;

  override protected def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doPost(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doPut(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doDelete(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doTrace(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doOptions(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }

  override protected def doHead(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    doAll(req, resp);
  }
}