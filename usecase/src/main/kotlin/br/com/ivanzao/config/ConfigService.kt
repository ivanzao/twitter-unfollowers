package br.com.ivanzao.config

import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Service
class ConfigService(private val environment: Environment) {

    fun getString(property: String, default: String) = getProperty(property) ?: default

    fun getRequiredString(property: String) = getRequiredProperty(property)

    fun getInt(property: String, default: Int) = getProperty(property)?.toInt() ?: default

    fun getRequiredInt(property: String) = getRequiredProperty(property).toInt()

    fun getBoolean(property: String, default: Boolean) = getProperty(property)?.toBoolean() ?: default

    fun getRequiredBoolean(property: String) = getRequiredProperty(property).toBoolean()

    private fun getRequiredProperty(property: String): String {
        return getProperty(property) ?: throw IllegalArgumentException("Required configuration property $property not found.")
    }

    private fun getProperty(property: String): String? {
        return this.getString(property)
    }

    private fun getString(key: String): String? {
        val envProperty = key.replace(".", "_").toUpperCase()

        return if (environment.containsProperty(envProperty)) {
            environment.getProperty(envProperty)
        } else {
            environment.getProperty(key)
        }
    }

}