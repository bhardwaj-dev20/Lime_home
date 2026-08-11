package com.pax.limehome

import androidx.compose.runtime.Composable

@Composable
actual fun rememberShareLauncher(): (text: String) -> Unit {
    // TODO: implement UIActivityViewController for iOS
    return { _ -> }
}
