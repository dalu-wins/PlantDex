package de.wins.plantdex.datasheet

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class DatasheetViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel()