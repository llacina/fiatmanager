@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object AddressesTable : IntIdTable("addresses") {
    val channel = reference("channel_id", ChannelsTable)
    val bankAccount = reference("bank_account_id", BankAccountsTable)
    val variableSymbol = varchar("variable_symbol", 10).nullable()
    val constantSymbol = varchar("constant_symbol", 4).nullable()
    val specificSymbol = varchar("specific_symbol", 10).nullable()
    val payeeMessage = text("payee_message").nullable()
    val createdAt = date("created_at")
}

class Address(id: EntityID<Int>) : IntEntity(id) {
    var channel by Channel.referencedOn(AddressesTable.channel)
    var bankAccount by BankAccount.referencedOn(AddressesTable.bankAccount)
    var variableSymbol by AddressesTable.variableSymbol
    var constantSymbol by AddressesTable.constantSymbol
    var specificSymbol by AddressesTable.specificSymbol
    var payeeMessage by AddressesTable.payeeMessage
    var createdAt by AddressesTable.createdAt

    companion object : IntEntityClass<Address>(AddressesTable)
}
