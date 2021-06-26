package com.practicaltest.inovantsolutionsTest.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "id",
    "name",
    "short_description",
    "description",
    "specification",
    "shipping_free_returns",
    "SKU",
    "regular_price",
    "final_price",
    "currency_code",
    "remaining_quantity",
    "is_featured",
    "new_from_date",
    "new_to_date",
    "brand_name",
    "image",
    "is_saleable",
    "shop_id",
    "delivery_time",
    "delivery_time_text"
)
class RelatedProduct {
    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("name")
    var name: String? = null

    @JsonProperty("short_description")
    var shortDescription: Any? = null

    @JsonProperty("description")
    var description: String? = null

    @JsonProperty("specification")
    var specification: Any? = null

    @JsonProperty("shipping_free_returns")
    var shippingFreeReturns: Any? = null

    @JsonProperty("SKU")
    var sku: String? = null

    @JsonProperty("regular_price")
    var regularPrice: String? = null

    @JsonProperty("final_price")
    var finalPrice: String? = null

    @JsonProperty("currency_code")
    var currencyCode: String? = null

    @JsonProperty("remaining_quantity")
    var remainingQuantity: Int? = null

    @JsonProperty("is_featured")
    var isFeatured: Int? = null

    @JsonProperty("new_from_date")
    var newFromDate: String? = null

    @JsonProperty("new_to_date")
    var newToDate: String? = null

    @JsonProperty("brand_name")
    var brandName: String? = null

    @JsonProperty("image")
    var image: String? = null

    @JsonProperty("is_saleable")
    var isSaleable: Int? = null

    @JsonProperty("shop_id")
    var shopId: Int? = null

    @JsonProperty("delivery_time")
    var deliveryTime: String? = null

    @JsonProperty("delivery_time_text")
    var deliveryTimeText: String? = null
}
