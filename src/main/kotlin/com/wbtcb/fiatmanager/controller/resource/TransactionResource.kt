package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.TransactionDto
import com.wbtcb.fiatmanager.model.entity.repository.TransactionRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TransactionResource @Autowired constructor(
    private val transactionRepository: TransactionRepository
) : ResourceRepositoryBase<TransactionDto, Int>(TransactionDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<TransactionDto> {
        return querySpec.apply(transactionRepository.findAllAsDto())
    }
}
