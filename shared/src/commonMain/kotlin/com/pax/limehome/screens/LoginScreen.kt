package com.pax.limehome.screens

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pax.limehome.theme.LimehomeTeal
import com.pax.limehome.theme.PoppinsFontFamily
import com.pax.limehome.theme.White
import com.pax.limehome.components.LimehomeLogo

// --- Custom Icons ---

@Composable
private fun LoginBackArrow(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
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
private fun InfoIconSmall(modifier: Modifier = Modifier, color: Color = Color(0xFF64748B)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.2f.dp.toPx()
        drawCircle(
            color = color,
            radius = w * 0.42f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f),
            style = Stroke(width = stroke)
        )
        // dot
        drawCircle(color = color, radius = w * 0.05f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.32f))
        // line
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.44f), androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.72f), strokeWidth = stroke)
    }
}

@Composable
private fun EyeIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val eyePath = Path().apply {
            moveTo(w * 0.1f, h * 0.5f)
            quadraticTo(w * 0.5f, h * 0.15f, w * 0.9f, h * 0.5f)
            quadraticTo(w * 0.5f, h * 0.85f, w * 0.1f, h * 0.5f)
        }
        drawPath(path = eyePath, color = color, style = Stroke(width = stroke))
        drawCircle(color = color, radius = w * 0.18f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f))
    }
}

@Composable
private fun EyeOffIcon(modifier: Modifier = Modifier, color: Color = Color(0xFF0F172A)) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()
        val eyePath = Path().apply {
            moveTo(w * 0.1f, h * 0.5f)
            quadraticTo(w * 0.5f, h * 0.15f, w * 0.9f, h * 0.5f)
            quadraticTo(w * 0.5f, h * 0.85f, w * 0.1f, h * 0.5f)
        }
        drawPath(path = eyePath, color = color, style = Stroke(width = stroke))
        drawCircle(color = color, radius = w * 0.18f, center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.5f), style = Stroke(width = stroke))
        drawLine(color, androidx.compose.ui.geometry.Offset(w * 0.22f, h * 0.22f), androidx.compose.ui.geometry.Offset(w * 0.78f, h * 0.78f), strokeWidth = stroke * 1.2f)
    }
}

