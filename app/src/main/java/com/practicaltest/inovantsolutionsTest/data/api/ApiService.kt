package com.practicaltest.inovantsolutionsTest.data.api

import com.practicaltest.inovantsolutionsTest.model.Details
import retrofit2.http.GET

interface ApiService {
//http://mobicraftsv2.com/bloc49/api/v3/product-details?product_id=1812&lang=en&store=KW
    @GET("product-details?product_id=1812&lang=en&store=KW")
    suspend fun getDetails(): Details

}