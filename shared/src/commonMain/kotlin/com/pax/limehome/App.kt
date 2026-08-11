package com.pax.limehome

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.pax.limehome.screens.HelpScreen
import com.pax.limehome.screens.HomeScreen
import com.pax.limehome.screens.LoginScreen
import com.pax.limehome.screens.SplashScreen
import com.pax.limehome.screens.SearchScreen
import com.pax.limehome.screens.OnboardingScreen
import com.pax.limehome.screens.NotificationSettingsScreen
import com.pax.limehome.screens.LanguageSettingsScreen
import com.pax.limehome.screens.FeedbackScreen
import com.pax.limehome.screens.PropertyDetailsScreen
import com.pax.limehome.screens.HighlightItem
import com.pax.limehome.screens.SelectPropertyScreen
import com.pax.limehome.theme.LimehomeTheme

enum class Screen {
    Splash, Onboarding, Login, Home, Help, Search, NotificationSettings, LanguageSettings, Feedback, PropertyDetails, SelectProperty
}

@Composable
@Preview
fun App() {
    LimehomeTheme {
        var currentScreen by remember { mutableStateOf(Screen.Splash) }
        var isLoggedIn by remember { mutableStateOf(false) }
        var userName by remember { mutableStateOf("") }
        var currentLanguageCode by remember { mutableStateOf("EN") }
        var selectedProperty by remember { mutableStateOf<HighlightItem?>(null) }
        var selectedSearchCity by remember { mutableStateOf("") }
        var selectedSearchGuests by remember { mutableStateOf("1 Guest") }

        when (currentScreen) {
            Screen.Splash -> SplashScreen(onTimeout = {
                currentScreen = Screen.Onboarding
            })
            Screen.Onboarding -> OnboardingScreen(
                onFinishOnboarding = {
                    currentScreen = Screen.Login
                },
                onLaterClick = {
                    currentScreen = Screen.Home
                }
            )
            Screen.Login -> LoginScreen(
                onNavigateToHome = {
                    currentScreen = Screen.Home
                },
                onLoginSuccess = { name ->
                    isLoggedIn = true
                    userName = name
                }
            )
            Screen.Home -> HomeScreen(
                onNavigateToLogin = {
                    currentScreen = Screen.Login
                },
                onNavigateToHelp = {
                    currentScreen = Screen.Help
                },
                onNavigateToSearch = {
                    currentScreen = Screen.Search
                },
                onNavigateToNotificationSettings = {
                    currentScreen = Screen.NotificationSettings
                },
                onNavigateToLanguageSettings = {
                    currentScreen = Screen.LanguageSettings
                },
                onNavigateToFeedback = {
                    currentScreen = Screen.Feedback
                },
                onNavigateToPropertyDetails = { property ->
                    selectedProperty = property
                    currentScreen = Screen.PropertyDetails
                },
                onNavigateToSelectProperty = { city, guests ->
                    selectedSearchCity = city
                    selectedSearchGuests = guests
                    currentScreen = Screen.SelectProperty
                },
                isLoggedIn = isLoggedIn,
                userName = userName,
                languageCode = currentLanguageCode
            )
            Screen.Help -> HelpScreen(onBack = {
                currentScreen = Screen.Home
            })
            Screen.Search -> SearchScreen(
                onBack = { currentScreen = Screen.Home },
                onNavigateToSelectProperty = { city, guests ->
                    selectedSearchCity = city
                    selectedSearchGuests = guests
                    currentScreen = Screen.SelectProperty
                }
            )
            Screen.NotificationSettings -> NotificationSettingsScreen(onBack = {
                currentScreen = Screen.Home
            })
            Screen.LanguageSettings -> LanguageSettingsScreen(
                currentLanguageCode = currentLanguageCode,
                onSaveLanguage = { code -> currentLanguageCode = code },
                onBack = { currentScreen = Screen.Home }
            )
            Screen.Feedback -> FeedbackScreen(
                userEmail = if (isLoggedIn) "" else "",
                onBack = { currentScreen = Screen.Home }
            )
            Screen.PropertyDetails -> {
                val prop = selectedProperty
                if (prop != null) {
                    PropertyDetailsScreen(
                        city = prop.city,
                        street = prop.street,
                        badge = prop.badge,
                        flag = prop.flag,
                        heroImage = prop.image,
                        onBack = { currentScreen = Screen.Home }
                    )
                }
            }
            Screen.SelectProperty -> SelectPropertyScreen(
                cityName = selectedSearchCity,
                guests = selectedSearchGuests,
                onBack = { currentScreen = Screen.Search }
            )
        }
    }
}
