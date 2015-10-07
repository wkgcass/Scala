package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
class ScalaCondition(private[data] val condition:Condition) {
  def &(c:Condition)=condition and c
  def &(c:And)=condition and c
  def &(c:Or)=condition and c

  def |(c:Condition)=condition or c
  def |(c:And)=condition or c
  def |(c:Or)=condition or c
}
