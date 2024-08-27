package de.wins.plantdex.scanner.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.wins.plantdex.core.domain.PlantRepository
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(val plantRepository: PlantRepository) : ViewModel()