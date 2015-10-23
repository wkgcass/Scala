package test

import java.awt.Robot
import java.util.Date
import javax.persistence._

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

    AutoTx(manager) tx { query =>
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

      // 插入数据
      query.save(clinic, user, patient, op, pSxh, opSxh)

    } nonTx { query =>
      manager.clear()
      val p = new Print
      val user = new User
      // 查询
      query from user where all list() foreach { u =>
        p.PrintTab(u.getName).PrintTab(u.getId).PrintTab(u.getPassword).PrintTab(u.getClinic.getId).Println(u.getClinic.getName)
        u.getOutpatients.foreach { outP =>
          p.PrintTab(outP.getId).PrintTab(outP.getPrice).PrintTab(outP.getPatient.getName).Println(outP.getPatient.getId)
        }
      }
    }
  }
}