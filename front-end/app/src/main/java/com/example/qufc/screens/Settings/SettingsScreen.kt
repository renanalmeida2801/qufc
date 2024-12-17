package com.example.qufc.screens.Settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qufc.navigation.Route
import com.example.qufc.screens.Settings.notifications.components.SettingsItem

@Composable
fun SettingsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Título da tela
        Text(
            text = "Configurações",
            color = Color(0xFF005B99),
            fontSize = 24.5.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de opções de configurações
        LazyColumn {
            item {
                SettingsItem(
                    title = "Notificações",
                    icon = Icons.Default.Notifications,
                    onClick = { navController.navigate(Route.NotificationSettingsScreen.route) },
                    titleColor = Color(0xFF005B99),  // Define a cor para o título
                    iconColor = Color(0xFF005B99)   // Define a cor para o ícone
                )
            }
        }
    }
}
