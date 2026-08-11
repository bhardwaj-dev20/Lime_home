package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.rememberShareLauncher
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White

// ─── Data ─────────────────────────────────────────────────────────────────────

data class PropertyListing(
    val name: String,
    val distanceKm: Double,
    val rating: Double,
    val reviewCount: Int,
    val tags: List<String> = emptyList(),
    val bgColor: Color = Color(0xFF2D8A8A),
    val accentColor: Color = Color(0xFF1A5F7A)
)

// ─── Canvas Icons ──────────────────────────────────────────────────────────────

@Composable
private fun SpBackArrow(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.65f, h * 0.22f)
            lineTo(w * 0.32f, h * 0.5f)
            lineTo(w * 0.65f, h * 0.78f)
        }
        drawPath(path, Color(0xFF0F172A), style = Stroke(s))
    }
}

@Composable
private fun SpShareIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.8f.dp.toPx()
        val arrow = Path().apply {
            moveTo(w * 0.5f, h * 0.6f)
            lineTo(w * 0.5f, h * 0.15f)
            moveTo(w * 0.32f, h * 0.35f)
            lineTo(w * 0.5f, h * 0.15f)
            lineTo(w * 0.68f, h * 0.35f)
        }
        drawPath(arrow, Color(0xFF0F172A), style = Stroke(s))
        val box = Path().apply {
            moveTo(w * 0.2f, h * 0.5f); lineTo(w * 0.2f, h * 0.88f)
            lineTo(w * 0.8f, h * 0.88f); lineTo(w * 0.8f, h * 0.5f)
        }
        drawPath(box, Color(0xFF0F172A), style = Stroke(s))
    }
}

@Composable
private fun BriefcaseIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        drawRoundRect(Color(0xFF0F172A), style = Stroke(s),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.06f, h * 0.36f),
            size = androidx.compose.ui.geometry.Size(w * 0.88f, h * 0.56f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()))
        val handle = Path().apply {
            moveTo(w * 0.35f, h * 0.36f)
            lineTo(w * 0.35f, h * 0.22f)
            lineTo(w * 0.65f, h * 0.22f)
            lineTo(w * 0.65f, h * 0.36f)
        }
        drawPath(handle, Color(0xFF0F172A), style = Stroke(s))
        drawLine(Color(0xFF0F172A), androidx.compose.ui.geometry.Offset(w * 0.06f, h * 0.6f),
            androidx.compose.ui.geometry.Offset(w * 0.94f, h * 0.6f), strokeWidth = s)
    }
}

@Composable
private fun CalIcon(modifier: Modifier = Modifier, color: Color = LimehomeTeal) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        drawRoundRect(color, style = Stroke(s),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.08f, h * 0.18f),
            size = androidx.compose.ui.geometry.Size(w * 0.84f, h * 0.72f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(3.dp.toPx()))
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.08f, h * 0.38f),
            androidx.compose.ui.geometry.Offset(w * 0.92f, h * 0.38f), strokeWidth = s)
        // + 
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.8f), strokeWidth = s)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.65f),
            androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.65f), strokeWidth = s)
    }
}

@Composable
private fun MapIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        val map = Path().apply {
            moveTo(w * 0.05f, h * 0.2f); lineTo(w * 0.35f, h * 0.1f)
            lineTo(w * 0.65f, h * 0.2f); lineTo(w * 0.95f, h * 0.1f)
            lineTo(w * 0.95f, h * 0.82f); lineTo(w * 0.65f, h * 0.92f)
            lineTo(w * 0.35f, h * 0.82f); lineTo(w * 0.05f, h * 0.92f)
            close()
        }
        drawPath(map, Color(0xFF0F172A), style = Stroke(s))
        drawLine(Color(0xFF0F172A), androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.1f),
            androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.82f), strokeWidth = s)
        drawLine(Color(0xFF0F172A), androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.2f),
            androidx.compose.ui.geometry.Offset(w * 0.65f, h * 0.92f), strokeWidth = s)
    }
}

@Composable
private fun StarIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF22C55E)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.05f)
            lineTo(w * 0.62f, h * 0.38f); lineTo(w * 0.97f, h * 0.38f)
            lineTo(w * 0.69f, h * 0.59f); lineTo(w * 0.79f, h * 0.93f)
            lineTo(w * 0.5f, h * 0.72f); lineTo(w * 0.21f, h * 0.93f)
            lineTo(w * 0.31f, h * 0.59f); lineTo(w * 0.03f, h * 0.38f)
            lineTo(w * 0.38f, h * 0.38f); close()
        }
        drawPath(path, color)
    }
}

@Composable
private fun SpLocationPin(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
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
        drawCircle(color, radius = w * 0.12f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.37f))
    }
}

