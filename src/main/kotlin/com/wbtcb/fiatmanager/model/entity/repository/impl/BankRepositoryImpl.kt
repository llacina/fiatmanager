package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.BankDto
import com.wbtcb.fiatmanager.model.entity.Bank
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BankRepositoryImpl : BankRepository {

    override fun findAllasDto(): List<BankDto> {
        var list = listOf<BankDto>()
        for (item: Bank in this.findAll()) {
            list += item.toBankDto()
        }
        return list
    }

    override fun findAll(): List<Bank> {
        return Bank.all().toList()
    }

    fun Bank.toBankDto(): BankDto = BankDto(
        id = Integer(id.value),
        code = code,
        name = name
    )
}
