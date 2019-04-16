package com.wbtcb.fiatmanager.dto

import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import java.io.Serializable
import java.math.BigDecimal

@JsonApiResource(type = "fees")
data class FeeDto constructor(
    @JsonApiId
    var id: Int,
    var type: String,
    var amount: BigDecimal
) : Serializable
