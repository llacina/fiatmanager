package com.wbtcb.fiatmanager.dto

import io.crnk.core.resource.annotations.JsonApiId
import io.crnk.core.resource.annotations.JsonApiResource
import org.joda.time.DateTime
import java.io.Serializable

@JsonApiResource(type = "channels")
data class ChannelDto (
    @JsonApiId
    var id: Int,
    var code: String,
    var name: String,
    var createdAt: DateTime
) : Serializable
