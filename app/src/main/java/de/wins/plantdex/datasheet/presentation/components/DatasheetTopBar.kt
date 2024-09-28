package de.wins.plantdex.datasheet.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatasheetTopBar(
    onBack: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.Transparent),
        title = {},
        navigationIcon = {
            FilledIconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Go back")
            }
        }
    )
}