package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/17.
 */
class RichAndOr[T <: AndOr](private[data] val o: T) {
  def &(that: Condition) = o.and(that)

  def &(that: And) = o.and(that)

  def &(that: Or) = o.and(that)

  def &(that: ExpressionBoolean) = o.and(that)

  def |(that: Condition) = o.or(that)

  def |(that: And) = o.or(that)

  def |(that: Or) = o.or(that)

  def |(that: ExpressionBoolean) = o.or(that)
}
