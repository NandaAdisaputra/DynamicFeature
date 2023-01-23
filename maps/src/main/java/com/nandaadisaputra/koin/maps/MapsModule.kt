package com.nandaadisaputra.koin.maps

import com.nandaadisaputra.koin.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapsModule = module {
    viewModel { MapsViewModel(get()) }
}
