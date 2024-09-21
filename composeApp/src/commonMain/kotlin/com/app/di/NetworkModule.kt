package com.app.di

import com.data.data.datasource.remote.ApiClient
import org.koin.dsl.module

val networkModule = module {
    fun provideHttpClient(): ApiClient {
        return ApiClient()
    }

    single { provideHttpClient() }
}