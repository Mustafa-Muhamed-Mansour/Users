package com.app.composables

import HomeViewModel
import androidx.compose.runtime.Composable

@Composable
fun HomeApp(
    homeViewModel: HomeViewModel
) {
    HomeAppContent(homeViewModel = homeViewModel)
}

@Composable
fun HomeAppContent(
    homeViewModel: HomeViewModel
) {
    CheckDataOfHome(homeViewModel = homeViewModel)
    homeViewModel.fetchUsers()
}
