package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.BankDto
import com.wbtcb.fiatmanager.model.entity.repository.BankRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Repository for json api for bank - example call:
 * http://localhost:8080/api/banks
 * http://localhost:8080/api/banks/id
 */
@Component
class BankResource @Autowired constructor(
    private val bankRepository: BankRepository
) : ResourceRepositoryBase<BankDto, Int>(BankDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<BankDto> {
        return querySpec.apply(bankRepository.findAllAsDto())
    }
}
