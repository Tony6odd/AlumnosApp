package com.roja.appalumnos.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Subject(val name: String, val average: Float)

data class Student(
    val name: String,
    val career: String,
    val semester: String,
    val cumulativeAverage: Float,
    val materias: List<Subject>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalificacionesScreen(student: Student, onSubjectClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.surface,
                        MaterialTheme.colorScheme.primary
                    ),
                    startY = 0f,
                    endY = 1000f
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.padding(top = 37.dp), contentAlignment = Alignment.Center){
            Text(text = "Calificaciones de ${student.name}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Carrera: ${student.career}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "${student.semester}", fontSize = 16.sp)
            Text(text = "Promedio Acumulado: ${student.cumulativeAverage}", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Materias Cursadas", fontSize = 22.sp, fontWeight = FontWeight.Bold)

            LazyColumn {
                items(student.materias) { subject ->
                    SubjectCard(subject = subject, onClick = { onSubjectClick(subject.name) })
                }
            }
        }
    }
}

@Composable
fun SubjectCard(subject: Subject, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Lock, contentDescription = "Subject Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = subject.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "Promedio: ${subject.average}", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ExampleCalificacionesScreen() {
    val student = Student(
        name = "Juan Pérez",
        career = "Ingeniería en Sistemas",
        semester = "6to Semestre",
        cumulativeAverage = 8.5f,
        materias = listOf(
            Subject(name = "Matemáticas", average = 9.0f),
            Subject(name = "Programación", average = 8.5f),
            Subject(name = "Física", average = 9.2f)
        )
    )
}
