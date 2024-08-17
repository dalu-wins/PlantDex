package de.wins.plantdex.collection

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel() {
}