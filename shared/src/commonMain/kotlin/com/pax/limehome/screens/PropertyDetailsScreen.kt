package com.pax.limehome.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import com.pax.limehome.rememberShareLauncher

// ─── Canvas Icons ─────────────────────────────────────────────────────────────

@Composable
private fun BackArrowIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val stroke = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.65f, h * 0.22f)
            lineTo(w * 0.32f, h * 0.5f)
            lineTo(w * 0.65f, h * 0.78f)
        }
        drawPath(path, color, style = Stroke(stroke))
    }
}

@Composable
private fun ShareIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.8f.dp.toPx()
        // Upload arrow
        val arrow = Path().apply {
            moveTo(w * 0.5f, h * 0.6f)
            lineTo(w * 0.5f, h * 0.15f)
            moveTo(w * 0.32f, h * 0.35f)
            lineTo(w * 0.5f, h * 0.15f)
            lineTo(w * 0.68f, h * 0.35f)
        }
        drawPath(arrow, color, style = Stroke(s))
        // Box
        val box = Path().apply {
            moveTo(w * 0.2f, h * 0.5f)
            lineTo(w * 0.2f, h * 0.88f)
            lineTo(w * 0.8f, h * 0.88f)
            lineTo(w * 0.8f, h * 0.5f)
        }
        drawPath(box, color, style = Stroke(s))
    }
}

@Composable
private fun LocationPinIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        val pin = Path().apply {
            moveTo(w * 0.5f, h * 0.95f)
            cubicTo(w * 0.5f, h * 0.95f, w * 0.1f, h * 0.6f, w * 0.1f, h * 0.38f)
            cubicTo(w * 0.1f, h * 0.14f, w * 0.9f, h * 0.14f, w * 0.9f, h * 0.38f)
            cubicTo(w * 0.9f, h * 0.6f, w * 0.5f, h * 0.95f, w * 0.5f, h * 0.95f)
            close()
        }
        drawPath(pin, color, style = Stroke(s))
        drawCircle(color, radius = w * 0.12f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.37f))
    }
}

@Composable
private fun CalendarPlusIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.6f.dp.toPx()
        drawRoundRect(color, style = Stroke(s),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.08f, h * 0.2f),
            size = androidx.compose.ui.geometry.Size(w * 0.84f, h * 0.72f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()))
        // Top bar
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.08f, h * 0.4f),
            end = androidx.compose.ui.geometry.Offset(w * 0.92f, h * 0.4f), strokeWidth = s)
        // + symbol in center
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.52f),
            end = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.82f), strokeWidth = s)
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.67f),
            end = androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.67f), strokeWidth = s)
    }
}

@Composable
private fun GuestPlusIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.6f.dp.toPx()
        // Head circle
        drawCircle(color, radius = w * 0.18f, center = androidx.compose.ui.geometry.Offset(w * 0.38f, h * 0.28f), style = Stroke(s))
        // Body arc
        val body = Path().apply {
            moveTo(w * 0.05f, h * 0.85f)
            cubicTo(w * 0.05f, h * 0.6f, w * 0.7f, h * 0.6f, w * 0.7f, h * 0.85f)
        }
        drawPath(body, color, style = Stroke(s))
        // + sign
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.78f, h * 0.28f),
            end = androidx.compose.ui.geometry.Offset(w * 0.78f, h * 0.58f), strokeWidth = s)
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.63f, h * 0.43f),
            end = androidx.compose.ui.geometry.Offset(w * 0.93f, h * 0.43f), strokeWidth = s)
    }
}

@Composable
private fun PlusCircleIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.6f.dp.toPx()
        drawCircle(color, radius = w * 0.45f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f), style = Stroke(s))
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.28f),
            end = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.72f), strokeWidth = s)
        drawLine(color, start = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.5f),
            end = androidx.compose.ui.geometry.Offset(w * 0.72f, h * 0.5f), strokeWidth = s)
    }
}

