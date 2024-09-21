package com.data.repository

import UserResponse
import com.data.data.datasource.remote.ApiClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import com.app.utils.Constants.BASE_URL
import com.app.utils.Resource
import com.domain.repository.HomeRepository

class HomeRepositoryIml(
    private val apiClient: ApiClient
): HomeRepository {

    override suspend fun httpClint(): UserResponse? {
        val response = apiClient.httpClient.get(urlString = BASE_URL)
        return response.body()
    }

    override suspend fun fetchUsers(): Resource<UserResponse?> {
        return try {
            val result = httpClint()
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }

}