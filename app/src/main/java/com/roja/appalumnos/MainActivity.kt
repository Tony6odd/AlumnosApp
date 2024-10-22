package com.roja.appalumnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roja.appalumnos.models.BottomNavigationItem
import com.roja.appalumnos.ui.components.BottomNavigationBar
import com.roja.appalumnos.ui.screens.CalificacionesScreen
import com.roja.appalumnos.ui.screens.HomeScreen
import com.roja.appalumnos.ui.screens.MonthPayment
import com.roja.appalumnos.ui.screens.PagosScreen
import com.roja.appalumnos.ui.screens.PerfilScreen
import com.roja.appalumnos.ui.screens.Student
import com.roja.appalumnos.ui.screens.Subject
import com.roja.appalumnos.ui.screens.SubjectDetailsScreen
import com.roja.appalumnos.ui.theme.AppAlumnosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppAlumnosTheme {
                val navController = rememberNavController()
                var currentRoute by rememberSaveable { mutableStateOf("home") }
                var selectedItem by rememberSaveable { mutableStateOf(0) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = "home") {
                        composable(route = "home") { HomeScreen(navController) }
                        composable(route = "configuracion") { PerfilScreen() }
                        composable(route = "calificaciones") {
                            CalificacionesScreen(
                                student = Student(
                                    name = "Juan Pérez",
                                    career = "Ingeniería en Sistemas",
                                    semester = "Segundo Semestre",
                                    cumulativeAverage = 8.5f,
                                    materias = listOf(
                                        Subject(name = "Matemáticas", average = 9.0f),
                                        Subject(name = "Programación", average = 8.5f),
                                        Subject(name = "Física", average = 9.2f)
                                    )
                                ),
                                onSubjectClick = { subjectName ->
                                    // Navega a la pantalla de detalles de la materia
                                    navController.navigate("subject_details/$subjectName")
                                }
                            )
                        }
                        composable(route = "pagos") {
                            // Crear la lista de pagos
                            val pagos = listOf(
                                MonthPayment(month = "Enero", isPaid = true),
                                MonthPayment(month = "Febrero", isPaid = true),
                                MonthPayment(month = "Marzo", isPaid = false),
                                MonthPayment(month = "Abril", isPaid = true),
                                MonthPayment(month = "Mayo", isPaid = false),
                                MonthPayment(month = "Junio", isPaid = false)
                            )
                            PagosScreen(pagos = pagos) // Aquí pasamos la lista de pagos
                        }
                        composable(route = "subject_details/{subjectName}") { backStackEntry ->
                            val subjectName = backStackEntry.arguments?.getString("subjectName")
                            SubjectDetailsScreen(subjectName = subjectName ?: "Sin Nombre")
                        }
                    }
                }
            }
        }
    }
}
