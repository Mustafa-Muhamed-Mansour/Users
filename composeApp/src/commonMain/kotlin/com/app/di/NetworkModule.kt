package com.app.di

import com.app.network.ApiClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    fun provideHttpClient(): ApiClient {
        return ApiClient()
    }

    single { provideHttpClient() }
}