@Composable
private fun ChevronRightSp(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.8f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.3f, h * 0.2f); lineTo(w * 0.7f, h * 0.5f); lineTo(w * 0.3f, h * 0.8f)
        }
        drawPath(path, color, style = Stroke(s))
    }
}

@Composable
private fun ParkingTagIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width; val h = size.height
        val s = 1.5f.dp.toPx()
        drawCircle(Color(0xFF0F172A), radius = w * 0.45f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f), style = Stroke(s))
        val p = Path().apply {
            moveTo(w * 0.36f, h * 0.72f)
            lineTo(w * 0.36f, h * 0.28f)
            lineTo(w * 0.56f, h * 0.28f)
            cubicTo(w * 0.72f, h * 0.28f, w * 0.72f, h * 0.5f, w * 0.56f, h * 0.5f)
            lineTo(w * 0.36f, h * 0.5f)
        }
        drawPath(p, Color(0xFF0F172A), style = Stroke(s))
    }
}

// ─── Property image placeholder ────────────────────────────────────────────────

@Composable
private fun PropertyImageCard(
    listing: PropertyListing,
    modifier: Modifier = Modifier
) {
    var currentPage by remember { mutableStateOf(0) }
    val totalPages = 3

    Box(modifier = modifier) {
        // Gradient background simulating room photo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(listing.accentColor, listing.bgColor),
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(1000f, 1000f)
                    )
                )
        )

        // Nav arrows
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(White.copy(alpha = 0.85f))
                .clickable { if (currentPage > 0) currentPage-- },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(14.dp)) {
                val w = size.width; val h = size.height
                val path = Path().apply {
                    moveTo(w * 0.65f, h * 0.2f)
                    lineTo(w * 0.35f, h * 0.5f)
                    lineTo(w * 0.65f, h * 0.8f)
                }
                drawPath(path, Color(0xFF0F172A), style = Stroke(1.8f.dp.toPx()))
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(White.copy(alpha = 0.85f))
                .clickable { if (currentPage < totalPages - 1) currentPage++ },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(14.dp)) {
                val w = size.width; val h = size.height
                val path = Path().apply {
                    moveTo(w * 0.35f, h * 0.2f)
                    lineTo(w * 0.65f, h * 0.5f)
                    lineTo(w * 0.35f, h * 0.8f)
                }
                drawPath(path, Color(0xFF0F172A), style = Stroke(1.8f.dp.toPx()))
            }
        }

        // Rating badge – top right
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(White)
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    StarIcon(modifier = Modifier.size(14.dp))
                    Text(
                        text = listing.rating.toString(),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }
                Text(
                    text = "${listing.reviewCount} reviews",
                    fontSize = 10.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )
            }
        }

        // Page indicator dots
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            repeat(totalPages) { i ->
                Box(
                    modifier = Modifier
                        .size(if (i == currentPage) 20.dp else 8.dp, 8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(if (i == currentPage) LimehomeTeal else White.copy(alpha = 0.6f))
                )
            }
        }
    }
}

// ─── Property Card ─────────────────────────────────────────────────────────────

@Composable
private fun PropertyCard(
    listing: PropertyListing,
    onExplore: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        PropertyImageCard(
            listing = listing,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(14.dp))
        )

        // Name
        Text(
            text = listing.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0F172A),
            fontFamily = PoppinsFontFamily()
        )

        // Distance
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            SpLocationPin(modifier = Modifier.size(14.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("${listing.distanceKm} km")
                    }
                    append(" from city center")
                },
                fontSize = 13.sp,
                color = Color(0xFF475569),
                fontFamily = PoppinsFontFamily()
            )
        }

        // Tags
        if (listing.tags.isNotEmpty()) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listing.tags.forEach { tag ->
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        if (tag == "Parking") {
                            ParkingTagIcon(modifier = Modifier.size(13.dp))
                        }
                        Text(
                            text = tag,
                            fontSize = 12.sp,
                            color = Color(0xFF475569),
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                }
            }
        }

        // Explore button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = onExplore,
                colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
            ) {
                Text(
                    text = "Explore",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = PoppinsFontFamily()
                )
            }
        }

        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
    }
}

// ─── Main Screen ───────────────────────────────────────────────────────────────

