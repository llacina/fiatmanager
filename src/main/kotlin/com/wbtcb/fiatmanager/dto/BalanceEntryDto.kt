package com.wbtcb.fiatmanager.dto

import com.wbtcb.fiatmanager.enum.BalanceEntryType
import com.wbtcb.fiatmanager.enum.TransactionStatus
import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import org.joda.time.DateTime
import java.io.Serializable
import java.math.BigDecimal

@JsonApiResource(type = "balance-entries")
data class BalanceEntryDto (
    @JsonApiId
    var id: Int,
    var currencyCode: String,
    var amount: BigDecimal,
    var status: TransactionStatus,
    var type: BalanceEntryType,
    var note:   String,
    var createdAt: DateTime
) : Serializable
