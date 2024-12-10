package com.example.qufc.navigation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qufc.R
import com.example.qufc.navigation.Route
import com.example.qufc.screens.loginRegister.register.fontModak
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpperMenu(drawerState: DrawerState, navController: NavController){

    TopAppBar(
        navigationIcon = {
            val coroutineScope = rememberCoroutineScope()
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
                    .padding(start = 16.dp)
            )
        },

        title = {
            Text(text = "QUFC",
                fontFamily = fontModak,
                fontSize = 29.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 6.dp)
            ) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.bgColor)
        ),

        actions = {

            var isExpanded by remember{ mutableStateOf(false) }

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificações",
                modifier = Modifier.padding(end = 10.dp)
                    .clickable { navController.navigate(Route.NotificationsScreen.route) },
                tint = Color.White,
            )

            IconButton(onClick = {isExpanded = true}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "menu três pontinhos",
                    tint = Color.White
                    )
            }
        }
    )
}

@Preview
@Composable
fun SideMenuPreview(){

}