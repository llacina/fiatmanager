package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.BankAccountDto
import com.wbtcb.fiatmanager.model.entity.BankAccount
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.BankAccountRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BankAccountRepositoryImpl : BankAccountRepository {

    override fun findAll(): List<BankAccount> {
        return BankAccount.all().toList()
    }

    override fun findAllAsDto(): List<BankAccountDto> {
        return this.findAll().map { it.toBankAccountDto() }
    }
}
