package com.example.qufc.navigation

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.qufc.navigation.components.BottonBarCustom
import com.example.qufc.navigation.components.NavDrawer
import com.example.qufc.navigation.components.UpperMenu
import com.example.qufc.screens.CompHours.CompHoursScreen
import com.example.qufc.screens.Exercises.ExercisesScreen
import com.example.qufc.screens.Favorites.FavoritesScreen
import com.example.qufc.screens.Help.HelpScreen
import com.example.qufc.screens.History.HistoryScreen
import com.example.qufc.screens.Notifications.NotificationScreen
import com.example.qufc.screens.Settings.SettingsScreen
import com.example.qufc.screens.StudyGroup.StudyGroupScreen
import com.example.qufc.screens.chat.ChatScreen
import com.example.qufc.screens.homeScreen.HomeScreen
import com.example.qufc.screens.loginRegister.continueRegister.ContinueRegisterScreen
import com.example.qufc.screens.loginRegister.login.LoginScreen
import com.example.qufc.screens.loginRegister.register.RegisterScreen
import com.example.qufc.screens.profile.ProfileScreen
import com.example.qufc.screens.search.SearchScreen
import com.example.qufc.screens.settings.notifications.NotificationSettingsScreen
import com.example.qufc.screens.upload.UploadScreen


@Composable
fun NavGraph(startDestination: String) {

    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    val showBars = when (currentRoute) {
        Route.HomeScreen.route,
        Route.ProfileScreen.route,
        Route.ChatScreen.route,
        Route.UploadScreen.route,
        Route.ExercisesScreen.route,
        Route.NotificationsScreen.route,
        Route.Settings.route,
        Route.HistoryScreen.route,
        Route.Favorites.route,
        Route.ComplementaryHours.route,
        Route.Help.route,
        Route.SearchScreen.route,
        Route.StudyGroup.route -> true
        else -> false
    }

    val drawerState = rememberDrawerState(initialValue =DrawerValue.Closed)

    val activity = LocalContext.current as Activity
    SideEffect { activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }

    NavDrawer(navController = navController, drawerState = drawerState) {
        Scaffold(
            topBar = { if (showBars) UpperMenu(drawerState, navController) },
            bottomBar = { if (showBars) BottonBarCustom(navController) }
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = startDestination,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Route.LoginScreen.route) {
                    LoginScreen(
                        onEnterClick = { user -> navController.navigate(Route.HomeScreen.route) },
                        onNotRegistered = { navController.navigate(Route.RegisterScreen.route) }
                    )
                }
                composable(Route.RegisterScreen.route) {
                    RegisterScreen(
                        onContinueClick = { user -> navController.navigate(Route.CRegisterScreen.route) },
                        onHasAccount = { user -> navController.navigate(Route.LoginScreen.route) }
                    )
                }
                composable(Route.HomeScreen.route) {
                    HomeScreen()
                }
                composable(Route.CRegisterScreen.route) {
                    ContinueRegisterScreen()
                }
                composable(Route.ProfileScreen.route) {
                    ProfileScreen()
                }
                composable(Route.ChatScreen.route){
                    ChatScreen()
                }
                composable(Route.UploadScreen.route){
                    UploadScreen()
                }
                composable(Route.SearchScreen.route){
                    SearchScreen()
                }
                composable(Route.NotificationsScreen.route) {
                    NotificationScreen()
                }
                composable(Route.Settings.route) {
                    SettingsScreen(navController = navController)
                }
                composable(Route.HistoryScreen.route) {
                    HistoryScreen()
                }
                composable(Route.StudyGroup.route){
                    StudyGroupScreen()
                }
                composable(Route.Favorites.route){
                    FavoritesScreen()
                }
                composable(Route.ComplementaryHours.route){
                    CompHoursScreen()
                }
                composable(Route.Help.route){
                    HelpScreen()
                }
                composable(Route.ExercisesScreen.route){
                    ExercisesScreen()
                }
                composable(Route.NotificationSettingsScreen.route) {
                    NotificationSettingsScreen(navController = navController)
                }

            }
        }
    }
}


