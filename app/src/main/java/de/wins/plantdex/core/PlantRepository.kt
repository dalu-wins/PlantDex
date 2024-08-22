package de.wins.plantdex.core

import kotlinx.coroutines.flow.StateFlow

interface PlantRepository {

    var plants: StateFlow<List<Plant>>

    fun addPlant(plant: Plant)
    fun deletePlant(plant: Plant)

}