package com.example.qufc.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.qufc.navigation.Route

data class BottonItem(
    val tittle: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: String
)

@Composable
fun getBottonItems(): List<BottonItem>{

    val selectedHomeIcon = Icons.Filled.Home
    val unSelectedHomeIcon = Icons.Outlined.Home
    val selectedSearchIcon = Icons.Filled.Search
    val unSelectedUSearchIcon = Icons.Outlined.Search
    val selectedUploadIcon = Icons.Filled.AddCircle
    val unSelectedUploadIcon = Icons.Outlined.AddCircle
    val selectedChatIcon = Icons.Filled.Email
    val unSelectedChatIcon = Icons.Outlined.Email
    val selectedProfileIcon = Icons.Filled.AccountCircle
    val unSelectedProfileIcon = Icons.Outlined.AccountCircle

    return remember{
        listOf(
            BottonItem(
                tittle = "Home",
                selectedIcon = selectedHomeIcon,
                unSelectedIcon = unSelectedHomeIcon,
                route = Route.HomeScreen.route
            ),

            BottonItem(
                tittle = "Pesquisar",
                selectedIcon = selectedSearchIcon,
                unSelectedIcon = unSelectedUSearchIcon,
                route = Route.SearchScreen.route
            ),

            BottonItem(
                tittle = "Upload",
                selectedIcon = selectedUploadIcon,
                unSelectedIcon = unSelectedUploadIcon,
                route = Route.UploadScreen.route
            ),

            BottonItem(
                tittle = "Chat",
                selectedIcon = selectedChatIcon,
                unSelectedIcon = unSelectedChatIcon,
                route = Route.ChatScreen.route
            ),
            BottonItem(
                tittle = "Perfil",
                selectedIcon = selectedProfileIcon,
                unSelectedIcon = unSelectedProfileIcon,
                route =Route.ProfileScreen.route
            )
        )


    }
}
