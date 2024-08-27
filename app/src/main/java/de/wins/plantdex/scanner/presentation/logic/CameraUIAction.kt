package de.wins.plantdex.scanner.presentation.logic

sealed class CameraUIAction {
    data object OnShutterClick : CameraUIAction()
}