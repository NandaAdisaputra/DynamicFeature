package com.nandaadisaputra.koin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nandaadisaputra.koin.core.domain.usecase.TourismUseCase

class MapsViewModel (tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}
