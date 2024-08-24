package de.wins.plantdex.profile.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.domain.PlantRepository
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(plantRepository: PlantRepository) : ViewModel()