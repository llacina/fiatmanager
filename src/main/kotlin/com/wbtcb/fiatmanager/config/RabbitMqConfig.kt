package com.wbtcb.fiatmanager.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter

@Configuration
class RabbitMqConfig @Autowired constructor(
    private val jacksonObjectMapper: ObjectMapper
) {

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate =
        RabbitTemplate(connectionFactory).apply {
            messageConverter = producerJackson2MessageConverter()
        }

    @Bean
    fun producerJackson2MessageConverter(): Jackson2JsonMessageConverter = object : Jackson2JsonMessageConverter(jacksonObjectMapper) {
        override fun fromMessage(message: Message): Any {
            // fixes bug of missing content-type in header
            message.messageProperties?.contentType = "application/json"
            return super.fromMessage(message)
        }
    }

    @Bean
    fun messageHandlerMethodFactory(): SimpleRabbitListenerContainerFactory =
        SimpleRabbitListenerContainerFactory().apply {
            setMessageConverter(producerJackson2MessageConverter())
        }

    @Bean
    fun consumerJackson2MessageConverter(): MappingJackson2MessageConverter = MappingJackson2MessageConverter()

    companion object
}