@Composable
fun SelectPropertyScreen(
    cityName: String = "Berlin",
    guests: String = "1 Guest",
    onBack: () -> Unit,
    onExploreProperty: (String) -> Unit = {}
) {
    LaunchedEffect(cityName, guests) {
        // API Call Placeholder: Search properties based on city and guest count
        // Example: val results = apiService.searchProperties(cityName, 1, null)
    }

    val shareLauncher = rememberShareLauncher()

    val listings = remember(cityName) {
        when (cityName) {
            "Basel" -> listOf(
                PropertyListing("Basel Münsterplatz", 1.2, 4.4, 521, bgColor = Color(0xFF4A7C6F), accentColor = Color(0xFF2D5A50)),
                PropertyListing("Basel Kunstmuseum", 0.8, 4.6, 318, tags = listOf("Parking"), bgColor = Color(0xFF5E6F8A), accentColor = Color(0xFF3B4F6B)),
                PropertyListing("Basel Barfüsserplatz", 0.5, 4.3, 876, bgColor = Color(0xFF8A6F4A), accentColor = Color(0xFF6B5030))
            )
            "Vienna" -> listOf(
                PropertyListing("Vienna Favoritenstraße", 2.1, 4.5, 1234, bgColor = Color(0xFF6F4A8A), accentColor = Color(0xFF4F2D6B)),
                PropertyListing("Vienna Mariahilf", 1.4, 4.3, 892, tags = listOf("Parking"), bgColor = Color(0xFF4A6F8A), accentColor = Color(0xFF2D506B)),
                PropertyListing("Vienna Leopoldstadt", 3.0, 4.2, 654, bgColor = Color(0xFF8A4A6F), accentColor = Color(0xFF6B2D50))
            )
            else -> listOf(
                PropertyListing("Berlin Malmöer Straße", 3.5, 4.1, 693, bgColor = Color(0xFF2D7A7A), accentColor = Color(0xFF1A5A5A)),
                PropertyListing("Berlin Luise-Henriette-Straße", 6.4, 4.2, 4141, tags = listOf("Parking"), bgColor = Color(0xFF4A6A8A), accentColor = Color(0xFF2D4F6B)),
                PropertyListing("Berlin Müllerstraße", 3.7, 4.3, 1468, bgColor = Color(0xFF5A7A5A), accentColor = Color(0xFF3A5A3A)),
                PropertyListing("Berlin Prenzlauer Berg", 2.1, 4.5, 2201, tags = listOf("Parking"), bgColor = Color(0xFF8A6A2D), accentColor = Color(0xFF6B4F1A))
            )
        }
    }

    val propertyCount = listings.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
    ) {
        // ── Top bar
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
                SpBackArrow(modifier = Modifier.size(22.dp))
            }
            Text(
                text = "Select property",
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
                        shareLauncher("Explore limehome properties in $cityName! https://www.limehome.com")
                    },
                contentAlignment = Alignment.Center
            ) {
                SpShareIcon(modifier = Modifier.size(20.dp))
            }
        }
        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

        // ── Search summary pill
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(12.dp))
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BriefcaseIcon(modifier = Modifier.size(20.dp))
            Text(
                text = cityName,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily()
            )
            Text(text = "  |  ", fontSize = 15.sp, color = Color(0xFFCBD5E1))
            Text(
                text = "Add dates",
                fontSize = 15.sp,
                color = Color(0xFF94A3B8),
                fontFamily = PoppinsFontFamily()
            )
            Text(text = "  |  ", fontSize = 15.sp, color = Color(0xFFCBD5E1))
            Text(
                text = "1 adult",
                fontSize = 15.sp,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.weight(1f)
            )
        }

        // ── Scrollable body
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            // Dates prompt banner
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE8F5F5))
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CalIcon(modifier = Modifier.size(18.dp), color = LimehomeTeal)
                    Text(
                        text = "Please select dates for prices",
                        fontSize = 14.sp,
                        color = LimehomeTeal,
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier.weight(1f)
                    )
                    ChevronRightSp(modifier = Modifier.size(16.dp), color = LimehomeTeal)
                }
            }

            // Results header
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text(
                            text = "$propertyCount Limehomes in $cityName",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                        Text(
                            text = "Sustainably operated",
                            fontSize = 13.sp,
                            color = LimehomeTeal,
                            fontFamily = PoppinsFontFamily(),
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .border(1.5.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Map",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF0F172A),
                            fontFamily = PoppinsFontFamily()
                        )
                        MapIcon(modifier = Modifier.size(18.dp))
                    }
                }
            }

            // Guests info line
            item {
                Text(
                    text = "Showing results for 1 guest and 1 room",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }

            // Property cards
            items(listings) { listing ->
                Spacer(modifier = Modifier.height(12.dp))
                PropertyCard(
                    listing = listing,
                    onExplore = { onExploreProperty(listing.name) }
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Promo banner after first card
                if (listing == listings.first()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFE8F5F5))
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(LimehomeTeal),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "✓", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            }
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("Stay more, spend less") }
                                    append(", enjoy ")
                                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("15% off") }
                                    append(" every direct booking with ")
                                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) { append("Limehome.") }
                                },
                                fontSize = 13.sp,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily(),
                                modifier = Modifier.weight(1f),
                                lineHeight = 19.sp
                            )
                            ChevronRightSp(modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }

            item { Spacer(modifier = Modifier.navigationBarsPadding().height(24.dp)) }
        }
    }
}
