package de.wins.plantdex.scanner

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel() {
}