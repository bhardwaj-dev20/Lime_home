package com.pax.limehome.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val name: String,
    val email: String,
    val token: String? = null
)

@Serializable
data class Property(
    val id: String,
    val city: String,
    val street: String,
    val badge: String,
    val imageUrl: String,
    val rating: Double,
    val price: Double
)

@Serializable
data class Booking(
    val id: String,
    val reference: String,
    val propertyId: String,
    val checkIn: String,
    val checkOut: String,
    val status: String
)
