@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import com.wbtcb.fiatmanager.dto.BalanceEntryDto
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import com.wbtcb.fiatmanager.enum.TransactionStatus
import com.wbtcb.fiatmanager.enum.BalanceEntryType

object BalanceEntriesTable : IntIdTable("balance_entries") {
    val channel = reference("channel_id", ChannelsTable)
    val currency = reference("currency_code", CurrenciesTable)
    val currencyCode = varchar("currency_code", 3)
    val request = reference("request_id", RequestsTable)
    val transaction = reference("transaction_id", TransactionsTable)
    val amount = decimal("amount", 18, 8)
    val status = enumerationByName("status", 10, TransactionStatus::class)
    val type = enumerationByName("type", 10, BalanceEntryType::class)
    val note = text("note")
    val createdAt = date("created_at")
}

class BalanceEntry(id: EntityID<Int>) : IntEntity(id) {
    var channel by Channel.referencedOn(BalanceEntriesTable.channel)
    var currency by Currency.referencedOn(BalanceEntriesTable.currency)
    var currencyCode by BalanceEntriesTable.currencyCode
    var request by Request.referencedOn(BalanceEntriesTable.request)
    var transaction by Transaction.referencedOn(BalanceEntriesTable.transaction)
    var amount by BalanceEntriesTable.amount
    var status by BalanceEntriesTable.status
    var type by BalanceEntriesTable.type
    var note by BalanceEntriesTable.note
    var createdAt by BalanceEntriesTable.createdAt

    companion object : IntEntityClass<BalanceEntry>(BalanceEntriesTable)

    fun toBalanceEntryDto(): BalanceEntryDto = BalanceEntryDto(
        id = id.value,
        amount = amount,
        currencyCode = currencyCode,
        status = status,
        type = type,
        note = note,
        createdAt = createdAt
    )
}
