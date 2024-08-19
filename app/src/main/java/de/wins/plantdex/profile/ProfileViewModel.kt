package de.wins.plantdex.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.data.PlantRepository
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel()