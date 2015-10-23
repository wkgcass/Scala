package net.cassite.pure.data

/**
 * 增强ParameterComparable,提供 < > >= <= + - * / % 取负运算
 * @param parameter 包裹的参数对象
 * @tparam T 参数的Comparable类型
 */
class RichParameterComparable[T <: Comparable[T]](private[data] val parameter: ParameterComparable[T]) {
  def <(o: Comparable[_]) = parameter.$lt(o)

  def >(o: Comparable[_]) = parameter.$gt(o)

  def <=(o: Comparable[_]) = parameter.$le(o)

  def >=(o: Comparable[_]) = parameter.$ge(o)

  def +(o: Comparable[_ <: Number]) = parameter.add(o)

  def -(o: Comparable[_ <: Number]) = parameter.minus(o)

  def *(o: Comparable[_ <: Number]) = parameter.multi(o)

  def /(o: Comparable[_ <: Number]) = parameter.divide(o)

  def %(o: Comparable[_ <: Number]) = parameter.mod(o)

  def unary_-() = parameter.unary_negative()
}
