package com.practicaltest.inovantsolutionsTest.data.repository

import com.practicaltest.inovantsolutionsTest.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getDetails() = apiHelper.getDetails()
}