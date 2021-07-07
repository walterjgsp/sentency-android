package org.wcode.sentency.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.wcode.sentency.ui.shared.Screen

class SplashScreenViewModel : ViewModel() {

    fun countdown(navController: NavController) {
        viewModelScope.launch(Dispatchers.Main) {
            delay(5000)
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
        }
    }
}