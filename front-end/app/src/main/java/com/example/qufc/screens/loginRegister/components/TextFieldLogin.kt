package com.example.qufc.screens.loginRegister.components


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldLogin(value: String, text: String, modifier: Modifier = Modifier , onValueChange: (String) -> Unit){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = text) },
        shape = RoundedCornerShape(22.dp),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent, // Hide the line when unfocused
            focusedIndicatorColor = Color.Transparent,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedLabelColor = Color.Transparent
        ),
        modifier = modifier
    )
}