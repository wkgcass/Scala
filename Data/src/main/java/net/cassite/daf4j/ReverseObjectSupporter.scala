package net.cassite.daf4j

/**
 * 提供Any类型 "等于","不等于" 操作, 以及member/notMember操作
 * @param o 包裹的Any对象
 */
class ReverseObjectSupporter(private val o: Any) {
  def ===(p: Parameter) = p.$eq(o)

  def <>(p: Parameter) = p.$ne(o)

  def member(p: ParameterAggregate) = p.reverseMember(o)

  def notMember(p: ParameterAggregate) = p.reverseNotMember(o)
}
