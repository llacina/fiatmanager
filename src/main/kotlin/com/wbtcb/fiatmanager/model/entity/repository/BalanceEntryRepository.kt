package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.BalanceEntryDto
import com.wbtcb.fiatmanager.model.entity.BalanceEntry

interface BalanceEntryRepository {

    fun findAll(): List<BalanceEntry>

    fun findAllAsDto(): List<BalanceEntryDto>
}


