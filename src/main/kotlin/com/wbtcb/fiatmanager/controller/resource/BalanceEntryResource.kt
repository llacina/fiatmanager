package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.BalanceEntryDto
import com.wbtcb.fiatmanager.model.entity.repository.BalanceEntryRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BalanceEntryResource @Autowired constructor(
    private val balanceEntryRepository: BalanceEntryRepository
) : ResourceRepositoryBase<BalanceEntryDto, Int>(BalanceEntryDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<BalanceEntryDto> {
        return querySpec.apply(balanceEntryRepository.findAllAsDto())
    }
}
