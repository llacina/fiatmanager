package com.wbtcb.fiatmanager.model.entity.repository.impl

import com.wbtcb.fiatmanager.dto.ChannelDto
import com.wbtcb.fiatmanager.model.entity.Channel
import org.springframework.stereotype.Repository
import com.wbtcb.fiatmanager.model.entity.repository.ChannelRepository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class ChannelRepositoryImpl : ChannelRepository {

    override fun findAll(): List<Channel> {
        return Channel.all().toList()
    }

    override fun findAllAsDto(): List<ChannelDto> {
        return this.findAll().map { it.toChannelDto() }
    }
}
