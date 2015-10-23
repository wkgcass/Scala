package net.cassite.pure.data.jpa

import javax.persistence.EntityManager

import net.cassite.pure.data.Query

/**
 * 自动执行事务(自动开始,执行,回滚/提交)
 * @param manager 事务所在的EntityManager
 */
class AutoTx(private val manager: EntityManager) {
  private val query = new Query(new JPQLDataAccess(manager))

  def nonTx(operation: Query => Unit): AutoTx = {
    operation(query)
    this
  }

  def tx(txOperation: Query => Unit): AutoTx = {
    val tx = manager.getTransaction
    tx.begin()
    try {
      txOperation(query)
      if (tx.isActive) {
        tx.commit()
      }
    } catch {
      case ex: Throwable =>
        if (tx.isActive)
          tx.rollback()
        throw ex
    }
    this
  }
}

object AutoTx {
  def apply(manager: EntityManager) = new AutoTx(manager)
}