package org.wcode.sentency.ui.shared

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SplashScreen : Screen("splash")
}