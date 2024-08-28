package de.wins.plantdex.scanner.presentation.logic

sealed class CameraUIAction {
    data object OnOpenGallery : CameraUIAction()
    data object OnTakePhoto : CameraUIAction()
    data object OnSwitchLens : CameraUIAction()
}