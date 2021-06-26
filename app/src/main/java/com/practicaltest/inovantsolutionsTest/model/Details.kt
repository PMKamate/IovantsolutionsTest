package com.practicaltest.inovantsolutionsTest.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("success", "status", "message", "data")
class Details {
    @JsonProperty("success")
    var success: Boolean? = null

    @JsonProperty("status")
    var status: Int? = null

    @JsonProperty("message")
    var message: String? = null

    @JsonProperty("data")
    var data: Data? = null
}