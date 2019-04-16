package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.BankDto
import com.wbtcb.fiatmanager.model.entity.Bank
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BankRepositoryImpl : BankRepository {

    override fun findAll(): List<Bank> {
        return Bank.all().toList()
    }

    override fun findAllAsDto(): List<BankDto> {
        return this.findAll().map { it.toBankDto() }
    }
}
