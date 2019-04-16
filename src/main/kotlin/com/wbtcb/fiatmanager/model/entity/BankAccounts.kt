@file:Suppress("unused")

package com.wbtcb.fiatmanager.model.entity

import com.wbtcb.fiatmanager.dto.BankAccountDto
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object BankAccountsTable : IntIdTable("bank_accounts") {
    val bankCode = varchar("bank_code", 4)
    val bank = reference("bank_code", BanksTable)
    val name = text("name")
    val prefix = varchar("prefix", 6).nullable()
    val accountNumber = varchar("account_number", 10)
    val iban = varchar("iban", 24).nullable()
    val currencyCode = varchar("currency_code", 3)
    val currency = reference("currency_code", CurrenciesTable)
}

class BankAccount(id: EntityID<Int>) : IntEntity(id) {
    var bankCode by BankAccountsTable.bankCode
    var bank by Bank.referencedOn(BankAccountsTable.bank)
    var name by BankAccountsTable.name
    var prefix by BankAccountsTable.prefix
    var accountNumber by BankAccountsTable.accountNumber
    var iban by BankAccountsTable.iban
    var currencyCode by BankAccountsTable.currencyCode
    var currency by Currency.referencedOn(BankAccountsTable.currency)

    companion object : IntEntityClass<BankAccount>(BankAccountsTable)

    fun toBankAccountDto(): BankAccountDto = BankAccountDto(
        id = id.value,
        bankCode = bankCode,
        name = name,
        prefix = prefix,
        accountNumber = accountNumber,
        iban = iban,
        currencyCode = currencyCode
    )
}
