package com.wbtcb.fiatmanager

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableRabbit
@EnableScheduling
@SpringBootApplication
class FiatmanagerApplication {
    companion object {
        const val APP_NAME = "fiatmanager"
    }
}

fun main(args: Array<String>) {
    runApplication<FiatmanagerApplication>(*args)
}
