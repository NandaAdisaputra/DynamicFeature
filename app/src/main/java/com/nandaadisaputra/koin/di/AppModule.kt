package com.nandaadisaputra.koin.di

import com.nandaadisaputra.koin.core.domain.usecase.TourismInteraction
import com.nandaadisaputra.koin.core.domain.usecase.TourismUseCase
import com.nandaadisaputra.koin.detail.DetailTourismViewModel
import com.nandaadisaputra.koin.favorite.FavoriteViewModel
import com.nandaadisaputra.koin.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismInteraction(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}