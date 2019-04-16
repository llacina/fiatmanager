package com.wbtcb.fiatmanager.dto

import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import java.io.Serializable

@JsonApiResource(type = "banks")
data class BankDto constructor(
    @JsonApiId
    var id: Int,
    var code: String,
    var name: String
) : Serializable
