package net.cassite.daf4j

/**
 * 数字对Parameter进行的运算
 * @param n 包裹的数字对象
 */
class ReverseNumberSupporter(private[daf4j] val n: Comparable[_ <: Number]) {
  def -(p: ParameterComparable[_]) = p.reverseMinus(n)

  def /(p: ParameterComparable[_]) = p.reverseDivide(n)

  def %(p: ParameterComparable[_]) = p.reverseMod(n)
}
