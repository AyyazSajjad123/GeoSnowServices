package org.example.project

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.koin.compose.KoinApplication
import org.example.project.di.appModule
import org.example.project.ui.screens.LoginScreen
import org.example.project.ui.theme.GeoSnowTheme

@Composable
fun MainApp() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        // App ab Theme ke andar hai, aur pehli screen LoginScreen hogi
        GeoSnowTheme {
            Navigator(LoginScreen())
        }
    }
}