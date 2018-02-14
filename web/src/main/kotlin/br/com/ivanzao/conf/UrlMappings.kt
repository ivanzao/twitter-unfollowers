package br.com.ivanzao.conf

import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import spark.Service

@Component
class UrlMappings(private val sparkService: Service) {

    @EventListener(ContextRefreshedEvent::class)
    fun init() {
        sparkService.get("/health") { _, _ ->
            "yay!"
        }
    }
}