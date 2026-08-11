package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

// --- Custom Icons for Help Screen ---

@Composable
private fun LifePreserverIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 2f.dp.toPx()
        val cx = w * 0.5f
        val cy = h * 0.5f

        // Outer circle
        drawCircle(
            color = LimehomeTeal,
            radius = w * 0.42f,
            center = androidx.compose.ui.geometry.Offset(cx, cy),
            style = Stroke(width = stroke)
        )
        // Inner circle
        drawCircle(
            color = LimehomeTeal,
            radius = w * 0.22f,
            center = androidx.compose.ui.geometry.Offset(cx, cy),
            style = Stroke(width = stroke)
        )

        // Cross straps (4 lines connecting inner to outer)
        // Top
        drawLine(LimehomeTeal, androidx.compose.ui.geometry.Offset(cx, cy - w * 0.22f), androidx.compose.ui.geometry.Offset(cx, cy - w * 0.42f), strokeWidth = stroke * 1.5f)
        // Bottom
        drawLine(LimehomeTeal, androidx.compose.ui.geometry.Offset(cx, cy + w * 0.22f), androidx.compose.ui.geometry.Offset(cx, cy + w * 0.42f), strokeWidth = stroke * 1.5f)
        // Left
        drawLine(LimehomeTeal, androidx.compose.ui.geometry.Offset(cx - w * 0.22f, cy), androidx.compose.ui.geometry.Offset(cx - w * 0.42f, cy), strokeWidth = stroke * 1.5f)
        // Right
        drawLine(LimehomeTeal, androidx.compose.ui.geometry.Offset(cx + w * 0.22f, cy), androidx.compose.ui.geometry.Offset(cx + w * 0.42f, cy), strokeWidth = stroke * 1.5f)
    }
}

@Composable
private fun BackArrowIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.65f, h * 0.2f)
            lineTo(w * 0.3f, h * 0.5f)
            lineTo(w * 0.65f, h * 0.8f)
        }
        drawPath(path = path, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun FAQIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        // Chat bubble outline
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.05f, w * 0.05f),
            size = androidx.compose.ui.geometry.Size(w * 0.9f, h * 0.65f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val tail = Path().apply {
            moveTo(w * 0.25f, h * 0.7f)
            lineTo(w * 0.25f, h * 0.9f)
            lineTo(w * 0.42f, h * 0.7f)
        }
        drawPath(path = tail, color = color, style = Stroke(width = stroke))
        // Question mark inside
        drawCircle(color = color, radius = w * 0.03f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.56f))
        val qPath = Path().apply {
            moveTo(w * 0.38f, h * 0.25f)
            quadraticTo(w * 0.38f, h * 0.14f, w * 0.5f, h * 0.14f)
            quadraticTo(w * 0.62f, h * 0.14f, w * 0.62f, h * 0.28f)
            quadraticTo(w * 0.62f, h * 0.38f, w * 0.5f, h * 0.42f)
            lineTo(w * 0.5f, h * 0.48f)
        }
        drawPath(path = qPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun InfoCircleIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.4f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            style = Stroke(width = stroke)
        )
        // question mark
        drawCircle(color = color, radius = w * 0.04f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.32f))
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.42f), androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.68f), strokeWidth = stroke)
    }
}

