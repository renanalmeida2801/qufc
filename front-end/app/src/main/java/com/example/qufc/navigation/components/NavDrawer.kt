package com.example.qufc.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.qufc.screens.loginRegister.register.fontModak
import kotlinx.coroutines.launch
import com.example.qufc.R

@Composable
fun NavDrawer(
    navController: NavController,
    drawerState: DrawerState,
    scaffold: @Composable () -> Unit,
) {

    val coroutineScope = rememberCoroutineScope()
    val menuItems = getMenuItems()

    ModalNavigationDrawer(
        // Aqui é criado o menu lateral que lista as telas
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = colorResource(R.color.bgColor)) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.bgColor))
                        .padding(vertical = 64.dp),
                ){
                    Text(text = "QUFC", fontFamily = fontModak, fontSize = 30.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.padding(top = 20.dp))

                menuItems.forEach(){ item ->
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = colorResource(R.color.bgColor)),
                        icon = {
                            Icon(
                                painter = item.icon,
                                contentDescription = item.tittle,
                                modifier = Modifier.size(16.dp),
                                tint = Color.White
                            )
                        },
                        label = {Text(text = item.tittle, color = Color.White)},
                        selected = false,
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            navController.navigate(item.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
       scaffold()
    }
}