package com.pax.limehome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform