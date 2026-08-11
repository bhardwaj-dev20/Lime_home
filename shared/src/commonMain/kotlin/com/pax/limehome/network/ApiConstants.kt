package com.pax.limehome.network

object ApiConstants {
    const val BASE_URL = "https://api.limehome.com/v1/" // Placeholder Base URL

    // Auth Endpoints
    const val LOGIN = "auth/login"
    const val REGISTER = "auth/register"
    const val LOGOUT = "auth/logout"

    // Property Endpoints
    const val HIGHLIGHTS = "properties/highlights"
    const val PROPERTY_DETAILS = "properties/details/{id}"
    const val SEARCH_PROPERTIES = "properties/search"

    // Booking Endpoints
    const val MY_BOOKINGS = "bookings/my"
    const val ADD_BOOKING = "bookings/add"
    const val BOOKING_DETAILS = "bookings/{reference}"

    // Support & Feedback
    const val FEEDBACK = "support/feedback"
    const val FAQS = "support/faqs"
}
