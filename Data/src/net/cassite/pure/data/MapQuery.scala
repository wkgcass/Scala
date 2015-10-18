package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/19.
 */
object MapQuery {
  def apply(name: String) = QueryContainer.getNamedMapQuery(name)
}
