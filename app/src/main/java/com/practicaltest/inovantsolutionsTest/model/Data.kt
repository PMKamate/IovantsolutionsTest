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
    "is_used",
    "regular_price",
    "final_price",
    "currency_code",
    "remaining_quantity",
    "is_featured",
    "is_gift",
    "new_from_date",
    "new_to_date",
    "brand_name",
    "image",
    "images",
    "video",
    "configurable_option",
    "related_products",
    "reviews",
    "is_saleable",
    "product_type",
    "associated_products",
    "item_in_cart",
    "item_in_wishlist",
    "average_rating",
    "size_guide",
    "shop_id",
    "shop",
    "shop_description",
    "shop_image",
    "delivery_time",
    "delivery_time_text"
)
class Data {
    @JsonProperty("id")
    var id: Int? = null

    @JsonProperty("name")
    var name: String? = null

    @JsonProperty("short_description")
    var shortDescription: String? = null

    @JsonProperty("description")
    var description: String? = null

    @JsonProperty("specification")
    var specification: String? = null

    @JsonProperty("shipping_free_returns")
    var shippingFreeReturns: String? = null

    @JsonProperty("SKU")
    var sku: String? = null

    @JsonProperty("is_used")
    var isUsed: Int? = null

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

    @JsonProperty("is_gift")
    var isGift: Int? = null

    @JsonProperty("new_from_date")
    var newFromDate: String? = null

    @JsonProperty("new_to_date")
    var newToDate: String? = null

    @JsonProperty("brand_name")
    var brandName: String? = null

    @JsonProperty("image")
    var image: String? = null

    @JsonProperty("images")
    var images: List<String>? = null

    @JsonProperty("video")
    var video: String? = null

    @JsonProperty("configurable_option")
    var configurableOption: List<ConfigurableOption>? = null

    @JsonProperty("related_products")
    var relatedProducts: List<RelatedProduct>? = null

    @JsonProperty("reviews")
    var reviews: List<Any>? = null

    @JsonProperty("is_saleable")
    var isSaleable: Int? = null

    @JsonProperty("product_type")
    var productType: String? = null

    @JsonProperty("associated_products")
    var associatedProducts: List<AssociatedProduct>? = null

    @JsonProperty("item_in_cart")
    var itemInCart: Int? = null

    @JsonProperty("item_in_wishlist")
    var itemInWishlist: Int? = null

    @JsonProperty("average_rating")
    var averageRating: String? = null

    @JsonProperty("size_guide")
    var sizeGuide: String? = null

    @JsonProperty("shop_id")
    var shopId: Int? = null

    @JsonProperty("shop")
    var shop: String? = null

    @JsonProperty("shop_description")
    var shopDescription: String? = null

    @JsonProperty("shop_image")
    var shopImage: String? = null

    @JsonProperty("delivery_time")
    var deliveryTime: String? = null

    @JsonProperty("delivery_time_text")
    var deliveryTimeText: String? = null
}
