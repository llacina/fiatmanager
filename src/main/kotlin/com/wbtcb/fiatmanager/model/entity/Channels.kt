@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object ChannelsTable : IntIdTable("channels") {
    val code = varchar("code", 10)
    val name = text("name")
    val createdAt = date("created_at")
}

class Channel(id: EntityID<Int>) : IntEntity(id) {
    var code by ChannelsTable.code
    var name by ChannelsTable.name
    var createdAt by ChannelsTable.createdAt

    companion object : IntEntityClass<Channel>(ChannelsTable)
}
