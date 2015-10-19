package test

import java.util
import javax.persistence
import javax.persistence.criteria.{CriteriaQuery, CriteriaBuilder}
import javax.persistence.metamodel.Metamodel
import javax.persistence._

import net.cassite.pure.data._
import net.cassite.pure.data.Query
import net.cassite.pure.data.jpa.JPQLDataAccess

import scala.collection.JavaConversions._

/**
 * Created by wkgcass on 15/10/17.
 */
object Main {
  def main(args: Array[String]): Unit = {

    val query: Query = new Query(new JPQLDataAccess(Persistence createEntityManagerFactory "mysqlJPA"))

    val user = new User
    user.id := 1
    val list = query from user where user.id <> 2 & user.age > 18 list

    list.foreach {
      u => println(u.getId)
        println(u.getName)
        println(u.getAge)

        u.getRoles.foreach {
          r => println(r.getId)
            println(r.getName)
        }
    }
  }
}
