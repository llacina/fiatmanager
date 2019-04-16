package com.wbtcb.fiatmanager.model.entity.repository

import com.wbtcb.fiatmanager.dto.ChannelDto
import com.wbtcb.fiatmanager.model.entity.Channel

interface ChannelRepository {

    fun findAll(): List<Channel>

    fun findAllAsDto(): List<ChannelDto>
}
