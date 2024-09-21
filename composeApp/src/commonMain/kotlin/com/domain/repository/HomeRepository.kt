package com.domain.repository

import UserResponse
import com.app.utils.Resource

interface HomeRepository {
    suspend fun httpClint(): UserResponse?
    suspend fun fetchUsers(): Resource<UserResponse?>

}