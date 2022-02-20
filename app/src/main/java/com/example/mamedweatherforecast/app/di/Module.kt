package com.example.mamedweatherforecast.app.di

import com.example.mamedweatherforecast.viewmodel.TownViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { TownViewModel() }
}