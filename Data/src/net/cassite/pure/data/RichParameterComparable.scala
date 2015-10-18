package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/17.
 */
class RichParameterComparable[T <: Comparable[T]](private[data] val parameter: ParameterComparable[T]) {
  def <(o: Comparable[_]) = parameter.$lt(o)

  def >(o: Comparable[_]) = parameter.$gt(o)

  def <=(o: Comparable[_]) = parameter.$le(o)

  def >=(o: Comparable[_]) = parameter.$ge(o)

  def +(o: Comparable[_ <: Number]) = parameter.add(o)

  def +(o: Number) = parameter.add(o)

  def -(o: Comparable[_ <: Number]) = parameter.minus(o)

  def -(o: Number) = parameter.minus(o)

  def *(o: Comparable[_ <: Number]) = parameter.multi(o)

  def *(o: Number) = parameter.multi(o)

  def /(o: Comparable[_ <: Number]) = parameter.divide(o)

  def /(o: Number) = parameter.divide(o)

  def %(o: Comparable[_ <: Number]) = parameter.mod(o)

  def %(o: Number) = parameter.mod(o)

  def unary_-() = parameter.unary_negative()
}
