package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/17.
 */
class ReverseNumberSupporter(private[data] val n: Comparable[_ <: Number]) {
  def -(p: ParameterComparable[_]) = p.reverseMinus(n)

  def /(p: ParameterComparable[_]) = p.reverseDivide(n)

  def %(p: ParameterComparable[_]) = p.reverseMod(n)
}
