package test

import net.cassite.autoee.page.dom._
import net.cassite.autoee.page.event._

/**
 * @author wkgcass
 */
object TestG {
  def main(args: Array[String]): Unit = {
    println {
      html() {
        head() {
          css("bootstrap.css") +
            js("jquery.min.js")
        } +
          body() {
            div(cls = "container", id = "xyz") {
              "abc" ::
                form(action = "login.do") {
                  input.text(name = "name", value = "123") +
                    br() +
                    input.submit(id = "sbmt") +
                    (a(href = "a").on("click") = Event())
                }
            }
          }
      }
    }
  }
}