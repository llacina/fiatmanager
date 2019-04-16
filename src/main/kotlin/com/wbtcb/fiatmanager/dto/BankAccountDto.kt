package com.wbtcb.fiatmanager.dto

import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import java.io.Serializable

@JsonApiResource(type = "bank-accounts")
data class BankAccountDto constructor(
    @JsonApiId
    var id: Int,
    var bankCode: String,
    var name: String,
    var prefix: String?,
    var accountNumber: String,
    var iban: String?,
    var currencyCode: String
) : Serializable
