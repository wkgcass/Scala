package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
object Param {
  def apply() = new QueryParameter

  def limit(start: Int, end: Int) = new QueryParameter().limit(start, end)

  def orderBy(order: OrderBase*) = new QueryParameter().orderBy(order.toArray: _*)

  def top(i: Int) = new QueryParameter().top(i)
}
