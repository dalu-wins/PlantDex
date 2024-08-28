package de.wins.plantdex.scanner.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerTopBar(
    title: String,
    onBack: () -> Unit,
    enabledTorch: Boolean,
    onTorch: () -> Unit,
    isBackCamera: Boolean
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Go back")
            }
        },
        actions = {
            IconButton(
                onClick = onTorch,
                enabled = isBackCamera
            ) {
                if (enabledTorch) {
                    Icon(Icons.Default.FlashOn, "Turn flash off")
                } else {
                    Icon(Icons.Default.FlashOff, "Turn flash on")
                }
            }
        }
    )
}