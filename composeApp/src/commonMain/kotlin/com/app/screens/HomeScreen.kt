package com.app.screens

import HomeViewModel
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.app.composables.HomeApp
import org.koin.compose.getKoin
import org.koin.compose.viewmodel.koinViewModel

object HomeScreen: Screen {

    @Composable
    override fun Content() {

        val homeViewModel = HomeViewModel(getKoin().get())
        HomeApp(homeViewModel = homeViewModel)
    }
}