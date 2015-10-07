package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
class ScalaAnd(private[data] val and:And) {
  def &(c:And)=and and c
  def &(c:Or)=and and c
  def &(c:Condition)=and and c

  def |(c:And)=and or c
  def |(c:Or)=and or c
  def |(c:Condition)=and or c
}
