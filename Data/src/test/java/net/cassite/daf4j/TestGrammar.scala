package net.cassite.daf4j

/**
 * Created by wkgcass on 15/10/28.
 */
object TestGrammar {
  def main(args: Array[String]): Unit = {
    val entity = new Entity
    val query = new Query(new DataAccess {
      override def update(o: scala.Any, where: Where, updateEntries: Array[UpdateEntry]): Unit = {}

      override def projection(o: scala.Any, where: Where, queryParameterWithFocus: QueryParameterWithFocus): java.util.List[java.util.Map[String, AnyRef]] = null

      override def remove(o: scala.Any, where: Where): Unit = {}

      override def list[En](en: En, where: Where, queryParameter: QueryParameter): java.util.List[En] = null

      override def save(objects: Array[AnyRef]): Unit = {}

      override def find[En](aClass: Class[En], o: scala.Any): En = aClass.newInstance()
    })
    import entity._
    query from entity where age > 18 & id <> 1 param (orderBy(name.desc) top 1) list

    query from entity where age > 18 & id <> 1 param (orderBy(name.desc) top 1) select id +(name, "a")

    query stream entity filter age > 18 & id <> 1 sort (name desc) limit 5 list

    query stream entity filter age > 18 & id <> 1 sort (name desc) limit 5 map id +(name, "a") list
  }
}
