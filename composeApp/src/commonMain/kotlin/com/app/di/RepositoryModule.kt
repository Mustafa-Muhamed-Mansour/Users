package com.app.di

import com.data.repository.HomeRepositoryIml
import com.domain.repository.HomeRepository
import org.koin.dsl.module

val homeRepositoryImlModule = module {
    single<HomeRepository> { HomeRepositoryIml(apiClient = get()) }
}