package net.cassite.pure

/**
 * 提供必要的隐式转换和简化操作
 */
package object data {
  implicit def paramCompToRich[T <: Comparable[T]](p: ParameterComparable[T]): RichParameterComparable[T] = new RichParameterComparable[T](p)

  implicit def richToParamComp[T <: Comparable[T]](r: RichParameterComparable[T]): ParameterComparable[T] = r.parameter

  implicit def parameterToRich[T <: Parameter](p: T): RichParameter[T] = new RichParameter[T](p)

  implicit def richToParameter[T <: Parameter](r: RichParameter[T]): T = r.parameter

  implicit def dataAssignToRich[T](a: IDataAssignable[T]): RichIDataAssignable[T] = new RichIDataAssignable[T](a)

  implicit def richToDataAssign[T](r: RichIDataAssignable[T]): IDataAssignable[T] = r.data

  implicit def andOrTORich[T <: AndOr](ao: T): RichAndOr[T] = new RichAndOr[T](ao)

  implicit def richToAndOr[T <: AndOr](r: RichAndOr[T]): T = r.o

  implicit def compToReverseSup(c: Comparable[_ <: Number]): ReverseComparableNumSupporter = new ReverseComparableNumSupporter(c)

  def top(i: Int) = new QueryParameter().top(i)

  def limit(start: Int, end: Int) = new QueryParameter().limit(start, end)

  def orderBy(base: OrderBase*) = new QueryParameter().orderBy(base: _*)

  val all: Where = null
}
