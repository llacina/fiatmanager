package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.BankAccountDto
import com.wbtcb.fiatmanager.model.entity.repository.BankAccountRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BankAcconutResource @Autowired constructor(
    private val bankAccountRepository: BankAccountRepository
) : ResourceRepositoryBase<BankAccountDto, Int>(BankAccountDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<BankAccountDto> {
        return querySpec.apply(bankAccountRepository.findAllAsDto())
    }
}
