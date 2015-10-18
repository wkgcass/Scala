package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/17.
 */
class RichParameter[T <: Parameter](private[data] val parameter: T) {
  def ===(o: Any) = parameter.$eq(o)

  def <>(o: Any) = parameter.$ne(o)
}
