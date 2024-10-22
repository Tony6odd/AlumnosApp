package com.roja.appalumnos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun myCardFoto(nombre: String, correoInstituicional: String, fechaNacimiento: String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primary
                    ),
                    startY = 100f,
                    endY = 1000f
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Card(
                    shape = CircleShape,
                    modifier = Modifier.size(220.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = "https://png.pngtree.com/thumb_back/fh260/background/20230425/pngtree-young-professional-asian-college-man-with-glasses-image_2550347.jpg"),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 320.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = "¡ Hola $nombre !", fontWeight= FontWeight.Bold, fontSize =35.sp, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 370.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = correoInstituicional, fontSize = 20.sp, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 400.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Text(text = fechaNacimiento, fontSize = 20.sp, color = Color.White)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 600.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Editar Perfil")

                }
            }
        }

        Column(

            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier.padding(top = 0.dp).fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Cambiar Tema")

                }
            }

        }
    }
}





@Composable
fun infoAlumno(){
}

@Composable
fun PerfilScreen() {
    Column(
    ) {
        myCardFoto(nombre = "Juan Perez", correoInstituicional = "juan.perez@gmail.com", fechaNacimiento = "21/11/2000")
        infoAlumno()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PerfilScreenPreview() {
    PerfilScreen()
}

