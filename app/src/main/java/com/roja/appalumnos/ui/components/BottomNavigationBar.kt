package com.roja.appalumnos.ui.components

import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.roja.appalumnos.models.BottomNavigationItem

@Composable
fun BottomNavigationBar(navController : NavController) {
    var currentRoute by rememberSaveable { mutableStateOf("home") }
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar (containerColor = Color.White){
    BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->

            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(bottomNavigationItem.route)


                },
                label = { Text(bottomNavigationItem.title) }, icon = { Icon(bottomNavigationItem.icon, contentDescription = bottomNavigationItem.title) }
            )

        }
    }

}
