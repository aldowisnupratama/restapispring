package com.aldopratama.restapi.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class VersionResponse(
        @JsonProperty("name")
        val name:String,
        @JsonProperty("version")
        val version: String,
        @JsonProperty("production-mode")
        val productionMode:Boolean
)
