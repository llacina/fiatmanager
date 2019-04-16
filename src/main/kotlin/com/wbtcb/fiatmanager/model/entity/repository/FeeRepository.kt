package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.FeeDto
import com.wbtcb.fiatmanager.model.entity.Fee

interface FeeRepository {

    fun findAll(): List<Fee>

    fun findAllAsDto(): List<FeeDto>
}
