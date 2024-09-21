package com.domain.usecase

import com.domain.repository.HomeRepository

class HomeUsers(
    private val homeRepository: HomeRepository
) {
    suspend fun httpClint() = homeRepository.httpClint()
    suspend fun fetchUsers() = homeRepository.fetchUsers()
}