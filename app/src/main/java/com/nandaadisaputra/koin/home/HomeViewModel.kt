package com.nandaadisaputra.koin.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nandaadisaputra.koin.core.domain.usecase.TourismUseCase


class HomeViewModel (tourismUseCase: TourismUseCase) : ViewModel() {
    val tourism = tourismUseCase.getAllTourism().asLiveData()
}
