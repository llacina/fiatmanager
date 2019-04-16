package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.FeeDto
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import com.wbtcb.fiatmanager.model.entity.repository.FeeRepository

@Component
class FeeResource @Autowired constructor(
    private val feeRepository: FeeRepository
) : ResourceRepositoryBase<FeeDto, Int>(FeeDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<FeeDto> {
        return querySpec.apply(feeRepository.findAllAsDto())
    }
}
