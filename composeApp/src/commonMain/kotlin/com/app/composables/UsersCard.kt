package com.app.composables

import UserModel
import androidx.compose.runtime.Composable

@Composable
fun UsersCard(
    users: UserModel
) {
    ItemUserOfCard(user = users)
}