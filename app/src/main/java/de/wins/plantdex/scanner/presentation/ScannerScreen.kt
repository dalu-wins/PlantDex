package de.wins.plantdex.scanner.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import de.wins.plantdex.R
import de.wins.plantdex.core.presentation.MyTopBar
import de.wins.plantdex.scanner.presentation.components.CameraControlRow
import de.wins.plantdex.scanner.presentation.components.CameraPreview

@Composable
fun ScannerScreen(
    showTopBar: Boolean,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            if (showTopBar) {
                MyTopBar(
                    title = context.getString(R.string.scanner),
                    onBack = onBack
                )
            }
        }
    ) { innerPaddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPaddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CameraPreview(
                modifier = Modifier
                    .fillMaxSize(fraction = 0.95f)
                    .clip(RoundedCornerShape(12.dp))
                    .weight(0.7f)
            )
            CameraControlRow(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.3f)
            )
        }
    }
}