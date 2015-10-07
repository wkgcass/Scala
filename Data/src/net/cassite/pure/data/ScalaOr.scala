package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
class ScalaOr(private[data] val or:Or) {
  def &(c:Condition)=or and c
  def &(c:And)=or and c
  def &(c:Or)=or and c

  def |(c:Condition)=or or c
  def |(c:And)=or or c
  def |(c:Or)=or or c
}
