package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.BalanceEntryDto
import com.wbtcb.fiatmanager.model.entity.BalanceEntry
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.BalanceEntryRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BalanceEntryRepositoryImpl : BalanceEntryRepository {

    override fun findAll(): List<BalanceEntry> {
        return BalanceEntry.all().toList()
    }

    override fun findAllAsDto(): List<BalanceEntryDto> {
        return this.findAll().map { it.toBalanceEntryDto() }
    }
}
