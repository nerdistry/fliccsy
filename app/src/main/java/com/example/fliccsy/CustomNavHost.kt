package com.example.fliccsy

import android.window.SplashScreen
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

public enum class AllRoutes(@StringRes val title: Int) {
    Start(title = R.string.splash),
    Login(title = R.string.login),
    Signup(title = R.string.signup),
    Home(title = R.string.home),
    Home2(title = R.string.home2),
    Swiping(title = R.string.swipe),
    Settings(title = R.string.settings),
    Profile(title = R.string.profiles),
    AddProfile(title = R.string.add_profile),
    Keypad(title = R.string.keypad)
}

@Composable
fun CustomNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AllRoutes.Login.name
    ) {
        composable(route = AllRoutes.Login.name) {
            LoginScreen(navController)
        }
        composable(route = AllRoutes.Signup.name) {
            SignupScreen(navController)
        }
        composable(route = AllRoutes.AddProfile.name) {
            AddProfile(navController)
        }
        composable(route = AllRoutes.Home2.name) {
            Home2(navController)
        }
        composable(route = AllRoutes.Home.name) {
            HomeScreen(navController)
        }
        composable(route = AllRoutes.Keypad.name) {
            KeyPadActivity().keypadScreen(navController)
        }
        composable(route = AllRoutes.Profile.name) {
            OnBoardingScreen(navController)
        }
        composable(route = AllRoutes.Settings.name) {
            AppSettings().build(navController)
        }
        composable(route = AllRoutes.Swiping.name) {
            SwipingBox(navController)
        }
    }
}

