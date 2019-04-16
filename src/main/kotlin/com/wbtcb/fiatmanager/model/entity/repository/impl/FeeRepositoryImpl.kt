package com.wbtcb.fiatmanager.model.entity.repository.impl


import com.wbtcb.fiatmanager.dto.FeeDto
import com.wbtcb.fiatmanager.model.entity.Fee
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.FeeRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class FeeRepositoryImpl : FeeRepository {

    override fun findAll(): List<Fee> {
        return Fee.all().toList()
    }

    override fun findAllAsDto(): List<FeeDto> {
        return this.findAll().map { it.toFeeDto() }
    }
}
