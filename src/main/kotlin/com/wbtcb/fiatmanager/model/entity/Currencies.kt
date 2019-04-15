@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable

object CurrenciesTable : IdTable<String>("currencies") {
    override val id = varchar("code", 3).primaryKey().entityId()
    val name = text("name")
}

class Currency(id: EntityID<String>) : Entity<String>(id) {
    val name by CurrenciesTable.name

    companion object : EntityClass<String, Currency>(CurrenciesTable)
}