@Composable
private fun SortIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.8f.dp.toPx()
        // Up arrow
        val up = Path().apply {
            moveTo(w * 0.35f, h * 0.7f)
            lineTo(w * 0.35f, h * 0.2f)
            moveTo(w * 0.2f, h * 0.4f)
            lineTo(w * 0.35f, h * 0.2f)
            lineTo(w * 0.5f, h * 0.4f)
        }
        drawPath(up, color, style = Stroke(s))
        // Down arrow
        val down = Path().apply {
            moveTo(w * 0.65f, h * 0.3f)
            lineTo(w * 0.65f, h * 0.8f)
            moveTo(w * 0.5f, h * 0.6f)
            lineTo(w * 0.65f, h * 0.8f)
            lineTo(w * 0.8f, h * 0.6f)
        }
        drawPath(down, color, style = Stroke(s))
    }
}

// ─── Room photo placeholder ────────────────────────────────────────────────────

@Composable
private fun RoomPhotoPlaceholder(modifier: Modifier = Modifier, tint: Color = Color(0xFFD4B896)) {
    Box(
        modifier = modifier.background(tint),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(40.dp)) {
            val w = size.width; val h = size.height
            val s = 1.5f.dp.toPx()
            // Simple bed silhouette
            drawRoundRect(Color.White.copy(alpha = 0.4f), style = Stroke(s),
                topLeft = androidx.compose.ui.geometry.Offset(w * 0.05f, h * 0.4f),
                size = androidx.compose.ui.geometry.Size(w * 0.9f, h * 0.5f),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()))
            drawRect(Color.White.copy(alpha = 0.4f),
                topLeft = androidx.compose.ui.geometry.Offset(w * 0.12f, h * 0.2f),
                size = androidx.compose.ui.geometry.Size(w * 0.3f, h * 0.22f))
        }
    }
}

// ─── Amenity Icon helpers ──────────────────────────────────────────────────────

@Composable
private fun AmenityIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        drawRoundRect(Color(0xFF475569), style = Stroke(s),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.15f, w * 0.05f),
            size = androidx.compose.ui.geometry.Size(w * 0.7f, h * 0.9f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()))
        drawLine(Color(0xFF475569),
            start = androidx.compose.ui.geometry.Offset(w * 0.3f, h * 0.25f),
            end = androidx.compose.ui.geometry.Offset(w * 0.7f, h * 0.25f), strokeWidth = s)
        drawLine(Color(0xFF475569),
            start = androidx.compose.ui.geometry.Offset(w * 0.3f, h * 0.45f),
            end = androidx.compose.ui.geometry.Offset(w * 0.7f, h * 0.45f), strokeWidth = s)
        drawLine(Color(0xFF475569),
            start = androidx.compose.ui.geometry.Offset(w * 0.3f, h * 0.65f),
            end = androidx.compose.ui.geometry.Offset(w * 0.55f, h * 0.65f), strokeWidth = s)
    }
}

// ─── Main Screen ──────────────────────────────────────────────────────────────

