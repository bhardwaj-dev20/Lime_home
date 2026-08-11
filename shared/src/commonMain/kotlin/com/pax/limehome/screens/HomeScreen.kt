package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White
import com.pax.limehome.components.LimehomeLogo
import org.jetbrains.compose.resources.painterResource
import limehome.shared.generated.resources.Res
import limehome.shared.generated.resources.highlight_berlin
import limehome.shared.generated.resources.highlight_vienna
import limehome.shared.generated.resources.highlight_madrid
import limehome.shared.generated.resources.highlight_basel

data class HighlightItem(
    val city: String,
    val street: String,
    val badge: String,
    val flag: String,
    val image: org.jetbrains.compose.resources.DrawableResource
)

@Composable
fun ExploreIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.32f,
            center = androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.42f),
            style = Stroke(width = stroke)
        )
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.65f),
            end = androidx.compose.ui.geometry.Offset(w * 0.95f, h * 0.95f),
            strokeWidth = stroke
        )
    }
}

@Composable
fun SuitcaseIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.1f, h * 0.32f),
            size = androidx.compose.ui.geometry.Size(w * 0.8f, h * 0.62f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val handlePath = Path().apply {
            moveTo(w * 0.35f, h * 0.32f)
            lineTo(w * 0.35f, h * 0.12f)
            lineTo(w * 0.65f, h * 0.12f)
            lineTo(w * 0.65f, h * 0.32f)
        }
        drawPath(path = handlePath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun ProfileIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.22f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.32f),
            style = Stroke(width = stroke)
        )
        val shouldersPath = Path().apply {
            moveTo(w * 0.18f, h * 0.85f)
            quadraticTo(w * 0.18f, h * 0.6f, w * 0.5f, h * 0.6f)
            quadraticTo(w * 0.82f, h * 0.6f, w * 0.82f, h * 0.85f)
        }
        drawPath(path = shouldersPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun BellIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
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
fun HomeHeartIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.15f)
            lineTo(w * 0.15f, h * 0.45f)
            lineTo(w * 0.15f, h * 0.85f)
            lineTo(w * 0.85f, h * 0.85f)
            lineTo(w * 0.85f, h * 0.45f)
            close()
        }
        drawPath(path = path, color = color, style = Stroke(width = stroke))
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.4f, h * 0.6f),
            size = androidx.compose.ui.geometry.Size(w * 0.2f, h * 0.25f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(2.dp.toPx()),
            style = Stroke(width = stroke)
        )
    }
}

@Composable
fun GlobeIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.38f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            style = Stroke(width = stroke)
        )
        drawOval(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.12f),
            size = androidx.compose.ui.geometry.Size(w * 0.3f, h * 0.76f),
            style = Stroke(width = stroke)
        )
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(w * 0.12f, h * 0.5f),
            end = androidx.compose.ui.geometry.Offset(w * 0.88f, h * 0.5f),
            strokeWidth = stroke
        )
    }
}

@Composable
fun FeedbackIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawRoundRect(
            color = color,
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
        drawPath(path = tail, color = color, style = Stroke(width = stroke))
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.32f),
            end = androidx.compose.ui.geometry.Offset(w * 0.75f, h * 0.32f),
            strokeWidth = stroke * 0.7f
        )
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.48f),
            end = androidx.compose.ui.geometry.Offset(w * 0.6f, h * 0.48f),
            strokeWidth = stroke * 0.7f
        )
    }
}

