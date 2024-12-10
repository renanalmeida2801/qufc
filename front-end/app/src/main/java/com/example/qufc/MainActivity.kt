package com.example.qufc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.qufc.ui.theme.QufcTheme
import com.example.qufc.navigation.NavGraph
import com.example.qufc.navigation.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QufcTheme {
                NavGraph(startDestination =  Route.LoginScreen.route)
            }
        }
    }
}