@Composable
fun PropertyDetailsScreen(
    city: String = "Berlin",
    street: String = "Müllerstraße",
    badge: String = "Best rated",
    flag: String = "🇩🇪",
    heroImage: DrawableResource? = null,
    onBack: () -> Unit,
    onShare: () -> Unit = {}
) {
    val shareLauncher = rememberShareLauncher()
    val propertyName = "$city $street"
    val address = when (city) {
        "Berlin"  -> "12 Müllerstraße , 13353 Berlin, DE"
        "Vienna"  -> "14 Favoritenstraße , 1040 Vienna, AT"
        "Madrid"  -> "8 Calle del Pez , 28004 Madrid, ES"
        "Basel"   -> "3 Rathaus Str. , 4001 Basel, CH"
        else      -> "$street, $city"
    }
    val distance = when (city) {
        "Berlin"  -> "3.7 km from city center"
        "Vienna"  -> "2.1 km from city center"
        "Madrid"  -> "0.8 km from city center"
        "Basel"   -> "1.2 km from city center"
        else      -> "2.5 km from city center"
    }
    val description = "Our limehome $propertyName is situated in the lively and multicultural district of the city. " +
            "The apartment offers everything you need for a comfortable and stylish stay, with premium furnishings, high-speed WiFi, and a fully equipped kitchen."

    var selectedTab by remember { mutableStateOf(0) }
    var readMore by remember { mutableStateOf(false) }
    var showMoreAmenities by remember { mutableStateOf(false) }
    val tabs = listOf("Overview", "Amenities", "Rooms", "Things to know")

    val amenities = listOf(
        Pair("📱", "Contactless check-in/out"),
        Pair("🌿", "Sustainably operated"),
        Pair("🛏️", "Premium beds"),
        Pair("📶", "High-speed wifi"),
        Pair("🍳", "Fully equipped kitchen"),
        Pair("🖥️", "Smart TV"),
        Pair("🅿️", "Parking available"),
        Pair("🐾", "Pet friendly"),
        Pair("♿", "Accessible rooms")
    )

    val visibleAmenities = if (showMoreAmenities) amenities else amenities.take(4)

    val listState = rememberLazyListState()
    val showStickyBar by remember { derivedStateOf { listState.firstVisibleItemIndex >= 2 } }

    LaunchedEffect(city, street) {
        // API Call Placeholder: Fetch Detailed Property Info
        // Example: val fullDetails = apiService.getPropertyDetails(propertyId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            // ── Top bar
            item {
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
                        BackArrowIcon(modifier = Modifier.size(22.dp))
                    }
                    Text(
                        text = "Property details",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier.align(Alignment.Center)
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(38.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .clickable {
                                val shareText = "Check out limehome $propertyName\n📍 $address · $distance\n\nhttps://www.limehome.com"
                                shareLauncher(shareText)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        ShareIcon(modifier = Modifier.size(20.dp))
                    }
                }
                HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
            }

            // ── Title & location
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = propertyName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        lineHeight = 30.sp
                    )
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        LocationPinIcon(modifier = Modifier.size(14.dp).padding(top = 2.dp))
                        Text(
                            text = "$address  ·  ",
                            fontSize = 13.sp,
                            color = Color(0xFF64748B),
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                    Text(
                        text = "  $distance",
                        fontSize = 13.sp,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // ── Photo grid
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    // Large left photo
                    Box(
                        modifier = Modifier
                            .weight(1.1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(12.dp))
                    ) {
                        if (heroImage != null) {
                            Image(
                                painter = painterResource(heroImage),
                                contentDescription = "$city room",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            RoomPhotoPlaceholder(modifier = Modifier.fillMaxSize(), tint = Color(0xFFC9A97A))
                        }
                    }
                    // Two stacked right photos
                    Column(
                        modifier = Modifier
                            .weight(0.9f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        RoomPhotoPlaceholder(
                            modifier = Modifier.weight(1f).fillMaxWidth().clip(RoundedCornerShape(12.dp)),
                            tint = Color(0xFFB8A08A)
                        )
                        RoomPhotoPlaceholder(
                            modifier = Modifier.weight(1f).fillMaxWidth().clip(RoundedCornerShape(12.dp)),
                            tint = Color(0xFFA08878)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // ── Travel details card
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Travel details",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                    // Check in/out
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        CalendarPlusIcon(modifier = Modifier.size(20.dp))
                        Text(
                            text = "Check in/out",
                            fontSize = 15.sp,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                    // Guests & rooms
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            GuestPlusIcon(modifier = Modifier.size(20.dp))
                            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                Text(
                                    text = "Guests & rooms",
                                    fontSize = 11.sp,
                                    color = Color(0xFF64748B),
                                    fontFamily = PoppinsFontFamily()
                                )
                                Text(
                                    text = "1 guest , 1 room",
                                    fontSize = 15.sp,
                                    color = Color(0xFF0F172A),
                                    fontFamily = PoppinsFontFamily()
                                )
                            }
                        }
                        PlusCircleIcon(modifier = Modifier.size(22.dp))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            // ── Description
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = if (readMore) description else "${description.take(100)}...",
                        fontSize = 14.sp,
                        color = Color(0xFF475569),
                        fontFamily = PoppinsFontFamily(),
                        lineHeight = 22.sp
                    )
                    Text(
                        text = if (readMore) "Read less" else "Read more",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.clickable { readMore = !readMore }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

            // ── Tab row (sticky anchor)
            item {
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = White,
                    contentColor = Color(0xFF0F172A),
                    edgePadding = 20.dp,
                    indicator = { tabPositions ->
                        if (selectedTab < tabPositions.size) {
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                color = LimehomeTeal,
                                height = 2.dp
                            )
                        }
                    },
                    divider = { HorizontalDivider(color = Color(0xFFF1F5F9)) }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    fontSize = 14.sp,
                                    fontWeight = if (selectedTab == index) FontWeight.SemiBold else FontWeight.Normal,
                                    fontFamily = PoppinsFontFamily()
                                )
                            },
                            selectedContentColor = Color(0xFF0F172A),
                            unselectedContentColor = Color(0xFF94A3B8)
                        )
                    }
                }
            }

            // ── Amenities section
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(14.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        text = "Our amenities",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    visibleAmenities.forEach { (emoji, label) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(14.dp)
                        ) {
                            Text(text = emoji, fontSize = 18.sp)
                            Text(
                                text = label,
                                fontSize = 15.sp,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily()
                            )
                        }
                        if (label != visibleAmenities.last().second) {
                            HorizontalDivider(color = Color(0xFFF8FAFC))
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    // "Show X more" button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .clickable { showMoreAmenities = !showMoreAmenities }
                            .padding(vertical = 14.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (showMoreAmenities) "Show less" else "Show ${amenities.size - 4} more",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                }
            }

            // ── Room categories section
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Our room categories",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .border(1.5.dp, LimehomeTeal, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            SortIcon(modifier = Modifier.size(20.dp))
                        }
                    }
                    Text(
                        text = "The design and layout of our suites may vary slightly from the photos.",
                        fontSize = 13.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily(),
                        lineHeight = 20.sp
                    )
                }
            }

            // Room card
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = "Family Suite with sofa bed",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(14.dp))
                    ) {
                        if (heroImage != null) {
                            Image(
                                painter = painterResource(heroImage),
                                contentDescription = "Suite room",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } else {
                            RoomPhotoPlaceholder(modifier = Modifier.fillMaxSize(), tint = Color(0xFFB9957A))
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.navigationBarsPadding().height(24.dp)) }
        }

        // ── Sticky compact bar on scroll
        AnimatedVisibility(
            visible = showStickyBar,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Check in/out pill
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CalendarPlusIcon(modifier = Modifier.size(16.dp))
                        Text(
                            text = "Check in/out",
                            fontSize = 13.sp,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                    // Guests pill
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        GuestPlusIcon(modifier = Modifier.size(16.dp))
                        Text(
                            text = "1 guest , ...",
                            fontSize = 13.sp,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                        PlusCircleIcon(modifier = Modifier.size(16.dp))
                    }
                }
                // Sticky tab bar
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = White,
                    contentColor = Color(0xFF0F172A),
                    edgePadding = 16.dp,
                    indicator = { tabPositions ->
                        if (selectedTab < tabPositions.size) {
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                color = LimehomeTeal,
                                height = 2.dp
                            )
                        }
                    },
                    divider = { HorizontalDivider(color = Color(0xFFF1F5F9)) }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    fontSize = 13.sp,
                                    fontWeight = if (selectedTab == index) FontWeight.SemiBold else FontWeight.Normal,
                                    fontFamily = PoppinsFontFamily()
                                )
                            },
                            selectedContentColor = Color(0xFF0F172A),
                            unselectedContentColor = Color(0xFF94A3B8)
                        )
                    }
                }
            }
        }
    }
}
