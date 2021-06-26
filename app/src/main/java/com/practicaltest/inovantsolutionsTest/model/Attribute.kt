package com.practicaltest.inovantsolutionsTest.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("option_id", "option_product_id", "value")
class Attribute {
    @JsonProperty("option_id")
    var optionId: String? = null

    @JsonProperty("option_product_id")
    var optionProductId: String? = null

    @JsonProperty("value")
    var value: String? = null
}