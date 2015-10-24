package test

import java.awt.Robot
import java.util.Date
import javax.persistence._

import net.cassite.pure.data
import net.cassite.pure.data._
import net.cassite.pure.data.jpa._
import test.bean.{Patient, Outpatient, Clinic, User}

import scala.collection.JavaConversions._

/**
 * Created by wkgcass on 15/10/17.
 */
object Main {
  def main(args: Array[String]): Unit = {
    val factory = Persistence createEntityManagerFactory "mysqlJPA"
    val manager = factory.createEntityManager()

    val query = new data.Query(new JPQLDataAccess(manager))
    // 名称为vcassv的用户
    val user = new User
    user.setAddtime(new Date)
    user.setGender("male")
    user.setName("cass")
    user.setPassword("123456")
    user.setUsername("vcassv")

    // 江苏大学医务室
    val clinic = new Clinic
    clinic.setAddress("江苏大学")
    clinic.setAddtime(new Date)
    clinic.setLeader("Dr.G")
    clinic.setName("江大医务室")
    clinic.getUsers += user

    user.setClinic(clinic)

    // 门诊记录
    val op = new Outpatient
    op.setAddtime(new Date)
    op.setAdvice("放弃治疗吧")
    op.setAppointment(new Date)
    op.setClinic(clinic)
    op.setJudgenote("你已经死了")
    op.setPrice(1000)
    op.setTreatnote("没救了")
    op.setUser(user)

    // SXH的门诊记录
    val opSxh = new Outpatient
    opSxh.setAddtime(new Date)
    opSxh.setAdvice("快死了")
    opSxh.setAppointment(new Date)
    opSxh.setClinic(clinic)
    opSxh.setJudgenote("老坑队友")
    opSxh.setPrice(99999)
    opSxh.setTreatnote("xxx")
    opSxh.setUser(user)

    val pSxh = new Patient

    opSxh.setPatient(pSxh)

    pSxh.setAddress("江苏大学x区x栋6x3")
    pSxh.setAddtime(new Date)
    pSxh.setAge(22)
    pSxh.setClinic(clinic)
    pSxh.setGender("male")
    pSxh.setName("SXH")
    pSxh.setPhone("1575100xxxx")
    pSxh.setSn("sxh")

    // 病人信息(姓名:DHR)
    val patient = new Patient

    op.setPatient(patient)

    patient.setAddress("江苏大学x区x栋6x0")
    patient.setAddtime(new Date)
    patient.setAge(21)
    patient.setClinic(clinic)
    patient.setGender("male")
    patient.setName("DHR")
    patient.setSn("dhr")

    var tx = manager.getTransaction
    tx.begin()
    // 插入数据
    query.save(clinic, user, patient, op, pSxh, opSxh)
    tx.commit()

    manager.clear()
    val p = new Print

    def printOp(outP: Outpatient): Unit = p.PrintTab(outP.getId).PrintTab(outP.getPrice).PrintTab(outP.getPatient.getName).PrintTab(outP.getPatient.getId).PrintTab(outP.getAdvice).PrintTab(outP.getJudgenote).Println(outP.getTreatnote)

    def printUser(u: User): Unit = {
      p.PrintTab(u.getName).PrintTab(u.getId).PrintTab(u.getPassword).PrintTab(u.getClinic.getId).Println(u.getClinic.getName)
      u.getOutpatients foreach printOp _
    }

    val outpatient = new Outpatient

    // 查询
    // 所有的User
    query from user where all list() foreach printUser _
    // price大于5000的门诊记录
    query from outpatient where outpatient.price > 5000 list() foreach printOp _
    // 查询对应门诊记录的price之和大于50000的用户
    user.getOutpatients += outpatient // 设定级连位置
    import Functions._
    query from user where sum(outpatient.price) > 50000L list() foreach printUser _
    // 改为大于500000
    query from user where sum(outpatient.price) > 500000L list() foreach printUser _

    tx = manager.getTransaction
    tx.begin()
    query from user where all set (user.name := concat(user.name, "a"))
    tx.commit()

    manager.clear()
    query from user where all list() foreach printUser _

    tx = manager.getTransaction
    tx.begin()
    query from outpatient where outpatient.price > 5000 remove()
    tx.commit()

    manager.clear()
    query from user where all list() foreach printUser _
  }

}