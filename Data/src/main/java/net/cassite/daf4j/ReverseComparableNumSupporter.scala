package net.cassite.daf4j

/**
 * 提供Number子类 - / % 运算符
 * @param c 包裹着的Number对象
 */
class ReverseComparableNumSupporter(private[daf4j] val c: Comparable[_ <: Number]) {
  def -(p: ParameterComparable[_]) = p.reverseMinus(c)

  def /(p: ParameterComparable[_]) = p.reverseDivide(c)

  def %(p: ParameterComparable[_]) = p.reverseMod(c)
}
