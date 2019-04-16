package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.TransactionDto
import com.wbtcb.fiatmanager.model.entity.Transaction


interface TransactionRepository {

    fun findAll(): List<Transaction>

    fun findAllAsDto(): List<TransactionDto>


}
