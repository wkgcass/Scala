package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
class ReverseOperator(o:Any) {
  def +(param: Parameter)=param.add(o)
  def -(param: Parameter)=param.reverseMinus(o)
  def *(param: Parameter)=param.multi(o)
  def /(param: Parameter)=param.reverseDivide(o)
  def %(param: Parameter)=param.reverseMod(o)
}
