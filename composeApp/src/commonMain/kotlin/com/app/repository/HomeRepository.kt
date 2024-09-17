package com.app.repository

import UserResponse
import com.app.network.ApiClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.app.utils.Constants.BASE_URL
import com.app.utils.Resource

class HomeRepository(
    private val apiClient: ApiClient
) {

    private suspend fun httpClint(): UserResponse? {
        val response = apiClient.httpClient.get(urlString = BASE_URL)
        return response.body()
    }

    suspend fun fetchUsers(): Resource<UserResponse?> {
        return try {
            val result = httpClint()
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

}