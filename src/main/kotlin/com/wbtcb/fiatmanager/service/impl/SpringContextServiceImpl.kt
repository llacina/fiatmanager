package com.wbtcb.fiatmanager.service.impl

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class SpringContextServiceImpl : ApplicationContextAware {

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    companion object {
        lateinit var context: ApplicationContext

        fun getEnvironment(): Environment {
            return context.environment
        }

        fun getBean(beanName: String): Any {
            return context.getBean(beanName)
        }

        fun getBean(requiredType: Class<*>): Any {
            return context.getBean(requiredType)
        }
    }
}
