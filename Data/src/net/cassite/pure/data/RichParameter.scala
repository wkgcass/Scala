package net.cassite.pure.data

/**
 * 增强Parameter,提供 === 和 <> 运算符
 * @param parameter 包裹的参数
 * @tparam T 参数实际类型
 */
class RichParameter[T <: Parameter](private[data] val parameter: T) {
  def ===(o: Any) = parameter.$eq(o)

  def <>(o: Any) = parameter.$ne(o)
}
