package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White

// --- Data classes ---

data class RecentSearch(
    val city: String,
    val guests: String
)

data class LocationCountry(
    val name: String,
    val flag: String,
    val cities: List<String>
)

// --- Custom Icons ---

@Composable
private fun SearchBackArrow(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
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
private fun ClockIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val cx = w * 0.5f
        val cy = h * 0.5f
        drawCircle(
            color = color,
            radius = w * 0.4f,
            center = androidx.compose.ui.geometry.Offset(cx, cy),
            style = Stroke(width = stroke)
        )
        // Hour hand
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(cx, cy),
            end = androidx.compose.ui.geometry.Offset(cx, cy - w * 0.22f),
            strokeWidth = stroke
        )
        // Minute hand
        drawLine(
            color = color,
            start = androidx.compose.ui.geometry.Offset(cx, cy),
            end = androidx.compose.ui.geometry.Offset(cx + w * 0.18f, cy),
            strokeWidth = stroke
        )
    }
}

@Composable
private fun CloseXIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF94A3B8)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.25f), androidx.compose.ui.geometry.Offset(w * 0.75f, h * 0.75f), strokeWidth = stroke)
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.75f, h * 0.25f), androidx.compose.ui.geometry.Offset(w * 0.25f, h * 0.75f), strokeWidth = stroke)
    }
}

@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onNavigateToSelectProperty: (city: String, guests: String) -> Unit = { _, _ -> }
) {
    var searchQuery by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val focusRequester = remember { FocusRequester() }

    val recentSearches = remember {
        mutableStateListOf(
            RecentSearch("Berlin", "1 Guest"),
            RecentSearch("Basel", "1 Guest")
        )
    }

    val locations = listOf(
        LocationCountry("Austria", "🇦🇹", listOf("Bad Hall", "Graz", "Klagenfurt", "Linz", "Salzburg", "Vienna")),
        LocationCountry("Belgium", "🇧🇪", listOf("Antwerp", "Brussels")),
        LocationCountry("Czech Republic", "🇨🇿", listOf("Prague")),
        LocationCountry("France", "🇫🇷", listOf("Paris")),
        LocationCountry("Germany", "🇩🇪", listOf("Berlin", "Bonn", "Cologne", "Dortmund", "Düsseldorf", "Frankfurt", "Hamburg", "Hannover", "Munich", "Nuremberg", "Stuttgart")),
        LocationCountry("Italy", "🇮🇹", listOf("Milan", "Rome")),
        LocationCountry("Netherlands", "🇳🇱", listOf("Amsterdam", "The Hague")),
        LocationCountry("Portugal", "🇵🇹", listOf("Lisbon", "Porto")),
        LocationCountry("Spain", "🇪🇸", listOf("Barcelona", "Madrid", "Málaga", "Seville")),
        LocationCountry("Switzerland", "🇨🇭", listOf("Basel", "Zurich")),
        LocationCountry("United Kingdom", "🇬🇧", listOf("London"))
    )

    // Filter locations based on search query
    val filteredLocations = if (searchQuery.isBlank()) {
        locations
    } else {
        locations.mapNotNull { country ->
            val matchingCities = country.cities.filter {
                it.contains(searchQuery, ignoreCase = true)
            }
            val countryNameMatches = country.name.contains(searchQuery, ignoreCase = true)
            if (countryNameMatches) {
                country // Show all cities if country name matches
            } else if (matchingCities.isNotEmpty()) {
                country.copy(cities = matchingCities)
            } else {
                null
            }
        }
    }

    LaunchedEffect(searchQuery) {
        // API Call Placeholder: Fetch filtered locations/cities based on search query
        // Example: if (searchQuery.length > 2) apiService.searchLocations(searchQuery)
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .statusBarsPadding()
    ) {
        // Top Search Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                SearchBackArrow(modifier = Modifier.size(20.dp))
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Where to?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )
                BasicTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    ),
                    cursorBrush = SolidColor(LimehomeTeal),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester)
                )
            }
        }

        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .navigationBarsPadding()
        ) {
            // RECENTLY SEARCHED section
            if (searchQuery.isBlank() && recentSearches.isNotEmpty()) {
                Text(
                    text = "RECENTLY SEARCHED",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 14.dp)
                )

                recentSearches.forEachIndexed { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNavigateToSelectProperty(item.city, item.guests) }
                            .padding(horizontal = 24.dp, vertical = 14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ClockIcon(modifier = Modifier.size(22.dp), color = Color(0xFF64748B))

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = item.city,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily()
                            )
                            Text(
                                text = item.guests,
                                fontSize = 13.sp,
                                color = Color(0xFF64748B),
                                fontFamily = PoppinsFontFamily()
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .clickable { recentSearches.removeAt(index) },
                            contentAlignment = Alignment.Center
                        ) {
                            CloseXIcon(modifier = Modifier.size(14.dp))
                        }
                    }
                }

                HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 6.dp)
            }

            // OUR LOCATIONS section
            Text(
                text = "OUR LOCATIONS",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
                color = Color(0xFF64748B),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 14.dp)
            )

            filteredLocations.forEach { country ->
                // Country header with flag
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = country.flag,
                        fontSize = 22.sp
                    )
                    Text(
                        text = country.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                // City list
                country.cities.forEach { city ->
                    Text(
                        text = city,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { searchQuery = city }
                            .padding(horizontal = 60.dp, vertical = 12.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
