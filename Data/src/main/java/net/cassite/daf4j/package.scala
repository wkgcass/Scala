package net.cassite

import net.cassite.daf4j.util.Selectable

import scala.collection.mutable.ListBuffer

/**
 * 提供必要的隐式转换和简化操作
 */
package object daf4j {
  implicit def paramCompToRich[T <: Comparable[T]](p: ParameterComparable[T]): RichParameterComparable[T] = new RichParameterComparable[T](p)

  implicit def richToParamComp[T <: Comparable[T]](r: RichParameterComparable[T]): ParameterComparable[T] = r.parameter

  implicit def parameterToRich[T <: Parameter](p: T): RichParameter[T] = new RichParameter[T](p)

  implicit def richToParameter[T <: Parameter](r: RichParameter[T]): T = r.parameter

  implicit def dataAssignToRich[T](a: IDataAssignable[T]): RichIDataAssignable[T] = new RichIDataAssignable[T](a)

  implicit def richToDataAssign[T](r: RichIDataAssignable[T]): IDataAssignable[T] = r.data

  implicit def andOrTORich[T <: AndOr](ao: T): RichAndOr[T] = new RichAndOr[T](ao)

  implicit def richToAndOr[T <: AndOr](r: RichAndOr[T]): T = r.o

  implicit def compToReverseSup(c: Comparable[_ <: Number]): ReverseComparableNumSupporter = new ReverseComparableNumSupporter(c)

  implicit def preresToJList[E](pre: PreResult[E]): java.util.List[E] = pre.list()

  implicit def preresToSList[E](pre: PreResult[E]): List[E] = {
    val ls = pre.list()
    val buf = new ListBuffer[E]
    for (i <- 0 until ls.size()) {
      buf += ls.get(i)
    }
    buf.toList
  }

  implicit def tuple2Focus(tuple2: (Selectable, String)): Focus = new Focus().focus(tuple2._1, tuple2._2)

  implicit def tuple2RichFocus(tuple2: (Selectable, String)): RichFocus = new RichFocus(new Focus().focus(tuple2._1, tuple2._2))

  implicit def dataToFocus(d: IData[_]): Focus = new Focus().focus(d)

  implicit def dataToRichFocus(d: IData[_]): RichFocus = new RichFocus(new Focus().focus(d))

  implicit def focusToRich(focus: Focus): RichFocus = new RichFocus(focus)

  implicit def richToFocus(rich: RichFocus): Focus = rich.focus

  def top(i: Int) = new QueryParameter().top(i)

  def limit(start: Int, end: Int) = new QueryParameter().limit(start, end)

  def orderBy(base: OrderBase*) = new QueryParameter().orderBy(base: _*)

  def focus(d: IData[_]) = new Focus().focus(d)

  def focus(d: IData[_], alias: String) = new Focus().focus(d, alias)

  val all: Where = null

}
