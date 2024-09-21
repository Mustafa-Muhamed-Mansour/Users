package com.app.di

import com.domain.usecase.HomeUsers
import org.koin.dsl.module

val useCaseModule = module {
    single { HomeUsers(homeRepository = get()) }
}