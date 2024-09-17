package com.app.screens

import UserModel
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.app.detail.DetailContent

class DetailScreen(
    private val userModel: UserModel
) : Screen {

    @Composable
    override fun Content() {
        DetailContent(userModel = userModel)
    }
}