package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

import limehome.shared.generated.resources.Res
import limehome.shared.generated.resources.onboarding_stay
import limehome.shared.generated.resources.onboarding_lock
import limehome.shared.generated.resources.onboarding_member

@Composable
fun LocationPin(modifier: Modifier = Modifier, color: Color = Color.White) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val path = Path().apply {
            moveTo(w * 0.5f, 0f)
            cubicTo(w * 0.15f, 0f, 0f, h * 0.3f, 0f, h * 0.45f)
            cubicTo(0f, h * 0.65f, w * 0.35f, h * 0.9f, w * 0.5f, h)
            cubicTo(w * 0.65f, h * 0.9f, w, h * 0.65f, w, h * 0.45f)
            cubicTo(w, h * 0.3f, w * 0.85f, 0f, w * 0.5f, 0f)
            close()
        }
        drawPath(path = path, color = color)
        drawCircle(
            color = Color(0xFF0F172A),
            radius = w * 0.18f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.45f)
        )
    }
}

@Composable
fun OnboardingScreen(
    onFinishOnboarding: () -> Unit,
    onLaterClick: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()
    var currentProgress by remember { mutableStateOf(0f) }

    // Auto-advance timer logic for the story progress indicators
    LaunchedEffect(pagerState.currentPage) {
        currentProgress = 0f
        val durationMs = 5000f // 5 seconds per page
        val stepMs = 30L
        val totalSteps = (durationMs / stepMs).toInt()
        for (step in 1..totalSteps) {
            kotlinx.coroutines.delay(stepMs)
            currentProgress = step.toFloat() / totalSteps
        }
        if (pagerState.currentPage < 2) {
            pagerState.animateScrollToPage(pagerState.currentPage + 1)
        }
    }

    val images = listOf(
        Res.drawable.onboarding_stay,
        Res.drawable.onboarding_lock,
        Res.drawable.onboarding_member
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Background Image for current page
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = true
        ) { page ->
            Image(
                painter = painterResource(images[page]),
                contentDescription = "Onboarding background page ${page + 1}",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // 2. Story-style Progress Indicator at the top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(3) { index ->
                val progress = when {
                    index < pagerState.currentPage -> 1f
                    index == pagerState.currentPage -> currentProgress
                    else -> 0f
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(4.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.4f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(progress)
                            .background(LimehomeTeal)
                    )
                }
            }
        }

        // 3. Floating Badge for page 1 ("Leipzig | Brandenburger-Straße")
        if (pagerState.currentPage == 0) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    // Push up slightly above the bottom sheet height
                    .padding(start = 24.dp, bottom = 360.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black.copy(alpha = 0.55f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    LocationPin(modifier = Modifier.size(14.dp))
                    Text(
                        text = "Leipzig | Brandenburger-Straße",
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = PoppinsFontFamily()
                    )
                }
            }
        }

        // 4. White bottom sheet overlay card
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(340.dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(White)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Content of the card based on the current page
                when (pagerState.currentPage) {
                    0 -> {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "Search and book your perfect stay",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 30.sp
                            )
                            Text(
                                text = "Find your favorite Limehome in 10 countries and more than 85 cities",
                                fontSize = 15.sp,
                                color = Color(0xFF475569),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 22.sp
                            )
                        }
                    }
                    1 -> {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "Experience a digital journey",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 30.sp
                            )
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                val bullets = listOf(
                                    "Manage your trip with ease",
                                    "24/7 support",
                                    "Wifi & access codes in the app"
                                )
                                bullets.forEach { bullet ->
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(5.dp)
                                                .clip(CircleShape)
                                                .background(Color(0xFF0F172A))
                                        )
                                        Text(
                                            text = bullet,
                                            fontSize = 15.sp,
                                            color = Color(0xFF0F172A),
                                            fontFamily = PoppinsFontFamily()
                                        )
                                    }
                                }
                            }
                        }
                    }
                    2 -> {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = "As a member you are saving 15% on every stay",
                                fontSize = 23.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 30.sp
                            )
                            Text(
                                text = "With our membership you will always get the best price",
                                fontSize = 15.sp,
                                color = Color(0xFF475569),
                                fontFamily = PoppinsFontFamily(),
                                lineHeight = 22.sp
                            )
                        }
                    }
                }

                // Footer section with buttons
                if (pagerState.currentPage < 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Skip",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF64748B),
                            fontFamily = PoppinsFontFamily(),
                            modifier = Modifier
                                .clickable {
                                    // Skip to last page
                                    coroutineScope.launch {
                                        pagerState.scrollToPage(2)
                                    }
                                }
                                .padding(vertical = 8.dp, horizontal = 12.dp)
                        )

                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Text(
                                    text = "Next",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    fontFamily = PoppinsFontFamily()
                                )
                                Text(
                                    text = "→",
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                } else {
                    // Full-width "Get started" button + "Later" option on last page
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = {
                                // API Call Placeholder: Track onboarding completion or user intent
                                // Example: analytics.trackEvent("onboarding_finished")
                                onFinishOnboarding()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                        ) {
                            Text(
                                text = "Get started",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                fontFamily = PoppinsFontFamily()
                            )
                        }

                        Text(
                            text = "Later",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF64748B),
                            fontFamily = PoppinsFontFamily(),
                            modifier = Modifier
                                .clickable { onLaterClick() }
                                .padding(vertical = 4.dp, horizontal = 16.dp)
                        )
                    }
                }
            }
        }
    }
}
