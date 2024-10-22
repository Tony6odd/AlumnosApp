package com.roja.appalumnos.models

import android.graphics.drawable.Icon
import android.view.inspector.InspectionCompanion
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import okhttp3.Route

data class BottomNavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    companion object{
        val items = listOf(
            BottomNavigationItem(route = "home", title = "Home", icon = Icons.Default.Home),
            BottomNavigationItem(route = "calificaciones", title = "Calificaciones", icon = Icons.Default.Star),
            BottomNavigationItem(route = "pagos", title = "Pagos", icon = Icons.Default.ShoppingCart),
            BottomNavigationItem(route = "configuracion", title = "Configuracion", icon = Icons.Default.AccountCircle),

        )
    }

}
