@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import com.wbtcb.fiatmanager.enum.TransactionStatus
import com.wbtcb.fiatmanager.enum.TransactionType
import com.wbtcb.fiatmanager.enum.TransactionPaymentType

object TransactionsTable : IntIdTable("transactions") {
    val txId = text("txid")
    val bankAccount = reference("bank_account_id", BankAccountsTable)
    val amount = decimal("amount", 18, 8)
    val prefix = varchar("prefix", 6).nullable()
    val accountNumber = varchar("account_number", 10)
    val bankCode = varchar("bank_code", 4)
    val iban = varchar("iban", 24).nullable()
    val variableSymbol = varchar("variable_symbol", 10).nullable()
    val constantSymbol = varchar("constant_symbol", 4).nullable()
    val specificSymbol = varchar("specific_symbol", 10).nullable()
    val type = enumerationByName("type", 10, TransactionType::class)
    val paymentType = enumerationByName("payment_type", 10, TransactionPaymentType::class)
    val payerMessage = text("payer_message").nullable()
    val payeeMessage = text("payee_message").nullable()
    val valueAt = date("value_at")
    val bookingAt = date("booking_at")
    val note = text("note")
    val status = enumerationByName("status", 10, TransactionStatus::class)
    val createdAt = date("created_at")
}

class Transaction(id: EntityID<Int>) : IntEntity(id) {
    var txId by TransactionsTable.txId
    var bankAccount by BankAccount.referencedOn(TransactionsTable.bankAccount)
    var amount by TransactionsTable.amount
    var prefix by TransactionsTable.prefix
    var accountNumber by TransactionsTable.accountNumber
    var bankCode by TransactionsTable.bankCode
    var iban by TransactionsTable.iban
    var variableSymbol by TransactionsTable.variableSymbol
    var constantSymbol by TransactionsTable.constantSymbol
    var specificSymbol by TransactionsTable.specificSymbol
    var type by TransactionsTable.type
    var paymentType by TransactionsTable.paymentType
    var payerMessage by TransactionsTable.payerMessage
    var payeeMessage by TransactionsTable.payeeMessage
    var valueAt by TransactionsTable.valueAt
    var bookingAt by TransactionsTable.bookingAt
    var note by TransactionsTable.note
    var status by TransactionsTable.status
    var createdAt by TransactionsTable.createdAt

    companion object : IntEntityClass<Transaction>(TransactionsTable)
}
