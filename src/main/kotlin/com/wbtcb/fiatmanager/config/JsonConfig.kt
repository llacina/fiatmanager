package com.wbtcb.fiatmanager.config

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.wbtcb.fiatmanager.dto.serialization.EnumLowercaseJsonSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.transaction.TransactionStatus

@Configuration
class JsonConfig {

    @Bean
    fun jackson2ObjectMapperBuilder() =
        Jackson2ObjectMapperBuilder()
            .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .featuresToEnable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            .serializerByType(TransactionStatus::class.java, EnumLowercaseJsonSerializer())
}
