package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.model.entity.Bank

interface BankRepository {
    fun findAll(): List<Bank>
}
