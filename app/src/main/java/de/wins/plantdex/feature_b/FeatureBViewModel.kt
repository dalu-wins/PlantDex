package de.wins.plantdex.feature_b

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class FeatureBViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel() {
}