@Composable
fun LoginIllustration(modifier: Modifier = Modifier) {
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
            color = Color(0xFF334155),
            start = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.78f),
            end = androidx.compose.ui.geometry.Offset(w * 0.85f, h * 0.78f),
            strokeWidth = stroke
        )

        // Large Teal/Green Suitcase
        drawRoundRect(
            color = Color(0xFF8FD1CC),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.48f, h * 0.30f),
            size = androidx.compose.ui.geometry.Size(w * 0.22f, h * 0.48f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx())
        )
        drawRoundRect(
            color = Color(0xFF334155),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.48f, h * 0.30f),
            size = androidx.compose.ui.geometry.Size(w * 0.22f, h * 0.48f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val handlePathRight = Path().apply {
            moveTo(w * 0.54f, h * 0.30f)
            lineTo(w * 0.54f, h * 0.24f)
            lineTo(w * 0.64f, h * 0.24f)
            lineTo(w * 0.64f, h * 0.30f)
        }
        drawPath(path = handlePathRight, color = Color(0xFF334155), style = Stroke(width = stroke))
        drawCircle(color = Color(0xFF334155), radius = w * 0.02f, center = androidx.compose.ui.geometry.Offset(w * 0.52f, h * 0.79f))
        drawCircle(color = Color(0xFF334155), radius = w * 0.02f, center = androidx.compose.ui.geometry.Offset(w * 0.66f, h * 0.79f))

        // Small Suitcase
        drawRoundRect(
            color = Color(0xFFE2F3F2),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.41f, h * 0.42f),
            size = androidx.compose.ui.geometry.Size(w * 0.12f, h * 0.36f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx())
        )
        drawRoundRect(
            color = Color(0xFF334155),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.41f, h * 0.42f),
            size = androidx.compose.ui.geometry.Size(w * 0.12f, h * 0.36f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(4.dp.toPx()),
            style = Stroke(width = stroke)
        )
        val handlePathMiddle = Path().apply {
            moveTo(w * 0.44f, h * 0.42f)
            lineTo(w * 0.44f, h * 0.36f)
            lineTo(w * 0.50f, h * 0.36f)
            lineTo(w * 0.50f, h * 0.42f)
        }
        drawPath(path = handlePathMiddle, color = Color(0xFF334155), style = Stroke(width = stroke))
        drawCircle(color = Color(0xFF334155), radius = w * 0.015f, center = androidx.compose.ui.geometry.Offset(w * 0.47f, h * 0.52f))

        // Horizontal Suitcase
        drawRoundRect(
            color = White,
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.54f),
            size = androidx.compose.ui.geometry.Size(w * 0.25f, h * 0.24f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx())
        )
        drawRoundRect(
            color = Color(0xFF334155),
            topLeft = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.54f),
            size = androidx.compose.ui.geometry.Size(w * 0.25f, h * 0.24f),
            cornerRadius = androidx.compose.ui.geometry.CornerRadius(6.dp.toPx()),
            style = Stroke(width = stroke)
        )
        drawLine(Color(0xFF334155), androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.54f), androidx.compose.ui.geometry.Offset(w * 0.35f, h * 0.78f), strokeWidth = stroke)
        drawLine(Color(0xFF334155), androidx.compose.ui.geometry.Offset(w * 0.46f, h * 0.54f), androidx.compose.ui.geometry.Offset(w * 0.46f, h * 0.78f), strokeWidth = stroke)
        val handlePathHoriz = Path().apply {
            moveTo(w * 0.38f, h * 0.54f)
            quadraticTo(w * 0.405f, h * 0.49f, w * 0.43f, h * 0.54f)
        }
        drawPath(path = handlePathHoriz, color = Color(0xFF334155), style = Stroke(width = stroke))

        // Sunglasses
        drawCircle(
            color = Color(0xFF8FD1CC),
            radius = w * 0.025f,
            center = androidx.compose.ui.geometry.Offset(w * 0.22f, h * 0.75f)
        )
        drawCircle(
            color = Color(0xFF334155),
            radius = w * 0.025f,
            center = androidx.compose.ui.geometry.Offset(w * 0.22f, h * 0.75f),
            style = Stroke(width = stroke)
        )
        drawCircle(
            color = Color(0xFF8FD1CC),
            radius = w * 0.025f,
            center = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.75f)
        )
        drawCircle(
            color = Color(0xFF334155),
            radius = w * 0.025f,
            center = androidx.compose.ui.geometry.Offset(w * 0.28f, h * 0.75f),
            style = Stroke(width = stroke)
        )
        val glassBridge = Path().apply {
            moveTo(w * 0.245f, h * 0.74f)
            quadraticTo(w * 0.25f, h * 0.72f, w * 0.255f, h * 0.74f)
        }
        drawPath(glassBridge, Color(0xFF334155), style = Stroke(width = stroke))
    }
}

@Composable
fun VerifyEmailIllustration(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val stroke = 1.8f.dp.toPx()

        // Background circle
        drawCircle(
            color = Color(0xFFF1F5F9),
            radius = w * 0.38f,
            center = androidx.compose.ui.geometry.Offset(w * 0.5f, h * 0.48f)
        )

        // Ground line
        drawLine(
            color = Color(0xFF334155),
            start = androidx.compose.ui.geometry.Offset(w * 0.15f, h * 0.78f),
            end = androidx.compose.ui.geometry.Offset(w * 0.85f, h * 0.78f),
            strokeWidth = stroke
        )

        // Envelope main back
        val envBack = Path().apply {
            moveTo(w * 0.25f, h * 0.46f)
            lineTo(w * 0.25f, h * 0.74f)
            lineTo(w * 0.75f, h * 0.74f)
            lineTo(w * 0.75f, h * 0.46f)
            close()
        }
        drawPath(path = envBack, color = Color(0xFFE2F3F2))
        drawPath(path = envBack, color = Color(0xFF334155), style = Stroke(width = stroke))

        // Letter card
        val letter = Path().apply {
            moveTo(w * 0.32f, h * 0.26f)
            lineTo(w * 0.68f, h * 0.26f)
            lineTo(w * 0.68f, h * 0.56f)
            lineTo(w * 0.32f, h * 0.56f)
            close()
        }
        drawPath(path = letter, color = White)
        drawPath(path = letter, color = Color(0xFF334155), style = Stroke(width = stroke))

        // Document text lines
        drawLine(Color(0xFF334155), androidx.compose.ui.geometry.Offset(w * 0.38f, h * 0.34f), androidx.compose.ui.geometry.Offset(w * 0.62f, h * 0.34f), strokeWidth = stroke * 0.8f)
        drawLine(Color(0xFF334155), androidx.compose.ui.geometry.Offset(w * 0.38f, h * 0.42f), androidx.compose.ui.geometry.Offset(w * 0.56f, h * 0.42f), strokeWidth = stroke * 0.8f)

        // Envelope front pocket flaps
        val envFlap1 = Path().apply {
            moveTo(w * 0.25f, h * 0.46f)
            lineTo(w * 0.5f, h * 0.60f)
            lineTo(w * 0.75f, h * 0.46f)
        }
        drawPath(path = envFlap1, color = Color(0xFFC7EAE7))
        drawPath(path = envFlap1, color = Color(0xFF334155), style = Stroke(width = stroke))

        val envFlap2 = Path().apply {
            moveTo(w * 0.25f, h * 0.74f)
            lineTo(w * 0.5f, h * 0.60f)
            lineTo(w * 0.75f, h * 0.74f)
        }
        drawPath(path = envFlap2, color = Color(0xFFC7EAE7), style = Stroke(width = stroke))
    }
}

