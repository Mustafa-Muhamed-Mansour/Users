package com.app.di

import HomeViewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    single { HomeViewModel(homeRepository = get() )}
}