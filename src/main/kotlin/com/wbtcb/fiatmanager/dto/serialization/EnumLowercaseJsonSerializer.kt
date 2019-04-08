package com.wbtcb.fiatmanager.dto.serialization

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException

class EnumLowercaseJsonSerializer : JsonSerializer<Enum<*>>() {

    @Throws(IOException::class, JsonProcessingException::class)
    override fun serialize(value: Enum<*>, jgen: JsonGenerator, provider: SerializerProvider) {
        jgen.writeString(value.toString().toLowerCase())
    }
}
