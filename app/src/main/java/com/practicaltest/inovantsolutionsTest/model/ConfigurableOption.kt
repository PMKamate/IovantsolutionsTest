package com.practicaltest.inovantsolutionsTest.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("type", "attribute_id", "attribute_code", "attributes")
class ConfigurableOption {
    @JsonProperty("type")
    var type: String? = null

    @JsonProperty("attribute_id")
    var attributeId: String? = null

    @JsonProperty("attribute_code")
    var attributeCode: String? = null

    @JsonProperty("attributes")
    var attributes: List<Attribute>? = null
}