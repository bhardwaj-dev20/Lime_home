package com.pax.limehome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White
import com.pax.limehome.components.LimehomeLogo
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        // API Call Placeholder: Check for user session or app version update
        // Example: val sessionValid = apiService.validateSession()

        delay(2000) // 2 seconds splash
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LimehomeLogo(modifier = Modifier.size(76.dp))
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "LIMEHOME",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 6.sp,
                fontFamily = PoppinsFontFamily(),
                color = Color(0xFF0F172A) // Sleek dark slate color for premium look
            )
        }
    }
}

