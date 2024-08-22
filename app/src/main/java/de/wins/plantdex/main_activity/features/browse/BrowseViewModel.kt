package de.wins.plantdex.main_activity.features.browse

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.PlantRepository
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel()