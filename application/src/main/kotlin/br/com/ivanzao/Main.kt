package br.com.ivanzao

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan

@Configurable
@ComponentScan("br.com.ivanzao")
class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AnnotationConfigApplicationContext(Main::class.java)
        }
    }

}