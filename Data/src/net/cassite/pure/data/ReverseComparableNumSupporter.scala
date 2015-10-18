package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/17.
 */
class ReverseComparableNumSupporter(private[data] val c: Comparable[_ <: Number]) {
  def -(p: ParameterComparable[_]) = p.reverseMinus(c)

  def /(p: ParameterComparable[_]) = p.reverseDivide(c)

  def %(p: ParameterComparable[_]) = p.reverseMod(c)
}
