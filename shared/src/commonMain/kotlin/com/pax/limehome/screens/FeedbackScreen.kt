package com.pax.limehome.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.Canvas
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White

@Composable
private fun FeedbackBackArrow(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
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
private fun ChevronDownIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 2f.dp.toPx()
        val path = Path().apply {
            moveTo(w * 0.2f, h * 0.38f)
            lineTo(w * 0.5f, h * 0.65f)
            lineTo(w * 0.8f, h * 0.38f)
        }
        drawPath(path = path, color = color, style = Stroke(width = stroke))
    }
}

@Composable
fun FeedbackScreen(
    userEmail: String = "",
    onBack: () -> Unit
) {
    val topics = listOf(
        "General feedback",
        "Bug report",
        "Feature request",
        "Booking issue",
        "App performance",
        "Other"
    )

    var selectedTopic by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var email by remember { mutableStateOf(userEmail) }
    var showTopicDropdown by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    // Success Dialog
    if (showSuccessDialog) {
        Dialog(onDismissRequest = { showSuccessDialog = false }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(White)
                    .padding(28.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "✅",
                        fontSize = 40.sp
                    )
                    Text(
                        text = "Thank you!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                    Text(
                        text = "Your feedback has been sent successfully.",
                        fontSize = 14.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Button(
                        onClick = {
                            showSuccessDialog = false
                            onBack()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Done",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontFamily = PoppinsFontFamily()
                        )
                    }
                }
            }
        }
    }

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
                FeedbackBackArrow(modifier = Modifier.size(20.dp))
            }

            Text(
                text = "Feedback",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                fontFamily = PoppinsFontFamily(),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Header section
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "SHARE YOUR FEEDBACK ABOUT THE APP",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.8.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )
                Text(
                    text = "We would love to hear your thoughts about the app and where you think we can improve",
                    fontSize = 15.sp,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 22.sp
                )
            }

            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)

            // Topic dropdown section
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "What's your feedback about?",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )

                Box {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                width = 1.5.dp,
                                color = if (showTopicDropdown) LimehomeTeal else Color(0xFFE2E8F0),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable { showTopicDropdown = true }
                            .padding(horizontal = 16.dp, vertical = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (selectedTopic.isEmpty()) "Select a topic" else selectedTopic,
                                fontSize = 15.sp,
                                color = if (selectedTopic.isEmpty()) Color(0xFFADB5BD) else Color(0xFF0F172A),
                                fontFamily = PoppinsFontFamily()
                            )
                            ChevronDownIcon(
                                modifier = Modifier.size(18.dp),
                                color = Color(0xFF64748B)
                            )
                        }
                    }

                    DropdownMenu(
                        expanded = showTopicDropdown,
                        onDismissRequest = { showTopicDropdown = false },
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .background(White)
                    ) {
                        topics.forEach { topic ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = topic,
                                        fontSize = 15.sp,
                                        color = Color(0xFF0F172A),
                                        fontFamily = PoppinsFontFamily()
                                    )
                                },
                                onClick = {
                                    selectedTopic = topic
                                    showTopicDropdown = false
                                }
                            )
                        }
                    }
                }
            }

            // Message text area
            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                placeholder = {
                    Text(
                        text = "Your message here",
                        color = Color(0xFFADB5BD),
                        fontFamily = PoppinsFontFamily(),
                        fontSize = 15.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = LimehomeTeal,
                    unfocusedBorderColor = Color(0xFFE2E8F0),
                    cursorColor = LimehomeTeal
                ),
                maxLines = 6
            )

            // Email field
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Email (optional)",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = {
                        Text(
                            text = "your@email.com",
                            color = Color(0xFFADB5BD),
                            fontFamily = PoppinsFontFamily(),
                            fontSize = 15.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        cursorColor = LimehomeTeal
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }

        // Send button pinned at bottom
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 16.dp)
        ) {
            Button(
                onClick = {
                    if (message.isNotBlank()) {
                        // API Call Placeholder: Submit User Feedback
                        // Example: apiService.submitFeedback(email, message)
                        showSuccessDialog = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = LimehomeTeal,
                    disabledContainerColor = LimehomeTeal.copy(alpha = 0.5f)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                enabled = message.isNotBlank()
            ) {
                Text(
                    text = "Send",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontFamily = PoppinsFontFamily()
                )
            }
        }
    }
}
