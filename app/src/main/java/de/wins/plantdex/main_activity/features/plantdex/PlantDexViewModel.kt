package de.wins.plantdex.main_activity.features.plantdex

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.R
import de.wins.plantdex.core.Plant
import de.wins.plantdex.core.PlantRepository
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class PlantDexViewModel @Inject constructor(val plantRepository: PlantRepository) : ViewModel() {

    fun populateWithExamples() {
        for (i in 1..50) {
            plantRepository.addPlant(
                plant = Plant(
                    "MyPlant $i",
                    LocalDate.now(),
                    R.drawable.placeholder
                )
            )
        }
    }

    fun getPlantIndex(plant: Plant) : Int {
        return plantRepository.plants.value.indexOf(plant)
    }

}