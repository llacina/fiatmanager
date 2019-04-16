@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import com.wbtcb.fiatmanager.dto.FeeDto
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object FeesTable : IntIdTable("fees") {
    val transaction = reference("transaction_id", TransactionsTable)
    val type = varchar("type", 10)
    val amount = decimal("amount", 18, 8)
}

class Fee(id: EntityID<Int>) : IntEntity(id) {
    var transaction by Transaction.referencedOn(FeesTable.transaction)
    var type by FeesTable.type
    var amount by FeesTable.amount

    companion object : IntEntityClass<Fee>(FeesTable)

    fun toFeeDto(): FeeDto = FeeDto(
        id = id.value,
        type = type,
        amount = amount
    )
}
