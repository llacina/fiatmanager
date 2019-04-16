package com.wbtcb.fiatmanager.dto

import com.wbtcb.fiatmanager.enum.TransactionPaymentType
import com.wbtcb.fiatmanager.enum.TransactionStatus
import com.wbtcb.fiatmanager.enum.TransactionType
import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import org.joda.time.DateTime
import java.io.Serializable
import java.math.BigDecimal

@JsonApiResource(type = "transactions")
data class TransactionDto (
    @JsonApiId
    var id: Int,
    var txId: String,
    var amount: BigDecimal,
    var prefix: String?,
    var accountNumber: String,
    var bankCode: String,
    var iban: String?,
    var variableSymbol: String?,
    var constantSymbol: String?,
    var specificSymbol: String?,
    var type: TransactionType,
    var paymentType: TransactionPaymentType,
    var payerMessage: String?,
    var payeeMessage: String?,
    var valueAt: DateTime,
    var bookingAt: DateTime,
    var note: String,
    var status: TransactionStatus,
    var createdAt: DateTime
) : Serializable
