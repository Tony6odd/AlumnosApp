package com.roja.appalumnos.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubjectDetailsScreen(subjectName: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.surface,
                    MaterialTheme.colorScheme.primary
                ),
                startY = 0f,
                endY = 1000f
            )
        )) {

        Column (modifier = Modifier.padding(80.dp)) {


            Text(text = "Detalles de $subjectName", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Text(text = "", fontSize = 18.sp)
            Text(text = "Calificacio del Segundo Parcial: 9", fontSize = 18.sp)
            Text(text = "Calificacio del Segundo Parcial: 9", fontSize = 18.sp)
            Text(text = "Calificacin del Tercer Parcial: 9", fontSize = 18.sp)
        }
    }
}
