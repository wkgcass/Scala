package net.cassite.daf4j

/**
 * AndOr增强 提供 & 和 | 操作符
 * @param o AndOr的实例
 * @tparam T AndOr的实际类型
 */
class RichAndOr[T <: AndOr](private[daf4j] val o: T) {
  def &(that: Condition) = o.and(that)

  def &(that: And) = o.and(that)

  def &(that: Or) = o.and(that)

  def &(that: ExpressionBoolean) = o.and(that)

  def |(that: Condition) = o.or(that)

  def |(that: And) = o.or(that)

  def |(that: Or) = o.or(that)

  def |(that: ExpressionBoolean) = o.or(that)
}
