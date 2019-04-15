@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import com.wbtcb.fiatmanager.config.jsonb
import com.wbtcb.fiatmanager.service.impl.SpringContextServiceImpl

object RequestsTable : IntIdTable("requests") {
    val externalId = uuid("external_id")
    val request = jsonb(
        "request",
        JsonNode::class.java,
        SpringContextServiceImpl.getBean(ObjectMapper::class.java) as ObjectMapper
    ).nullable()
    val createdAt = date("created_at")
}

class Request(id: EntityID<Int>) : IntEntity(id) {
    var externalId by RequestsTable.externalId
    var request by RequestsTable.request
    var createdAt by RequestsTable.createdAt

    companion object : IntEntityClass<Request>(RequestsTable)
}
