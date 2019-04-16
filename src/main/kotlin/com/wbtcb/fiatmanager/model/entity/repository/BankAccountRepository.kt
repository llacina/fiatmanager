package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.BankAccountDto
import com.wbtcb.fiatmanager.model.entity.BankAccount

interface BankAccountRepository {

    fun findAll(): List<BankAccount>

    fun findAllAsDto(): List<BankAccountDto>
}
