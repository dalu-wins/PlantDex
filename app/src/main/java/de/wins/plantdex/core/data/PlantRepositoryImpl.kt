package de.wins.plantdex.core.data

import de.wins.plantdex.core.domain.Plant
import de.wins.plantdex.core.domain.PlantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlantRepositoryImpl : PlantRepository {

    private var _plants: MutableStateFlow<MutableList<Plant>> = MutableStateFlow(mutableListOf())

    override var plants: StateFlow<List<Plant>> = _plants.asStateFlow()

    override fun addPlant(plant: Plant) {
        _plants.value.add(plant)
    }

    override fun deletePlant(plant: Plant) {
        _plants.value.remove(plant)
    }
}