package de.wins.plantdex.core.domain

import java.time.LocalDate

data class Plant(val name: String, val scanDate: LocalDate, val imageId: Int)