@Composable
private fun HeadsetIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        // Headband arc
        drawArc(
            color = color,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.1f),
            size = androidx.compose.ui.geometry.Size(w * 0.7f, h * 0.55f),
            style = Stroke(width = stroke)
        )
        // Left earpiece
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.12f, h * 0.4f),
            size = androidx.compose.ui.geometry.Size(w * 0.15f, h * 0.35f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        // Right earpiece
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.73f, h * 0.4f),
            size = androidx.compose.ui.geometry.Size(w * 0.15f, h * 0.35f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        // Mic arm
        val micPath = Path().apply {
            moveTo(w * 0.88f, h * 0.75f)
            quadraticTo(w * 0.88f, h * 0.92f, w * 0.68f, h * 0.92f)
        }
        drawPath(path = micPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun NoDeskIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        // Speech bubble with exclamation
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.1f, w * 0.1f),
            size = androidx.compose.ui.geometry.Size(w * 0.8f, h * 0.6f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val tail = Path().apply {
            moveTo(w * 0.3f, h * 0.7f)
            lineTo(w * 0.3f, h * 0.88f)
            lineTo(w * 0.45f, h * 0.7f)
        }
        drawPath(path = tail, color = color, style = Stroke(width = stroke))
        // Exclamation line
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.25f), androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.47f), strokeWidth = stroke)
        drawCircle(color = color, radius = w * 0.03f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.56f))
    }
}

@Composable
private fun PhoneIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.05f),
            size = androidx.compose.ui.geometry.Size(w * 0.5f, h * 0.9f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
            style = Stroke(width = stroke)
        )
        drawCircle(color = color, radius = w * 0.04f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.82f))
    }
}

@Composable
private fun WhatsAppIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.4f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.48f),
            style = Stroke(width = stroke)
        )
        // Phone inside
        val phonePath = Path().apply {
            moveTo(w * 0.35f, h * 0.65f)
            quadraticTo(w * 0.2f, h * 0.85f, w * 0.25f, h * 0.78f)
            quadraticTo(w * 0.18f, h * 0.6f, w * 0.3f, h * 0.42f)
            quadraticTo(w * 0.42f, h * 0.28f, w * 0.6f, h * 0.28f)
            quadraticTo(w * 0.78f, h * 0.28f, w * 0.78f, h * 0.45f)
            quadraticTo(w * 0.78f, h * 0.55f, w * 0.65f, h * 0.55f)
            lineTo(w * 0.58f, h * 0.55f)
            lineTo(w * 0.48f, h * 0.65f)
            close()
        }
        drawPath(path = phonePath, color = color, style = Stroke(width = stroke * 0.8f))
    }
}

@Composable
private fun AtIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        // Outer circle
        drawCircle(
            color = color,
            radius = w * 0.38f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            style = Stroke(width = stroke)
        )
        // Inner circle
        drawCircle(
            color = color,
            radius = w * 0.16f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            style = Stroke(width = stroke)
        )
        // At tail
        val atPath = Path().apply {
            moveTo(w * 0.66f, h * 0.38f)
            lineTo(w * 0.66f, h * 0.6f)
            quadraticTo(w * 0.72f, h * 0.65f, w * 0.82f, h * 0.58f)
        }
        drawPath(path = atPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun CallIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val phonePath = Path().apply {
            moveTo(w * 0.2f, h * 0.15f)
            lineTo(w * 0.38f, h * 0.15f)
            lineTo(w * 0.42f, h * 0.35f)
            lineTo(w * 0.3f, h * 0.42f)
            quadraticTo(w * 0.4f, h * 0.6f, w * 0.58f, h * 0.7f)
            lineTo(w * 0.65f, h * 0.58f)
            lineTo(w * 0.85f, h * 0.62f)
            lineTo(w * 0.85f, h * 0.78f)
            quadraticTo(w * 0.85f, h * 0.88f, w * 0.72f, h * 0.88f)
            quadraticTo(w * 0.3f, h * 0.88f, w * 0.15f, h * 0.45f)
            quadraticTo(w * 0.1f, h * 0.25f, w * 0.2f, h * 0.15f)
            close()
        }
        drawPath(path = phonePath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun HelpChevronRight(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.3f, h * 0.25f)
            lineTo(w * 0.7f, h * 0.5f)
            lineTo(w * 0.3f, h * 0.75f)
        }
        drawPath(path = path, color = color, style = Stroke(width = stroke))
    }
}

@Composable
private fun HelpMenuItemRow(
    icon: @Composable () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { /* Handle click */ }
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF0F172A),
            fontFamily = PoppinsFontFamily(),
            modifier = Modifier.weight(1f)
        )
        HelpChevronRight(modifier = Modifier.size(12.dp))
    }
}

