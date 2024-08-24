package de.wins.plantdex.datasheet.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.domain.Plant
import de.wins.plantdex.core.domain.PlantRepository
import javax.inject.Inject

@HiltViewModel
class DatasheetViewModel @Inject constructor(val plantRepository: PlantRepository) : ViewModel() {

    fun getPlant(index: Int) : Plant {
        return plantRepository.plants.value[index]
    }

}