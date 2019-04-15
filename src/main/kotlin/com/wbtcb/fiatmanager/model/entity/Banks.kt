@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import com.wbtcb.fiatmanager.dto.BankDto
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object BanksTable : IntIdTable("banks") {
    val code = varchar("code", 4)
    val name = text("name")
    val host = text("host")
    val port = text("port")
    val login = text("login")
    val password = text("password")
}

class Bank(id: EntityID<Int>) : IntEntity(id) {
    var code by BanksTable.code
    var name by BanksTable.name
    var host by BanksTable.host
    var port by BanksTable.port
    var login by BanksTable.login
    var password by BanksTable.password

    companion object : IntEntityClass<Bank>(BanksTable)


    fun Bank.toBankDto(): BankDto = BankDto(
        id = Integer(id.value),
        code = code,
        name = name
    )
}