@Composable
fun HelpScreen(onBack: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
            .statusBarsPadding()
    ) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
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
                BackArrowIcon(modifier = Modifier.size(20.dp))
            }

            Text(
                text = "Help & FAQs",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Scrollable Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .navigationBarsPadding()
        ) {
            // Header: Life preserver + greeting
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF1F5F9)),
                    contentAlignment = Alignment.Center
                ) {
                    LifePreserverIcon(modifier = Modifier.size(36.dp))
                }

                Column {
                    Text(
                        text = "Hi,",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                    Text(
                        text = "how can we help?",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }
            }

            // HELP CENTER Section
            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 6.dp)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "HELP CENTER",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "If you have a specific question or need help resolving a problem, please check our FAQs or contact us",
                    fontSize = 14.sp,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 20.sp,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                HelpMenuItemRow(
                    icon = { FAQIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A)) },
                    title = "Frequently asked questions"
                )

                HelpMenuItemRow(
                    icon = { InfoCircleIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A)) },
                    title = "How it works"
                )
            }

            // GOOD TO KNOW Section
            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 6.dp)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "GOOD TO KNOW",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Green info card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFE2F3F2))
                        .padding(horizontal = 20.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        HeadsetIcon(modifier = Modifier.size(24.dp), color = LimehomeTeal)
                        Text(
                            text = "24/7 Customer support",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = LimehomeTeal,
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        NoDeskIcon(modifier = Modifier.size(24.dp), color = LimehomeTeal)
                        Text(
                            text = "No reception desk needed",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = LimehomeTeal,
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        PhoneIcon(modifier = Modifier.size(24.dp), color = LimehomeTeal)
                        Text(
                            text = "Contactless check-in",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = LimehomeTeal,
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                }
            }

            // CONTACT US Section
            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 6.dp)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = "CONTACT US",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                HelpMenuItemRow(
                    icon = { WhatsAppIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A)) },
                    title = "WhatsApp: +498937040136"
                )

                HorizontalDivider(
                    color = Color(0xFFF1F5F9),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                HelpMenuItemRow(
                    icon = { AtIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A)) },
                    title = "Email us"
                )

                HorizontalDivider(
                    color = Color(0xFFF1F5F9),
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                HelpMenuItemRow(
                    icon = { CallIcon(modifier = Modifier.size(24.dp), color = Color(0xFF0F172A)) },
                    title = "Call us: +498941207807"
                )
            }

            // FEEDBACK Section
            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 6.dp)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(top = 16.dp, bottom = 24.dp)
            ) {
                Text(
                    text = "FEEDBACK",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                HelpMenuItemRow(
                    icon = {
                        Canvas(modifier = Modifier.size(24.dp)) {
                            val w = size.width
                            val h = size.height
                            val stroke = 1.8f.dp.toPx()
                            drawRoundRect(
                                color = Color(0xFF0F172A),
                                topLeft = androidx.compose.ui.geometry.Offset(w * 0.1f, h * 0.1f),
                                size = androidx.compose.ui.geometry.Size(w * 0.8f, h * 0.65f),
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
                                style = Stroke(width = stroke)
                            )
                            val tail = Path().apply {
                                moveTo(w * 0.3f, h * 0.75f)
                                lineTo(w * 0.3f, h * 0.9f)
                                lineTo(w * 0.45f, h * 0.75f)
                            }
                            drawPath(path = tail, color = Color(0xFF0F172A), style = Stroke(width = stroke))
                            // Check mark
                            val check = Path().apply {
                                moveTo(w * 0.35f, h * 0.42f)
                                lineTo(w * 0.48f, h * 0.55f)
                                lineTo(w * 0.68f, h * 0.28f)
                            }
                            drawPath(path = check, color = Color(0xFF0F172A), style = Stroke(width = stroke))
                        }
                    },
                    title = "Leave us feedback"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
