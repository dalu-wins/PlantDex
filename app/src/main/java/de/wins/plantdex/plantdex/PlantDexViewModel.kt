package de.wins.plantdex.plantdex

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.R
import de.wins.plantdex.core.data.Plant
import de.wins.plantdex.core.data.PlantRepository
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

}