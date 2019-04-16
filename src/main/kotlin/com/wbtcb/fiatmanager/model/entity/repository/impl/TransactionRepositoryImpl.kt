package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.TransactionDto
import com.wbtcb.fiatmanager.model.entity.Transaction
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.TransactionRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class TransactionRepositoryImpl : TransactionRepository {

    override fun findAll(): List<Transaction> {
        return Transaction.all().toList()
    }

    override fun findAllAsDto(): List<TransactionDto> {
        return this.findAll().map { it.toTransactionDto() }
    }
}
