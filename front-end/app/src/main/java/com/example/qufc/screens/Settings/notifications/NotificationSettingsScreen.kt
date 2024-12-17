package com.example.qufc.screens.settings.notifications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qufc.screens.Settings.notifications.components.NotificationSwitch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationSettingsScreen(navController: NavController) {
    // Estados para os switches
    var notifyMessages by remember { mutableStateOf(false) }
    var notifyGroups by remember { mutableStateOf(false) }
    var notifyVideos by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // TopAppBar
        TopAppBar(
            title = { Text("Notificações", color = Color.White, fontSize = 20.sp) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF005B99))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Switches
        NotificationSwitch(
            title = "Notificar mensagens",
            isChecked = notifyMessages,
            onCheckedChange = { isChecked -> notifyMessages = isChecked }
        )

        NotificationSwitch(
            title = "Notificar grupos de estudo",
            isChecked = notifyGroups,
            onCheckedChange = { isChecked -> notifyGroups = isChecked }
        )

        NotificationSwitch(
            title = "Notificar vídeos",
            isChecked = notifyVideos,
            onCheckedChange = { isChecked -> notifyVideos = isChecked }
        )
    }
}
