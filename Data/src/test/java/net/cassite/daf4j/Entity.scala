package net.cassite.daf4j

/**
 * Created by wkgcass on 15/10/28.
 */
class Entity {
  val id = new DataComparable[Integer](this)
  val name = new Data[String](this)
  val age = new DataComparable[Integer](this)

  def getId = id.get

  def getName = name.get

  def getAge = age.get

  import DataUtils._

  def setId(id: Integer) = set(this.id, id)

  def setName(name: String) = set(this.name, name)

  def setAge(age: Integer) = set(this.age, age)
}
