package com.aldopratama.restapi.configurations

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
data class BasicConfiguration(
        @Value("\${application.name}")
        val name: String,
        @Value("\${application.version}")
        val version: String,
        @Value("\${application.production-mode}")
        val productionMode: Boolean
)
