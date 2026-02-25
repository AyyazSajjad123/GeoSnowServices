package org.example.project

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.koin.compose.KoinApplication
import org.example.project.di.appModule
import org.example.project.ui.screens.HomeScreen

@Composable
fun MainApp() {
    // YAHAN FIX HAI: KoinContext ki jagah KoinApplication use karein
    KoinApplication(application = {
        // App ko batayen ke kaun sa module load karna hai
        modules(appModule)
    }) {
        // Koin successfully start hone ke baad Navigator chalega
        Navigator(HomeScreen())
    }
}