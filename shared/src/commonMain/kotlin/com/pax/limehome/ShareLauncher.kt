package com.pax.limehome

import androidx.compose.runtime.Composable

/**
 * Returns a lambda that triggers the native share sheet with the given [text].
 * On Android this opens an Intent.ACTION_SEND chooser.
 * On other platforms it is a no-op until implemented.
 */
@Composable
expect fun rememberShareLauncher(): (text: String) -> Unit
