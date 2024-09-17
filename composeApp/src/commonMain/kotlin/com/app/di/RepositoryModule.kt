package com.app.di

import com.app.repository.HomeRepository
import org.koin.dsl.module

val homeRepositoryModule = module {
    single { HomeRepository(apiClient = get()) }
}