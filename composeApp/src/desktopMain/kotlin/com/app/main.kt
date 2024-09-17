package com.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.app.di.initKoin

fun main() {
    // Start the app
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Users",
        ) {
            App()
        }
    }
}