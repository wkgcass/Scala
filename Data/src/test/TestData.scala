package test

import java.util

import net.cassite.pure.data._

/**
 * Created by wkgcass on 15/10/7.
 */
object TestData {
  def main(args: Array[String]): Unit = {
    val query: Query = new Query(new DA)
    val user = new User

    import user._
    val result = query from user where id < 123 & age > 18 list()

    import Functions._
    import Param._

    val res2 = query from user where sum(id) > 0 & (id + age !== 1) list()

    val res3 = query from user where {
      sum(id) + age > 1 - name & (id + age === 1)
    } list {
      limit(1, 2) orderBy name.desc
    }

    val res4 = (query from user where sum(id) + age > 1 - name & (id + age === 1)) list top(10)

  }
}

class DA extends DataAccess {
  override def list[En](entityClass: Class[En], whereClause: Where): util.List[En] = null

  override def list[En](entityClass: Class[En], whereClause: Where, parameter: QueryParameter): util.List[En] = null
}

class User {
  val id: Data[Integer] = new Data(null, this)
  val name: Data[String] = new Data(null, this)
  val age: Data[Integer] = new Data(null, this)

  def getId = id.get()

  def getName = name.get()

  def getAge = age.get()

  def setId(id: Int): Unit = this.id.set(id)

  def setName(name: String): Unit = this.name.set(name)

  def setAge(age: Int): Unit = this.age.set(age)
}