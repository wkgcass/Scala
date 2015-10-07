package net.cassite.autoee

import net.cassite.autoee.servlet.ContainerRetriever
import net.cassite.autoee.page.DomContainer

/**
 * @author wkgcass
 */
object App {
  var containerRetriever: () => ContainerRetriever = _
  var container: () => DomContainer = _
  var emptyContainer: () => DomContainer = _
}