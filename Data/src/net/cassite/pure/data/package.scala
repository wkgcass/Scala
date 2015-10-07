package net.cassite.pure

/**
 * Created by wkgcass on 15/10/7.
 */
package object data {
  implicit def toScalaData[T](input:Data[T]):ScalaData[T]=new ScalaData(input)
  implicit def toData[T](input:ScalaData[T]):Data[T]=input.data

  implicit def toScalaExpression[T](input:Expression):ScalaExpression=new ScalaExpression(input)
  implicit def toExpression[T](input:ScalaExpression):Expression=input.expr

  implicit def toScalaCondition(input:Condition):ScalaCondition=new ScalaCondition(input)
  implicit def toCondition(input:ScalaCondition):Condition=input.condition

  implicit def toScalaAnd(input:And):ScalaAnd=new ScalaAnd(input)
  implicit def toAnd(input:ScalaAnd):And=input.and

  implicit def toScalaOr(input:Or):ScalaOr=new ScalaOr(input)
  implicit def toOr(input:ScalaOr):Or=input.or

  implicit def toReverseOperator(input:Any):ReverseOperator=new ReverseOperator(input)
}
