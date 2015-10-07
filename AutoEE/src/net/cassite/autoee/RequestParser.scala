package net.cassite.autoee

import net.cassite.autoee.servlet.HttpArgs

/**
 * @author wkgcass
 */
trait RequestParser {
  def apply(args: HttpArgs): HttpArgs
}