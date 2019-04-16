package com.wbtcb.fiatmanager.controller.resource

import com.wbtcb.fiatmanager.dto.ChannelDto
import com.wbtcb.fiatmanager.model.entity.repository.ChannelRepository
import io.crnk.core.queryspec.QuerySpec
import io.crnk.core.repository.ResourceRepositoryBase
import io.crnk.core.resource.list.ResourceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ChannelResource @Autowired constructor(
    private val channelRepository: ChannelRepository
) : ResourceRepositoryBase<ChannelDto, Int>(ChannelDto::class.java) {

    @Synchronized
    override fun findAll(querySpec: QuerySpec): ResourceList<ChannelDto> {
        return querySpec.apply(channelRepository.findAllAsDto())
    }
}
