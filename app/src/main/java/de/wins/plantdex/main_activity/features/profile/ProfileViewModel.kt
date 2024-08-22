package de.wins.plantdex.main_activity.features.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.PlantRepository
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel()