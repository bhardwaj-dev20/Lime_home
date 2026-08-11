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

// --- Custom Icons ---

@Composable
private fun NotificationsBackArrow(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
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
private fun BellOutlineIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.08f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.15f),
            style = Stroke(width = stroke)
        )
        val bodyPath = Path().apply {
            moveTo(w * 0.35f, h * 0.65f)
            quadraticTo(w * 0.35f, h * 0.28f, w * 0.5f, h * 0.28f)
            quadraticTo(w * 0.65f, h * 0.28f, w * 0.65f, h * 0.65f)
            lineTo(w * 0.75f, h * 0.68f)
            lineTo(w * 0.25f, h * 0.68f)
            close()
        }
        drawPath(path = bodyPath, color = color, style = Stroke(width = stroke))
        drawCircle(
            color = color,
            radius = w * 0.06f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.75f)
        )
    }
}

@Composable
private fun RealTimeUpdatesIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.6f.dp.toPx()
        val cx = w * 0.5f
        val cy = h * 0.5f

        // Clock arc (anticlockwise arrow representing history/updates)
        drawArc(
            color = color,
            startAngle = 40f,
            sweepAngle = 280f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.15f),
            size = androidx.compose.ui.geometry.Size(w * 0.7f, h * 0.7f),
            style = Stroke(width = stroke)
        )

        // Arrow head at startAngle
        val arrow = Path().apply {
            moveTo(w * 0.85f, h * 0.36f)
            lineTo(w * 0.73f, h * 0.44f)
            lineTo(w * 0.88f, h * 0.54f)
        }
        drawPath(arrow, color, style = Stroke(width = stroke))

        // Clock hands
        drawLine(color, androidx.compose.ui.geometry.Offset(cx, cy), androidx.compose.ui.geometry.Offset(cx, cy - h * 0.2f), strokeWidth = stroke)
        drawLine(color, androidx.compose.ui.geometry.Offset(cx, cy), androidx.compose.ui.geometry.Offset(cx + w * 0.15f, cy + h * 0.08f), strokeWidth = stroke)
    }
}

@Composable
private fun AccessCodeIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.6f.dp.toPx()

        // Phone container
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.1f),
            size = androidx.compose.ui.geometry.Size(w * 0.5f, h * 0.8f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
            style = Stroke(width = stroke)
        )

        // Speaker line
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.18f), androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.18f), strokeWidth = stroke)

        // Keypad grid simulation (lines/points)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.32f), androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.32f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.48f, h * 0.32f), androidx.compose.ui.geometry.Offset(w * 0.52f, h * 0.32f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.32f), androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.32f), strokeWidth = stroke * 1.2f)

        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.44f), androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.44f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.48f, h * 0.44f), androidx.compose.ui.geometry.Offset(w * 0.52f, h * 0.44f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.44f), androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.44f), strokeWidth = stroke * 1.2f)

        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.56f), androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.56f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.48f, h * 0.56f), androidx.compose.ui.geometry.Offset(w * 0.52f, h * 0.56f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.56f), androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.56f), strokeWidth = stroke * 1.2f)

        // Circle button at bottom
        drawCircle(color = color, radius = w * 0.04f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.78f), style = Stroke(width = stroke))
    }
}

@Composable
private fun BookingRemindersIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.6f.dp.toPx()

        // Calendar shape
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.18f, h * 0.2f),
            size = androidx.compose.ui.geometry.Size(w * 0.64f, h * 0.64f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        // Top bar separator
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.18f, h * 0.38f), androidx.compose.ui.geometry.Offset(w * 0.82f, h * 0.38f), strokeWidth = stroke)

        // Tiny binders
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.32f, h * 0.12f), androidx.compose.ui.geometry.Offset(w * 0.32f, h * 0.25f), strokeWidth = stroke * 1.2f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.68f, h * 0.12f), androidx.compose.ui.geometry.Offset(w * 0.68f, h * 0.25f), strokeWidth = stroke * 1.2f)

        // Clock badge at bottom right
        drawCircle(
            color = White,
            radius = w * 0.22f,
            center = androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.72f)
        )
        drawCircle(
            color = color,
            radius = w * 0.22f,
            center = androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.72f),
            style = Stroke(width = stroke)
        )
        // Clock hands
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.72f), androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.62f), strokeWidth = stroke * 0.8f)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.72f), androidx.compose.ui.geometry.Offset(w * 0.82f, h * 0.72f), strokeWidth = stroke * 0.8f)
    }
}

@Composable
private fun DealsBadgeIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.6f.dp.toPx()

        // Spiky circular badge
        val path = Path()
        val numPoints = 12
        val outerRadius = w * 0.42f
        val innerRadius = w * 0.33f
        val cx = w * 0.5f
        val cy = h * 0.5f
        for (i in 0 until numPoints * 2) {
            val angle = (i * Math.PI / numPoints).toFloat()
            val r = if (i % 2 == 0) outerRadius else innerRadius
            val x = cx + r * kotlin.math.cos(angle)
            val y = cy + r * kotlin.math.sin(angle)
            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        path.close()
        drawPath(path = path, color = color, style = Stroke(width = stroke))

        // Percent sign % inside badge
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.62f, h * 0.38f), androidx.compose.ui.geometry.Offset(w * 0.38f, h * 0.62f), strokeWidth = stroke * 0.8f)
        drawCircle(color = color, radius = w * 0.05f, center = androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.42f), style = Stroke(width = stroke * 0.8f))
        drawCircle(color = color, radius = w * 0.05f, center = androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.58f), style = Stroke(width = stroke * 0.8f))
    }
}

@Composable
fun NotificationSettingsScreen(onBack: () -> Unit) {
    val scrollState = rememberScrollState()
    var notificationsEnabled by remember { mutableStateOf(true) }

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
                NotificationsBackArrow(modifier = Modifier.size(20.dp))
            }

            Text(
                text = "Notification settings",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            // Main switch block
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    BellOutlineIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A))
                    Text(
                        text = "Turn on notifications",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { 
                        notificationsEnabled = it
                        // API Call Placeholder: Sync notification settings with server
                        // Example: apiService.updateNotificationSettings(enabled = it)
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = White,
                        checkedTrackColor = LimehomeTeal,
                        uncheckedThumbColor = Color(0xFF94A3B8),
                        uncheckedTrackColor = Color(0xFFE2E8F0)
                    )
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Stay on top of your trip - get booking updates, access codes, reminders, and exclusive deals.",
                fontSize = 15.sp,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Teal Box with specific features list
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFE2F3F2))
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Item 1: Real-time booking updates
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    RealTimeUpdatesIcon(modifier = Modifier.size(24.dp))
                    Text(
                        text = "Real-time booking updates",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LimehomeTeal,
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // Item 2: Access code notifications
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    AccessCodeIcon(modifier = Modifier.size(24.dp))
                    Text(
                        text = "Access code notifications",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LimehomeTeal,
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // Item 3: Booking reminders
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    BookingRemindersIcon(modifier = Modifier.size(24.dp))
                    Text(
                        text = "Booking reminders",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LimehomeTeal,
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // Item 4: Deals, recommendations, and more
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    DealsBadgeIcon(modifier = Modifier.size(24.dp))
                    Text(
                        text = "Deals, recommendations, and more",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = LimehomeTeal,
                        fontFamily = PoppinsFontFamily()
                    )
                }
            }
        }
    }
}
