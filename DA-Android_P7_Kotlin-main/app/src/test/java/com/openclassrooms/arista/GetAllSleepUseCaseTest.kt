package com.openclassrooms.arista

import com.openclassrooms.arista.data.repository.SleepRepository
import com.openclassrooms.arista.domain.model.Sleep
import com.openclassrooms.arista.domain.usecase.GetAllSleepsUseCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.time.LocalDateTime


@RunWith(JUnit4::class)
class GetAllSleepUseCaseTest {

    @Mock
    private lateinit var sleepRepository: SleepRepository
    private lateinit var getAllSleepsUseCase: GetAllSleepsUseCase


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getAllSleepsUseCase = GetAllSleepsUseCase(sleepRepository)
    }

    @After
    fun tearDown() {
        Mockito.framework().clearInlineMocks()
    }

    @Test
    //arrange
    fun testGetAllSleeps() = runBlocking{
        val fakeSleeps = listOf(
            Sleep(startTime = LocalDateTime.now(), duration = 345, quality = 3, userId = 1, id = 1),
            Sleep(startTime = LocalDateTime.now().plusHours(1), duration = 450, quality = 5, userId = 1, id = 2))
        Mockito.`when`(sleepRepository.getAllSleeps()).thenReturn(fakeSleeps)

    //act
    val result = getAllSleepsUseCase.execute(userId = 1)
    //assert
    assertEquals(fakeSleeps, result)
    }
    @Test
    //arrange
    fun testGetAllSleepsWithEmptyList() = runBlocking {
        Mockito.`when`(sleepRepository.getAllSleeps()).thenReturn(emptyList())
        //act
        val result = getAllSleepsUseCase.execute(userId = 1)
        //assert
        assertTrue(result.isEmpty())
    }


}