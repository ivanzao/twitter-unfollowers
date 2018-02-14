package br.com.ivanzao.conf

import br.com.ivanzao.config.ConfigService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import spark.Service

@Configuration
@PropertySource("classpath:/application.properties")
open class SparkConfig {

    @Bean
    open fun spark(configService: ConfigService): Service = Service.ignite().apply {
        port(configService.getRequiredInt("server.port"))
        threadPool(configService.getRequiredInt("jetty.maxThreads"),
                configService.getRequiredInt("jetty.minThreads"),
                configService.getRequiredInt("jetty.idleTimeout"))
    }

}