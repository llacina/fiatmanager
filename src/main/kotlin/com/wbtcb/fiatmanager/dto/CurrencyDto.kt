package com.wbtcb.fiatmanager.dto

import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import java.io.Serializable

@JsonApiResource(type = "currencies")
data class CurrencyDto (
    @JsonApiId
    var id: String,
    val name: String
) : Serializable
