package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White

data class LanguageOption(val code: String, val name: String, val flag: String)

@Composable
private fun LanguageBackArrow(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.65f, h * 0.25f)
            lineTo(w * 0.35f, h * 0.5f)
            lineTo(w * 0.65f, h * 0.75f)
        }
        drawPath(path = path, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun LanguageSettingsScreen(
    currentLanguageCode: String,
    onSaveLanguage: (String) -> Unit,
    onBack: () -> Unit
) {
    val languages = listOf(
        LanguageOption("DE", "Deutsch", "🇩🇪"),
        LanguageOption("EN", "English", "🇬🇧"),
        LanguageOption("ES", "Español", "🇪🇸"),
        LanguageOption("FR", "Français", "🇫🇷"),
        LanguageOption("IT", "Italiano", "🇮🇹"),
        LanguageOption("PT", "Português", "🇵🇹")
    )

    var selectedLanguageCode by remember { mutableStateOf(currentLanguageCode) }
    val selectedLanguage = languages.find { it.code == selectedLanguageCode } ?: languages[1]
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
    ) {
        // Top Toolbar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                LanguageBackArrow(modifier = Modifier.size(20.dp))
            }

            Text(
                text = "Language",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

        // Scrollable area
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(scrollState)
        ) {
            // Header instructions
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "LANGUAGE",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Your preferred language",
                    fontSize = 15.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = selectedLanguage.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )
            }

            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

            Spacer(modifier = Modifier.height(8.dp))

            // Language List items
            languages.forEach { language ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedLanguageCode = language.code }
                        .padding(horizontal = 24.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = language.flag,
                            fontSize = 26.sp
                        )

                        Text(
                            text = language.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                    }

                    RadioButton(
                        selected = (selectedLanguageCode == language.code),
                        onClick = { selectedLanguageCode = language.code },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = LimehomeTeal,
                            unselectedColor = Color(0xFFCBD5E1)
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }

        // Save Button at bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Button(
                onClick = {
                    // API Call Placeholder: Save user language preference
                    // Example: if (isLoggedIn) apiService.updateUserLanguage(selectedLanguageCode)
                    onSaveLanguage(selectedLanguageCode)
                    onBack()
                },
                colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = "Save",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = PoppinsFontFamily()
                )
            }
        }
    }
}
