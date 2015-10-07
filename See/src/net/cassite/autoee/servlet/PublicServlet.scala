package net.cassite.autoee.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import net.cassite.autoee.App
import javax.servlet.ServletConfig
import scala.util.control.Breaks._
import java.io.FileInputStream
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.File

/**
 * @author wkgcass
 */
class PublicServlet extends DoAllMethodServlet {

  private val cache = new scala.collection.mutable.HashMap[String, Array[Byte]]

  protected var publicPath = ""

  override def init(config: ServletConfig): Unit = {
    super.init(config);
    this.publicPath = this.getServletContext.getRealPath("/") + "/" + config.getInitParameter("public-path");
    if (!this.publicPath.endsWith("/")) {
      this.publicPath += "/"
    }
  }

  override protected def doAll(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val uri = req.getRequestURI()
    val resource = if (uri.endsWith("/")) {
      uri.substring(uri.substring(0, uri.length() - 1).lastIndexOf("/") + 1);
    } else if (uri.contains("?")) {
      uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("?"))
    } else {
      uri.substring(uri.lastIndexOf("/") + 1)
    }

    try {
      val bytes = if (cache.contains(resource)) {
        cache(resource)
      } else {
        val file = new File(publicPath + resource)
        val arr = new Array[Byte](file.length.toInt)
        val in = new FileInputStream(publicPath + resource)
        in.read(arr)
        cache(resource) = arr
        arr
      }
      resp.getOutputStream.write(bytes)
    } catch {
      case ex: FileNotFoundException => {
        resp.setStatus(404)
      }
    }
    resp.getOutputStream.flush()

  }
}