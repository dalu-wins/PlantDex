package de.wins.plantdex.scanner.presentation.logic

import android.content.Context
import android.os.Environment
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import de.wins.plantdex.R
import java.io.File
import java.text.SimpleDateFormat
import java.util.Locale

fun getOutputFileOptions(
    lensFacing: Int,
    photoFile: File
): ImageCapture.OutputFileOptions {

    // Setup image capture metadata
    val metadata = ImageCapture.Metadata().apply {
        // Mirror image when using the front camera
        isReversedHorizontal = lensFacing == CameraSelector.LENS_FACING_FRONT
    }
    // Create output options object which contains file + metadata
    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile)
        .setMetadata(metadata)
        .build()

    return outputOptions
}

fun createFile(baseFolder: File, format: String, extension: String) =
    File(
        baseFolder, SimpleDateFormat(format, Locale.US)
            .format(System.currentTimeMillis()) + extension
    )


fun Context.getOutputDirectory(): File {

    // TODO Let user select whether he wants to store pics in gallery or in app-specific dir
    val picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
    val customDir = File(picturesDir, this.getString(R.string.app_name)).apply { mkdirs() }

    return if (customDir.exists()) {
        customDir
    } else {
        picturesDir
    }
}