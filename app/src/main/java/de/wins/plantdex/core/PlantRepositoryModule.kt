package de.wins.plantdex.core

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to data repositories.
 */
@Module
@InstallIn(SingletonComponent::class)
object PlantRepositoryModule {

    /**
     * Provides a singleton instance of [PlantRepository].
     *
     * @return An implementation of [PlantRepository] that is ready for dependency injection.
     */
    @Provides
    @Singleton
    fun provideProductRepository(): PlantRepository = PlantRepositoryImpl()

}