package de.wins.plantdex.datasheet

import de.wins.plantdex.core.navigation.Route
import kotlinx.serialization.Serializable

@Serializable
data class DatasheetRoute(val selectedPlantIndex: Int) : Route