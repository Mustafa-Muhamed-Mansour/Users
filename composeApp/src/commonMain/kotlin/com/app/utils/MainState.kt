package com.app.utils

import UserModel


data class MainState(
    val isLoading: Boolean = false,
    val data: List<UserModel> = emptyList(),
    val error: String = ""
)
