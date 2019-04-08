package com.wbtcb.fiatmanager.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.zaxxer.hikari.HikariDataSource
import mu.KLogging
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import org.postgresql.util.PGobject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.sql.PreparedStatement

@Configuration
@EnableTransactionManagement
class ExposedConfig {

    @Bean
    fun transactionManager(dataSource: HikariDataSource): SpringTransactionManager =
        SpringTransactionManager(dataSource)

    @Bean
    fun persistenceExceptionTranslationPostProcessor() = PersistenceExceptionTranslationPostProcessor()
}

/**
 * Enable support Jsonb type in exposed
 * more @see https://github.com/JetBrains/Exposed/wiki/FAQ
 */

fun <T : Any> Table.jsonb(name: String, klass: Class<T>, jsonMapper: ObjectMapper): Column<T> =
    registerColumn(name, Json(klass, jsonMapper))

private class Json<out T : Any>(private val klass: Class<T>, private val jsonMapper: ObjectMapper) : ColumnType() {
    override fun sqlType() = "jsonb"

    override fun setParameter(stmt: PreparedStatement, index: Int, value: Any?) {
        val obj = PGobject()
        obj.type = "jsonb"
        obj.value = value as String
        stmt.setObject(index, obj)
    }

    override fun valueFromDB(value: Any): Any {
        value as PGobject
        return try {
            jsonMapper.readValue(value.value, klass)
        } catch (e: Exception) {
            logger.error(e) { "Error parsing JSON value $value" }
            throw RuntimeException("Can't parse JSON: $value")
        }
    }

    override fun notNullValueToDB(value: Any): Any = jsonMapper.writeValueAsString(value)
    override fun nonNullValueToString(value: Any): String = "'${jsonMapper.writeValueAsString(value)}'"

    companion object : KLogging()
}
