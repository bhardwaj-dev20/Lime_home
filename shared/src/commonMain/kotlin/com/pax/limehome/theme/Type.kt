package com.pax.limehome.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import limehome.shared.generated.resources.*
import org.jetbrains.compose.resources.Font

@Composable
fun PoppinsFontFamily() = FontFamily(
    Font(Res.font.poppins_light, FontWeight.Light),
    Font(Res.font.poppins_regular, FontWeight.Normal),
    Font(Res.font.poppins_medium, FontWeight.Medium),
    Font(Res.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(Res.font.poppins_bold, FontWeight.Bold),
    Font(Res.font.poppins_extra_bold, FontWeight.ExtraBold),
)

@Composable
fun getTypography() = Typography().let { 
    val poppins = PoppinsFontFamily()
    it.copy(
        displayLarge = it.displayLarge.copy(fontFamily = poppins),
        displayMedium = it.displayMedium.copy(fontFamily = poppins),
        displaySmall = it.displaySmall.copy(fontFamily = poppins),
        headlineLarge = it.headlineLarge.copy(fontFamily = poppins),
        headlineMedium = it.headlineMedium.copy(fontFamily = poppins),
        headlineSmall = it.headlineSmall.copy(fontFamily = poppins),
        titleLarge = it.titleLarge.copy(fontFamily = poppins),
        titleMedium = it.titleMedium.copy(fontFamily = poppins),
        titleSmall = it.titleSmall.copy(fontFamily = poppins),
        bodyLarge = it.bodyLarge.copy(fontFamily = poppins),
        bodyMedium = it.bodyMedium.copy(fontFamily = poppins),
        bodySmall = it.bodySmall.copy(fontFamily = poppins),
        labelLarge = it.labelLarge.copy(fontFamily = poppins),
        labelMedium = it.labelMedium.copy(fontFamily = poppins),
        labelSmall = it.labelSmall.copy(fontFamily = poppins),
    )
}
