package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.CurrencyDto
import com.wbtcb.fiatmanager.model.entity.Currency
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.CurrencyRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class CurrencyRepositoryImpl : CurrencyRepository {

    override fun findAll(): List<Currency> {
        return Currency.all().toList()
    }

    override fun findAllAsDto(): List<CurrencyDto> {
        return this.findAll().map { it.toCurrencyDto() }
    }
}
