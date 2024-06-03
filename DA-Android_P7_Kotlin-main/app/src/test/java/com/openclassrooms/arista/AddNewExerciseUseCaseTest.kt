package com.openclassrooms.arista

import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import com.openclassrooms.arista.data.repository.ExerciseRepository
import com.openclassrooms.arista.domain.model.Exercise
import com.openclassrooms.arista.domain.model.ExerciseCategory
import com.openclassrooms.arista.domain.usecase.AddNewExerciseUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.time.LocalDateTime



@RunWith(JUnit4::class)
class AddNewExerciseUseCaseTest {

    @Mock
    private lateinit var exerciseRepository: ExerciseRepository
    private lateinit var useCase: AddNewExerciseUseCase

    @Before
    fun setUp() {
        //init mocks @Mock
        MockitoAnnotations.initMocks(this)
        //init use case with @Mock repository
        useCase = AddNewExerciseUseCase(exerciseRepository)
    }

    @Test
    fun testAddNewExercise() = runBlocking{
        //exercice wanted to be added
        val fakeExercise = Exercise(id = 2, startTime = LocalDateTime.now(), duration = 348, category = ExerciseCategory.Walking.toString(), intensity = 4, userId = 1)
        //execute use case with the function for creating an fake exercise
        useCase.execute(fakeExercise)
        //verifies that the addExercise function of the repository was called with the fakeExercise object as an argument.
        verify(exerciseRepository).addExercise(fakeExercise)
    }



}