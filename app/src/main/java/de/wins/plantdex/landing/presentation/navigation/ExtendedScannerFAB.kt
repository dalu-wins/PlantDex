package de.wins.plantdex.landing.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import de.wins.plantdex.R

@Composable
fun ExtendedScannerFAB(onClick: () -> Unit, expanded: Boolean) {

    val context = LocalContext.current

    ExtendedFloatingActionButton(
        expanded = expanded,
        text = { Text(text = context.getString(R.string.scanner)) },
        icon = { Icon(Icons.Default.PhotoCamera, "Open camera") },
        onClick = onClick
    )
}