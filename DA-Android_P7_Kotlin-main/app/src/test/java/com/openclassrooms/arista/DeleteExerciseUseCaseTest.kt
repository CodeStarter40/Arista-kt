package com.openclassrooms.arista

import com.openclassrooms.arista.data.repository.ExerciseRepository
import com.openclassrooms.arista.domain.model.Exercise
import com.openclassrooms.arista.domain.usecase.DeleteExerciseUseCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import java.time.LocalDateTime


@RunWith(JUnit4::class)
class DeleteExerciseUseCaseTest {

    @Mock
    private lateinit var repository: ExerciseRepository
    private lateinit var useCase : DeleteExerciseUseCase
    private lateinit var fakeExercise: Exercise



    @Before
    fun setUp() {
    MockitoAnnotations.initMocks(this)
        useCase = DeleteExerciseUseCase(repository)
        fakeExercise = Exercise(id = 1, startTime = LocalDateTime.now(), duration = 345, category = "Running", intensity = 3,userId = 1)
    }

    @Test
    fun deleteExercise() = runBlocking {
        useCase.execute(fakeExercise)
        verify(repository).deleteExercise(fakeExercise)
        val allExercises = repository.getAllExercises()
        assertTrue(allExercises.isNullOrEmpty())
    }
}