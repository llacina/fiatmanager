package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.CurrencyDto
import com.wbtcb.fiatmanager.model.entity.Currency

interface CurrencyRepository {

    fun findAll(): List<Currency>

    fun findAllAsDto(): List<CurrencyDto>
}
