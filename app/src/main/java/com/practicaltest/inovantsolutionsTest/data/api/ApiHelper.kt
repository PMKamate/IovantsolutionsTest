package com.practicaltest.inovantsolutionsTest.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getDetails() = apiService.getDetails()
}