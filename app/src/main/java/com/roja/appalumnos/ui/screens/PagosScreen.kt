package com.roja.appalumnos.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

data class MonthPayment(val month: String, val isPaid: Boolean)

@Composable
fun PagosScreen(pagos: List<MonthPayment>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(

            text = "Historial de Pagos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(bottom = 24.dp, top = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Lista de pagos
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pagos) { pago ->
                PaymentMonthCard(pago)
            }
        }
    }
}

@Composable
fun PaymentMonthCard(payment: MonthPayment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (payment.isPaid) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Pagado",
                    tint = Color.Green,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Pendiente",
                    tint = Color.Red,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = payment.month,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ExamplePagosScreen() {
    val pagos = listOf(
        MonthPayment(month = "Enero", isPaid = true),
        MonthPayment(month = "Febrero", isPaid = true),
        MonthPayment(month = "Marzo", isPaid = false),
        MonthPayment(month = "Abril", isPaid = true),
        MonthPayment(month = "Mayo", isPaid = false),
        MonthPayment(month = "Junio", isPaid = false)
    )

    PagosScreen(pagos = pagos)
}
