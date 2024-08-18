package de.wins.plantdex.plantdex

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class PlantDexViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel() {
}