@Composable
fun DocumentIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val docPath = Path().apply {
            moveTo(w * 0.15f, h * 0.1f)
            lineTo(w * 0.6f, h * 0.1f)
            lineTo(w * 0.85f, h * 0.35f)
            lineTo(w * 0.85f, h * 0.9f)
            lineTo(w * 0.15f, h * 0.9f)
            close()
        }
        drawPath(path = docPath, color = color, style = Stroke(width = stroke))
        val foldPath = Path().apply {
            moveTo(w * 0.6f, h * 0.1f)
            lineTo(w * 0.6f, h * 0.35f)
            lineTo(w * 0.85f, h * 0.35f)
        }
        drawPath(path = foldPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun DocumentShieldIcon(modifier: Modifier = Modifier, color: Color = Color.Black) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawRoundRect(
            color = color,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.1f),
            size = androidx.compose.ui.geometry.Size(w * 0.7f, h * 0.8f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val shieldPath = Path().apply {
            moveTo(w * 0.35f, h * 0.4f)
            lineTo(w * 0.65f, h * 0.4f)
            lineTo(w * 0.65f, h * 0.6f)
            quadraticTo(w * 0.65f, h * 0.75f, w * 0.5f, h * 0.82f)
            quadraticTo(w * 0.35f, h * 0.75f, w * 0.35f, h * 0.6f)
            close()
        }
        drawPath(path = shieldPath, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun ChevronRightIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
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
fun NoBookingsIllustration(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()

        drawCircle(
            color = Color(0xFFF1F5F9),
            radius = w * 0.38f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.48f)
        )

        drawLine(
            color = Color(0xFFCBD5E1),
            start = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.78f),
            end = androidx.compose.ui.geometry.Offset(w * 0.85f, h * 0.78f),
            strokeWidth = stroke
        )

        drawRoundRect(
            color = Color(0xFFE2F3F2),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.32f),
            size = androidx.compose.ui.geometry.Size(w * 0.3f, h * 0.42f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx())
        )
        drawRoundRect(
            color = Color(0xFF38928F),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.32f),
            size = androidx.compose.ui.geometry.Size(w * 0.3f, h * 0.42f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx()),
            style = Stroke(width = stroke)
        )

        val handlePath = Path().apply {
            moveTo(w * 0.43f, h * 0.32f)
            lineTo(w * 0.43f, h * 0.23f)
            lineTo(w * 0.57f, h * 0.23f)
            lineTo(w * 0.57f, h * 0.32f)
        }
        drawPath(path = handlePath, color = Color(0xFF38928F), style = Stroke(width = stroke))

        drawLine(
            color = Color(0xFF38928F),
            start = androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.32f),
            end = androidx.compose.ui.geometry.Offset(w * 0.42f, h * 0.74f),
            strokeWidth = stroke
        )
        drawLine(
            color = Color(0xFF38928F),
            start = androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.32f),
            end = androidx.compose.ui.geometry.Offset(w * 0.58f, h * 0.74f),
            strokeWidth = stroke
        )

        drawRoundRect(
            color = Color(0xFFE2F3F2),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.67f, h * 0.52f),
            size = androidx.compose.ui.geometry.Size(w * 0.11f, h * 0.22f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx())
        )
        drawRoundRect(
            color = Color(0xFF38928F),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.67f, h * 0.52f),
            size = androidx.compose.ui.geometry.Size(w * 0.11f, h * 0.22f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()),
            style = Stroke(width = stroke)
        )
        drawCircle(
            color = Color(0xFF38928F),
            radius = w * 0.02f,
            center = androidx.compose.ui.geometry.Offset(w * 0.725f, h * 0.63f)
        )

        drawCircle(
            color = Color(0xFF38928F),
            radius = w * 0.045f,
            center = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.76f),
            style = Stroke(width = stroke)
        )
        drawCircle(
            color = Color(0xFF38928F),
            radius = w * 0.045f,
            center = androidx.compose.ui.geometry.Offset(w * 0.38f, h * 0.76f),
            style = Stroke(width = stroke)
        )
        val glassBridge = Path().apply {
            moveTo(w * 0.325f, h * 0.74f)
            quadraticTo(w * 0.33f, h * 0.71f, w * 0.335f, h * 0.74f)
        }
        drawPath(glassBridge, Color(0xFF38928F), style = Stroke(width = stroke))
    }
}

