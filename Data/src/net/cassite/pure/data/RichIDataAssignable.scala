package net.cassite.pure.data

/**
 * Created by wkgcass on 15/10/19.
 */
class RichIDataAssignable[T](private[data] val data: IDataAssignable[T]) {
  def :=(o: Any) = data.as(o)
}
