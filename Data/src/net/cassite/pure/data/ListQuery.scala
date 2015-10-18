package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/19.
 */
object ListQuery {
  def apply(name: String) = QueryContainer.getNamedListQuery(name)
}
