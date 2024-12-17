package com.example.qufc.navigation

sealed class
Route(val route: String) {
    data object HomeScreen: Route(route = "home")
    data object LoginScreen: Route(route = "login")
    data object RegisterScreen: Route(route = "register")
    data object CRegisterScreen: Route(route = "continueRegister")
    data object SearchScreen: Route(route = "search")
    data object UploadScreen: Route(route = "upload")
    data object ChatScreen: Route(route = "chat")
    data object ProfileScreen: Route("profile")
    data object ExercisesScreen: Route(route = "exercises")
    data object NotificationsScreen: Route(route = "notifications")
    data object Settings: Route(route = "settings")
    data object HistoryScreen:Route(route = "history")
    data object StudyGroup:Route(route = "studyGroup")
    data object Favorites:Route(route = "favorites")
    data object ComplementaryHours:Route(route = "complementaryHours")
    data object Help:Route(route = "help")
    object NotificationSettingsScreen : Route(route = "notificationSettings")
}