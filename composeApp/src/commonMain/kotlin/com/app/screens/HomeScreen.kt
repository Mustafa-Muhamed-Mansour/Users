package com.app.screens

import HomeViewModel
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.app.AppContent
import org.koin.compose.getKoin

object HomeScreen: Screen {

    @Composable
    override fun Content() {
        val homeViewModel = HomeViewModel(homeRepository = getKoin().get())
        AppContent(homeViewModel = homeViewModel)
    }
}