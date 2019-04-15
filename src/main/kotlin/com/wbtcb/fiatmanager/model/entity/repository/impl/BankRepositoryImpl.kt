package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.model.entity.Bank
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository

@Repository
class BankRepositoryImpl : BankRepository {

    override fun findAll(): List<Bank> {
        return Bank.all().toList()
    }
}
