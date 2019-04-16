package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.CurrencyDto
import com.wbtcb.fiatmanager.model.entity.repository.CurrencyRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class CurrencyResource @Autowired constructor(
    private val currencyRepository: CurrencyRepository
) : ResourceRepositoryBase<CurrencyDto, Int>(CurrencyDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<CurrencyDto> {
        return querySpec.apply(currencyRepository.findAllAsDto())
    }
}
