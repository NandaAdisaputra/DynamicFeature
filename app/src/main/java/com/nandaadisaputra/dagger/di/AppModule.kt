package com.nandaadisaputra.dagger.di

import com.nandaadisaputra.dagger.core.domain.usecase.TourismInteraction
import com.nandaadisaputra.dagger.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTourismUseCase(tourismInteraction: TourismInteraction): TourismUseCase

}
