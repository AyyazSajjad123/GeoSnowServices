package org.example.project.di

import org.example.project.presentation.DashboardViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

// Yahan hum tamam dependencies ko define karte hain
val appModule: Module = module {
    factory { DashboardViewModel() }
}