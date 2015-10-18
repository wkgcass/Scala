package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/19.
 */
object UpdateQuery {
  def apply(name: String) = QueryContainer.getNamedUpdateQuery(name)
}
