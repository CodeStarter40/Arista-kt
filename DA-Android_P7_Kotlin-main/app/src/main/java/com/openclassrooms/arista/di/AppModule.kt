package com.openclassrooms.arista.di

import com.openclassrooms.arista.data.dao.ExerciseDtoDao
import com.openclassrooms.arista.data.dao.SleepDtoDao
import com.openclassrooms.arista.data.dao.UserDtoDao
import com.openclassrooms.arista.data.repository.ExerciseRepository
import com.openclassrooms.arista.data.repository.SleepRepository
import com.openclassrooms.arista.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideUserRepository(userDao:UserDtoDao): UserRepository {
        return UserRepository(userDao)
    }

    @Provides
    @Singleton
    fun provideSleepRepository(sleepDao:SleepDtoDao): SleepRepository {
        return SleepRepository(sleepDao)
    }

    @Provides
    @Singleton
    fun provideExerciseRepository(exerciseDao: ExerciseDtoDao): ExerciseRepository {
        return ExerciseRepository(exerciseDao)
    }
}