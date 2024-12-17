package com.example.qufc.navigation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.qufc.R
import com.example.qufc.navigation.Route

data class MenuItem(
    val tittle: String,
    val icon: Painter,
    val route: String
)

@Composable
fun getMenuItems(): List<MenuItem> {


    return listOf(
        MenuItem(
            tittle = "Simulados",
            route = Route.ExercisesScreen.route,
            icon = painterResource(id = R.drawable.exerciseicon)
        ),
        MenuItem(
            tittle = "Grupos de Estudos",
            route = Route.StudyGroup.route,
            icon = painterResource(id = R.drawable.groupicon)
        ),
        MenuItem(
            tittle = "History",
            route = Route.HistoryScreen.route,
            icon = painterResource(id = R.drawable.history)
        ),
        MenuItem(
            tittle = "Favoritos",
            route = Route.Favorites.route,
            icon = painterResource(id = R.drawable.favoriteicon)
        ),
        MenuItem(
            tittle = "Horas Complementares",
            route = Route.ComplementaryHours.route,
            icon = painterResource(id = R.drawable.exerciseicon)
        ),
        MenuItem(
            tittle = "Configurações",
            route = Route.Settings.route,
            icon = painterResource(id = R.drawable.settingsicon)
        ),
        MenuItem(
            tittle = "Ajuda",
            route = Route.Help.route,
            icon = painterResource(id = R.drawable.helpicon)
        ),
        MenuItem(
            tittle = "Sair",
            route = "sair",
            icon = painterResource(id = R.drawable.exiticon)
        ),

        )

}