@Composable
fun MenuItemRow(
    icon: @Composable () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    trailingContent: @Composable () -> Unit = {},
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
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
        trailingContent()
        Spacer(modifier = Modifier.width(4.dp))
        ChevronRightIcon(modifier = Modifier.size(12.dp))
    }
}

@Composable
fun GroupHeader(title: String) {
    Text(
        text = title,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp,
        color = Color(0xFF64748B),
        fontFamily = PoppinsFontFamily(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    )
}

@Composable
fun HomeScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToHelp: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToNotificationSettings: () -> Unit,
    onNavigateToLanguageSettings: () -> Unit = {},
    onNavigateToFeedback: () -> Unit = {},
    onNavigateToPropertyDetails: (HighlightItem) -> Unit = {},
    onNavigateToSelectProperty: (city: String, guests: String) -> Unit = { _, _ -> },
    isLoggedIn: Boolean,
    userName: String,
    languageCode: String = "EN"
) {
    val languageFlag = when (languageCode) {
        "DE" -> "🇩🇪"
        "ES" -> "🇪🇸"
        "FR" -> "🇫🇷"
        "IT" -> "🇮🇹"
        "PT" -> "🇵🇹"
        else -> "🇬🇧"
    }
    var selectedTab by remember { mutableStateOf(0) }
    var showNotificationBanner by remember { mutableStateOf(true) }
    var showRecentlySearched by remember { mutableStateOf(true) }
    var showAddBookingSheet by remember { mutableStateOf(false) }
    var bookingReference by remember { mutableStateOf("") }
    var bookingLastName by remember { mutableStateOf("") }
    var showNotificationPermissionDialog by remember { mutableStateOf(false) }

    val exploreScrollState = rememberScrollState()
    val bookingsScrollState = rememberScrollState()
    val profileScrollState = rememberScrollState()

    val highlights = listOf(
        HighlightItem("Berlin", "Müllerstraße", "Best rated", "🇩🇪", Res.drawable.highlight_berlin),
        HighlightItem("Vienna", "Favoritenstraße", "Featured", "🇦🇹", Res.drawable.highlight_vienna),
        HighlightItem("Madrid", "Malasaña", "Prime location", "🇪🇸", Res.drawable.highlight_madrid),
        HighlightItem("Basel", "Town Hall", "Prime location", "🇨🇭", Res.drawable.highlight_basel)
    )

    LaunchedEffect(Unit) {
        // API Call Placeholder: Fetch Property Highlights
        // Example: val remoteHighlights = apiService.getHighlights()
        
        // API Call Placeholder: Fetch User Bookings if logged in
        // Example: if (isLoggedIn) apiService.getMyBookings()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {
        when (selectedTab) {
            0 -> {
                // Explore Tab
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(exploreScrollState)
                        .statusBarsPadding()
                        .padding(horizontal = 20.dp)
                        .padding(bottom = 150.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            LimehomeLogo(modifier = Modifier.size(32.dp).clip(RoundedCornerShape(6.dp)))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Welcome",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily()
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(White)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                .clickable { onNavigateToHelp() },
                            contentAlignment = Alignment.Center
                        ) {
                            Canvas(modifier = Modifier.size(22.dp)) {
                                val w = size.width
                                val h = size.height
                                val stroke = 1.5f.dp.toPx()
                                drawRoundRect(
                                    color = Color(0xFF0F172A),
                                    topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                                    size = androidx.compose.ui.geometry.Size(w, h * 0.72f),
                                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
                                    style = Stroke(width = stroke)
                                )
                                val tail = Path().apply {
                                    moveTo(w * 0.7f, h * 0.72f)
                                    lineTo(w * 0.7f, h * 0.95f)
                                    lineTo(w * 0.5f, h * 0.72f)
                                }
                                drawPath(path = tail, color = Color(0xFF0F172A), style = Stroke(width = stroke))
                            }
                            Text(
                                text = "?",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(2.dp, LimehomeTeal, RoundedCornerShape(16.dp))
                                .clip(RoundedCornerShape(16.dp))
                                .background(White)
                                .clickable { onNavigateToSearch() }
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            ExploreIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A))
                            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                Text(
                                    text = "Where to?",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A),
                                    fontFamily = PoppinsFontFamily()
                                )
                                Text(
                                    text = "Add date, add guests",
                                    fontSize = 14.sp,
                                    color = Color(0xFF64748B),
                                    fontFamily = PoppinsFontFamily()
                                )
                            }
                        }

                        // Overlapping circular arrow refresh/history badge
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = (-48).dp, y = (-12).dp)
                                .size(26.dp)
                                .clip(CircleShape)
                                .background(White)
                                .border(1.5.dp, LimehomeTeal, CircleShape)
                                .clickable { /* Refresh/History */ },
                            contentAlignment = Alignment.Center
                        ) {
                            Canvas(modifier = Modifier.size(13.dp)) {
                                val w = size.width
                                val h = size.height
                                val stroke = 1.6f.dp.toPx()
                                drawArc(
                                    color = LimehomeTeal,
                                    startAngle = 45f,
                                    sweepAngle = 270f,
                                    useCenter = false,
                                    style = Stroke(width = stroke)
                                )
                                val arrowPath = Path().apply {
                                    moveTo(w * 0.85f, h * 0.2f)
                                    lineTo(w * 0.65f, h * 0.5f)
                                    lineTo(w * 0.45f, h * 0.25f)
                                }
                                drawPath(path = arrowPath, color = LimehomeTeal)
                            }
                        }
                    }

                    // Recently Searched section
                    if (showRecentlySearched) {
                        Spacer(modifier = Modifier.height(24.dp))

                        Text(
                            text = "Recently searched",
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Basel recently searched card
                            Box(
                                modifier = Modifier
                                    .width(140.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                    .background(White)
                                    .clickable { onNavigateToSelectProperty("Basel", "1 Guest") }
                            ) {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(Res.drawable.highlight_basel),
                                            contentDescription = "Basel search background",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color.Black.copy(alpha = 0.15f))
                                        )
                                        Text(
                                            text = "Basel",
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White,
                                            fontFamily = PoppinsFontFamily(),
                                            modifier = Modifier
                                                .align(Alignment.BottomStart)
                                                .padding(start = 12.dp, bottom = 8.dp)
                                        )
                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(8.dp)
                                                .size(20.dp)
                                                .clip(CircleShape)
                                                .background(White)
                                                .clickable { showRecentlySearched = false },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "✕",
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF0F172A)
                                            )
                                        }
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 12.dp, vertical = 8.dp),
                                        verticalArrangement = Arrangement.spacedBy(2.dp)
                                    ) {
                                        Text(
                                            text = "Add dates",
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal,
                                            color = Color(0xFF0F172A),
                                            fontFamily = PoppinsFontFamily()
                                        )
                                        Text(
                                            text = "1 Guest",
                                            fontSize = 12.sp,
                                            color = Color(0xFF64748B),
                                            fontFamily = PoppinsFontFamily()
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Text(
                        text = "Highlights",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    val chunkedHighlights = highlights.chunked(2)
                    Column(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        chunkedHighlights.forEach { rowItems ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                rowItems.forEach { item ->
                                    Box(
                                        modifier = Modifier
                                            .weight(1f)
                                            .aspectRatio(0.72f)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(Color(0xFFE2E8F0))
                                            .clickable { onNavigateToPropertyDetails(item) }
                                    ) {
                                        Image(
                                            painter = painterResource(item.image),
                                            contentDescription = "${item.city} room",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )

                                        Box(
                                            modifier = Modifier
                                                .padding(12.dp)
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(White)
                                                .padding(horizontal = 10.dp, vertical = 5.dp)
                                        ) {
                                            Text(
                                                text = item.badge,
                                                fontSize = 11.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF0F172A),
                                                fontFamily = PoppinsFontFamily()
                                            )
                                        }

                                        Box(
                                            modifier = Modifier
                                                .align(Alignment.BottomCenter)
                                                .fillMaxWidth()
                                                .padding(10.dp)
                                                .clip(RoundedCornerShape(12.dp))
                                                .background(White.copy(alpha = 0.92f))
                                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween,
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Column(
                                                    verticalArrangement = Arrangement.spacedBy(2.dp),
                                                    modifier = Modifier.weight(1f)
                                                ) {
                                                    Text(
                                                        text = item.city,
                                                        fontSize = 14.sp,
                                                        fontWeight = FontWeight.Bold,
                                                        color = Color(0xFF0F172A),
                                                        fontFamily = PoppinsFontFamily()
                                                    )
                                                    Text(
                                                        text = item.street,
                                                        fontSize = 11.sp,
                                                        color = Color(0xFF475569),
                                                        fontFamily = PoppinsFontFamily()
                                                    )
                                                }

                                                Box(
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                        .clip(CircleShape)
                                                        .background(White),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        text = item.flag,
                                                        fontSize = 13.sp
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }

                                if (rowItems.size < 2) {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }

            1 -> {
                // Bookings Tab
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(bookingsScrollState)
                        .statusBarsPadding()
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 150.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "My bookings",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )

                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(White)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                                .clickable { showAddBookingSheet = true },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xFF0F172A),
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(60.dp))

                    NoBookingsIllustration(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(180.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "No upcoming bookings",
                        fontSize = 21.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Let's change that!",
                        fontSize = 15.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .border(1.dp, Color(0xFF0F172A), RoundedCornerShape(12.dp))
                            .clip(RoundedCornerShape(12.dp))
                            .background(White)
                            .clickable { showAddBookingSheet = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Add booking",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily()
                            )
                            Text(
                                text = "+",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF0F172A)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))



                    Button(
                        onClick = { onNavigateToSearch() },
                        colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Text(
                            text = "Book now",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                }
            }

            2 -> {
                // Account Tab
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(profileScrollState)
                        .statusBarsPadding()
                        .padding(bottom = 150.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    // Title
                    Text(
                        text = "Account",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Profile Header Block
                    if (!isLoggedIn) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color(0xFF0F172A), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                ProfileIcon(modifier = Modifier.size(32.dp), color = Color(0xFF0F172A))
                            }

                            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                Text(
                                    text = "Your profile",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A),
                                    fontFamily = PoppinsFontFamily()
                                )
                                Text(
                                    text = "Sign in to manage your trips and save 15% on every stay.",
                                    fontSize = 14.sp,
                                    color = Color(0xFF64748B),
                                    fontFamily = PoppinsFontFamily(),
                                    lineHeight = 20.sp
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                    }

                    // Turn on notifications Banner – only visible when NOT logged in
                    if (showNotificationBanner && !isLoggedIn) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                                .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(16.dp))
                                .clip(RoundedCornerShape(16.dp))
                                .background(White)
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    BellIcon(modifier = Modifier.size(20.dp), color = Color(0xFF0F172A))
                                    Text(
                                        text = "Turn on notifications",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF0F172A),
                                        fontFamily = PoppinsFontFamily()
                                    )
                                }

                                Text(
                                    text = "✕",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF64748B),
                                    modifier = Modifier
                                        .clickable { showNotificationBanner = false }
                                        .padding(4.dp)
                                )
                            }

                            Text(
                                text = "Stay on top of your trip - get booking updates, access codes, reminders, and exclusive deals.",
                                fontSize = 13.sp,
                                color = Color(0xFF64748B),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 18.sp
                            )

                            Button(
                                onClick = { showNotificationPermissionDialog = true },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E293B)),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(44.dp)
                            ) {
                                Text(
                                    text = "Yes, notify me",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    fontFamily = PoppinsFontFamily()
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    if (!isLoggedIn) {
                        // Sign up / Log in Main Button
                        Button(
                            onClick = onNavigateToLogin,
                            colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                                .height(52.dp)
                        ) {
                            Text(
                                text = "Sign up / Log in",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                fontFamily = PoppinsFontFamily()
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))
                    }

                    // Menu List Groupings
                    HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

                    GroupHeader("PROFILE")
                    MenuItemRow(
                        icon = { HomeHeartIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Limehome membership"
                    )

                    HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

                    GroupHeader("PREFERENCES")
                    MenuItemRow(
                        icon = { BellIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Notification settings",
                        onClick = onNavigateToNotificationSettings
                    )
                    MenuItemRow(
                        icon = { GlobeIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Language",
                        onClick = onNavigateToLanguageSettings,
                        trailingContent = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = languageCode,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF64748B),
                                    fontFamily = PoppinsFontFamily()
                                )
                                Text(
                                    text = languageFlag,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    )

                    HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

                    GroupHeader("SUPPORT")
                    MenuItemRow(
                        icon = {
                            Box(contentAlignment = Alignment.Center) {
                                Canvas(modifier = Modifier.size(22.dp)) {
                                    val w = size.width
                                    val h = size.height
                                    val stroke = 1.5f.dp.toPx()
                                    drawRoundRect(
                                        color = Color(0xFF0F172A),
                                        topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                                        size = androidx.compose.ui.geometry.Size(w, h * 0.72f),
                                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
                                        style = Stroke(width = stroke)
                                    )
                                    val tail = Path().apply {
                                        moveTo(w * 0.7f, h * 0.72f)
                                        lineTo(w * 0.7f, h * 0.95f)
                                        lineTo(w * 0.5f, h * 0.72f)
                                    }
                                    drawPath(path = tail, color = Color(0xFF0F172A), style = Stroke(width = stroke))
                                }
                                Text(
                                    text = "?",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A),
                                    modifier = Modifier.padding(bottom = 5.dp)
                                )
                            }
                        },
                        title = "Help & FAQs",
                        onClick = onNavigateToHelp
                    )
                    MenuItemRow(
                        icon = { FeedbackIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Feedback",
                        onClick = onNavigateToFeedback
                    )

                    HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

                    GroupHeader("LEGAL")
                    MenuItemRow(
                        icon = { DocumentIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Terms & conditions"
                    )
                    MenuItemRow(
                        icon = { DocumentShieldIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A)) },
                        title = "Privacy policy"
                    )

                    HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 8.dp)

                    GroupHeader("ABOUT US")
                    MenuItemRow(
                        icon = { LimehomeLogo(modifier = Modifier.size(22.dp)) },
                        title = "About Limehome"
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "VERSION 2026.32.0-179",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF94A3B8),
                        fontFamily = PoppinsFontFamily(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }

        // Bottom Navigation Bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(White.copy(alpha = 0.96f))
                .border(0.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .navigationBarsPadding()
                .padding(vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tab 0: Explore
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .clickable { selectedTab = 0 }
                        .padding(horizontal = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (selectedTab == 0) Color(0xFFE2F3F2) else Color.Transparent)
                            .padding(horizontal = 20.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ExploreIcon(
                            modifier = Modifier.size(22.dp),
                            color = if (selectedTab == 0) LimehomeTeal else Color(0xFF64748B)
                        )
                    }
                    Text(
                        text = "Explore",
                        fontSize = 12.sp,
                        fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Medium,
                        color = if (selectedTab == 0) LimehomeTeal else Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // Tab 1: Bookings
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .clickable { selectedTab = 1 }
                        .padding(horizontal = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (selectedTab == 1) Color(0xFFE2F3F2) else Color.Transparent)
                            .padding(horizontal = 20.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        SuitcaseIcon(
                            modifier = Modifier.size(22.dp),
                            color = if (selectedTab == 1) LimehomeTeal else Color(0xFF64748B)
                        )
                    }
                    Text(
                        text = "Bookings",
                        fontSize = 12.sp,
                        fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Medium,
                        color = if (selectedTab == 1) LimehomeTeal else Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // Tab 2: Log in (Account)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .clickable { selectedTab = 2 }
                        .padding(horizontal = 16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (selectedTab == 2) Color(0xFFE2F3F2) else Color.Transparent)
                            .padding(horizontal = 20.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ProfileIcon(
                            modifier = Modifier.size(22.dp),
                            color = if (selectedTab == 2) LimehomeTeal else Color(0xFF64748B)
                        )
                    }
                    Text(
                        text = if (isLoggedIn) "Profile" else "Log in",
                        fontSize = 12.sp,
                        fontWeight = if (selectedTab == 2) FontWeight.Bold else FontWeight.Medium,
                        color = if (selectedTab == 2) LimehomeTeal else Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )
                }
            }
        }
    }

    // Add Booking Bottom Sheet Overlay
    if (showAddBookingSheet) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { showAddBookingSheet = false },
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                    .background(White)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { /* Block clicks from passing through */ }
                    .navigationBarsPadding()
                    .padding(top = 12.dp, bottom = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Drag handle
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0xFFCBD5E1))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Header row: bell icon + title + close button
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        BellIcon(modifier = Modifier.size(22.dp), color = Color(0xFF0F172A))
                        Text(
                            text = "Add booking",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color(0xFFE2E8F0), CircleShape)
                            .clickable {
                                showAddBookingSheet = false
                                bookingReference = ""
                                bookingLastName = ""
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "✕",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Booking reference field
                OutlinedTextField(
                    value = bookingReference,
                    onValueChange = { bookingReference = it },
                    label = {
                        Text(
                            text = "Booking reference *",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Helper text
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Canvas(modifier = Modifier.size(14.dp).padding(top = 2.dp)) {
                        val w = size.width
                        val h = size.height
                        val stroke = 1.2f.dp.toPx()
                        drawCircle(
                            color = Color(0xFF64748B),
                            radius = w * 0.4f,
                            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
                            style = Stroke(width = stroke)
                        )
                        drawCircle(color = Color(0xFF64748B), radius = w * 0.06f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.3f))
                        drawLine(Color(0xFF64748B), androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.42f), androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.7f), strokeWidth = stroke)
                    }
                    Text(
                        text = "You can find it in your booking confirmation email.\nE.g. ABCDEFGH-1",
                        fontSize = 12.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily(),
                        lineHeight = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Last name field
                OutlinedTextField(
                    value = bookingLastName,
                    onValueChange = { bookingLastName = it },
                    label = {
                        Text(
                            text = "Last name *",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Submit button
                Button(
                    onClick = {
                        // API Call Placeholder: Add a new booking by reference
                        // Example: apiService.addBooking(bookingReference, bookingLastName)

                        showAddBookingSheet = false
                        bookingReference = ""
                        bookingLastName = ""
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .height(52.dp)
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Cancel button
                Text(
                    text = "Cancel",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier
                        .clickable {
                            showAddBookingSheet = false
                            bookingReference = ""
                            bookingLastName = ""
                        }
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
        }
    }

    // Notification Permission Dialog Overlay
    if (showNotificationPermissionDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    showNotificationPermissionDialog = false
                    showNotificationBanner = false
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(290.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFF2F2F2))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { /* prevent click propagation */ }
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Allow \"Limehome\" to send you notifications?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Notifications may include alerts, sounds, and icon badges. These can be configured in Settings.",
                    fontSize = 13.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                HorizontalDivider(color = Color(0xFFD1D1D6), thickness = 0.8.dp)

                Row(
                    modifier = Modifier.fillMaxWidth().height(44.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Don't Allow",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF007AFF),
                        textAlign = TextAlign.Center,
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                showNotificationPermissionDialog = false
                                showNotificationBanner = false
                            }
                            .wrapContentHeight(Alignment.CenterVertically)
                    )

                    VerticalDivider(color = Color(0xFFD1D1D6), thickness = 0.8.dp)

                    Text(
                        text = "Allow",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF007AFF),
                        textAlign = TextAlign.Center,
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                showNotificationPermissionDialog = false
                                showNotificationBanner = false
                            }
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}
