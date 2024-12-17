package com.example.qufc.screens.Settings.notifications.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun SettingsItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    titleColor: Color = Color.Black,   // Adicionando parâmetro para cor do título
    iconColor: Color = Color.Black     // Adicionando parâmetro para cor do ícone
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor, // Aplica cor do ícone
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            color = titleColor, // Aplica cor do título
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}