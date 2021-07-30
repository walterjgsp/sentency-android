package org.wcode.sentency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.wcode.sentency.ui.shared.Screen
import org.wcode.sentency.ui.shared.viewModelModule
import org.wcode.sentency.ui.screens.splash.SplashScreen
import org.wcode.sentency.ui.screens.home.HomeScreen
import org.wcode.sentency.ui.shared.networkModule
import org.wcode.sentency.ui.shared.repositoryModule
import org.wcode.sentency.ui.theme.SentencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin()
        setContent {
            SentencyTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SplashScreen.route
                    ) {
                        composable(Screen.SplashScreen.route) { SplashScreen(navController) }
                        composable(Screen.Home.route) { HomeScreen() }
                    }
                }
            }
        }
    }

    private fun initKoin() {
        val context = this.application
        startKoin {
            androidLogger()
            androidContext(context)
            modules(viewModelModule, networkModule, repositoryModule)
        }
    }
}