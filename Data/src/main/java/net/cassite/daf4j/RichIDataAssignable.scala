package net.cassite.daf4j

/**
 * 提供赋值语句 :=
 * @param data 包裹的IDataAssignable
 * @tparam T 元素类型
 */
class RichIDataAssignable[T](private[daf4j] val data: IDataAssignable[T]) {
  def :=(o: Any) = data.as(o)
}
