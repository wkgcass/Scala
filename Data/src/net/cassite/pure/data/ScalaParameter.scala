package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/7.
 */
abstract class ScalaParameter(param: Parameter) {
  // conditions
  def >(o: Any) = param.$gt(o)

  def <(o: Any) = param.$lt(o)

  def ===(o: Any) = param.$eq(o)

  def !==(o: Any) = param.$ne(o)

  def <=(o: Any) = param.$le(o)

  def >=(o: Any) = param.$ge(o)

  // operators

  def %(o: Any) = param.mod(o)

  def +(o: Any) = param.add(o)

  def -(o: Any) = param.minus(o)

  def *(o: Any) = param.multi(o)

  def /(o: Any) = param.divide(o)
}
