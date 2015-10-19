package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/19.
 */
class ReverseObjectSupporter(private val o: Any) {
  def ===(p: Parameter) = p.$eq(o)

  def <>(p: Parameter) = p.$ne(o)

  def member(p: ParameterAggregate) = p.reverseMember(o)

  def notMember(p: ParameterAggregate) = p.reverseNotMember(o)
}