@Composable
fun LoginScreen(onNavigateToHome: () -> Unit, onLoginSuccess: (String) -> Unit) {
    var emailText by remember { mutableStateOf("") }
    var isSignUpDetailsStep by remember { mutableStateOf(false) }
    var isVerifyEmailStep by remember { mutableStateOf(false) }

    // Signup form states
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var marketingConsent by remember { mutableStateOf(false) }

    val isEmailValid = emailText.contains("@") && emailText.substringAfter("@").contains(".")
    val isSignUpFormValid = firstName.isNotBlank() && lastName.isNotBlank() && password.length >= 8

    val scrollState = rememberScrollState()

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
            if (isSignUpDetailsStep && !isVerifyEmailStep) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .size(36.dp)
                        .clip(CircleShape)
                        .clickable { isSignUpDetailsStep = false },
                    contentAlignment = Alignment.Center
                ) {
                    LoginBackArrow(modifier = Modifier.size(20.dp))
                }
            }

            Row(
                modifier = Modifier.align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LimehomeLogo(modifier = Modifier.size(24.dp).clip(RoundedCornerShape(4.dp)))
                Text(
                    text = "Sign up or log in",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )
            }

            if (!isSignUpDetailsStep || isVerifyEmailStep) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(8.dp))
                        .clickable { onNavigateToHome() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "✕",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0F172A)
                    )
                }
            }
        }

        // Scrollable content area
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .verticalScroll(scrollState)
                .navigationBarsPadding()
                .padding(horizontal = 24.dp)
                .padding(bottom = 32.dp)
        ) {
            if (!isSignUpDetailsStep && !isVerifyEmailStep) {
                // STEP 1: Email Entering Screen
                Spacer(modifier = Modifier.height(32.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LoginIllustration(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Sign up or log in",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "We will use your email to log you in or create an account",
                    fontSize = 15.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                OutlinedTextField(
                    value = emailText,
                    onValueChange = { emailText = it },
                    label = {
                        Text(
                            text = "Email*",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal,
                        unfocusedLabelColor = Color(0xFF94A3B8)
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (isEmailValid) {
                            // API Call Placeholder: Check if email exists (Login or Sign Up flow)
                            // Example: apiService.checkEmail(emailText)
                            isSignUpDetailsStep = true
                        }
                    },
                    enabled = isEmailValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LimehomeTeal,
                        disabledContainerColor = Color(0xFFB3D9D7)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = "Continue",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isEmailValid) Color.White else Color.White.copy(alpha = 0.8f),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

            } else if (isSignUpDetailsStep && !isVerifyEmailStep) {
                // STEP 2: SignUp Details Screen
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Email not linked to an account. Please sign up to continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "YOUR INFORMATION",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // First Name field
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = {
                        Text(
                            text = "First name*",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal,
                        unfocusedLabelColor = Color(0xFF94A3B8)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Last Name field
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = {
                        Text(
                            text = "Last name*",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal,
                        unfocusedLabelColor = Color(0xFF94A3B8)
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Last name helper
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    InfoIconSmall(modifier = Modifier.size(14.dp))
                    Text(
                        text = "Make sure it matches the name in your government ID",
                        fontSize = 12.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Email field
                OutlinedTextField(
                    value = emailText,
                    onValueChange = { emailText = it },
                    label = {
                        Text(
                            text = "Email*",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    trailingIcon = {
                        if (emailText.isNotEmpty()) {
                            Text(
                                text = "✕",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF0F172A),
                                modifier = Modifier
                                    .clickable { emailText = "" }
                                    .padding(8.dp)
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal,
                        unfocusedLabelColor = Color(0xFF94A3B8)
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Password field
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            text = "Password*",
                            fontFamily = PoppinsFontFamily()
                        )
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { passwordVisible = !passwordVisible },
                            contentAlignment = Alignment.Center
                        ) {
                            if (passwordVisible) {
                                EyeOffIcon(modifier = Modifier.size(20.dp), color = Color(0xFF64748B))
                            } else {
                                EyeIcon(modifier = Modifier.size(20.dp), color = Color(0xFF64748B))
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = LimehomeTeal,
                        unfocusedBorderColor = Color(0xFFCBD5E1),
                        focusedLabelColor = LimehomeTeal,
                        unfocusedLabelColor = Color(0xFF94A3B8)
                    )
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Password helper
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    InfoIconSmall(modifier = Modifier.size(14.dp).padding(top = 2.dp))
                    Text(
                        text = "Your password should have 8 characters, a number, a special character, upper and lower case letters.",
                        fontSize = 12.sp,
                        color = Color(0xFF64748B),
                        fontFamily = PoppinsFontFamily(),
                        lineHeight = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                val termsText = buildAnnotatedString {
                    append("By signing up you agree to Limehome's ")
                    withStyle(style = SpanStyle(color = LimehomeTeal, textDecoration = TextDecoration.Underline)) {
                        append("Terms of use")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(color = LimehomeTeal, textDecoration = TextDecoration.Underline)) {
                        append("Privacy policy.")
                    }
                }
                Text(
                    text = termsText,
                    fontSize = 14.sp,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { marketingConsent = !marketingConsent },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Checkbox(
                        checked = marketingConsent,
                        onCheckedChange = { marketingConsent = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = LimehomeTeal,
                            uncheckedColor = Color(0xFFCBD5E1)
                        )
                    )
                    Text(
                        text = "I want to receive exclusive offers & Limehome news",
                        fontSize = 14.sp,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {
                        if (isSignUpFormValid) {
                            // API Call Placeholder: Register new user
                            // Example: apiService.register(firstName, lastName, emailText, password)
                            isVerifyEmailStep = true
                        }
                    },
                    enabled = isSignUpFormValid,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LimehomeTeal,
                        disabledContainerColor = Color(0xFFB3D9D7)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = "Sign up",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isSignUpFormValid) Color.White else Color.White.copy(alpha = 0.8f),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

            } else {
                // STEP 3: Verify Email Screen
                Spacer(modifier = Modifier.height(32.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    VerifyEmailIllustration(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Verify your email",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0F172A),
                    fontFamily = PoppinsFontFamily()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "We just sent you an email with a link to follow to verify and complete your registration.",
                    fontSize = 15.sp,
                    color = Color(0xFF64748B),
                    fontFamily = PoppinsFontFamily(),
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(36.dp))

                // Verify email button (filled)
                Button(
                    onClick = {
                        // API Call Placeholder: Finalize registration / Login verification
                        // Example: apiService.login(emailText, password)
                        onLoginSuccess(if (firstName.isBlank()) "User" else "$firstName $lastName")
                        onNavigateToHome()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = LimehomeTeal),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = "Verify email",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Log in button (outlined)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .border(1.dp, Color(0xFF0F172A), RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                        .background(White)
                        .clickable {
                            onLoginSuccess(if (firstName.isBlank()) "User" else "$firstName $lastName")
                            onNavigateToHome()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF0F172A),
                        fontFamily = PoppinsFontFamily()
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
