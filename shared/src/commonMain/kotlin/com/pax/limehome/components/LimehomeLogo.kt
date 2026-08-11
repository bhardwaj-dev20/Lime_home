package com.pax.limehome.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.pax.limehome.theme.LimehomeTeal

@Composable
fun LimehomeLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        // 1. Draw the primary teal background square
        drawRect(
            color = LimehomeTeal,
            size = size
        )

        // 2. Draw the top-middle white cutout path
        val topPath = Path().apply {
            moveTo(w * 0.38f, 0f)
            lineTo(w * 0.38f, h * 0.44f)
            lineTo(w * 0.62f, h * 0.44f)
            // Curved inner edge of the right pillar: curves to (w * 0.84, 0)
            quadraticTo(
                w * 0.62f, h * 0.08f, // control point
                w * 0.84f, 0f       // end point
            )
            close()
        }
        drawPath(
            path = topPath,
            color = Color.White
        )

        // 3. Draw the bottom-middle white cutout path
        val bottomPath = Path().apply {
            moveTo(w * 0.62f, h)
            lineTo(w * 0.62f, h * 0.56f)
            lineTo(w * 0.38f, h * 0.56f)
            // Curved inner edge of the left pillar: curves to (w * 0.16, h)
            quadraticTo(
                w * 0.38f, h * 0.92f, // control point
                w * 0.16f, h        // end point
            )
            close()
        }
        drawPath(
            path = bottomPath,
            color = Color.White
        )
    }
}
