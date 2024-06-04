package com.openclassrooms.arista

import com.openclassrooms.arista.data.repository.UserRepository
import com.openclassrooms.arista.domain.model.User
import com.openclassrooms.arista.domain.usecase.GetUserUsecase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class GetUserUseCaseTest {
    @Mock
    private lateinit var userRepository: UserRepository
    private lateinit var getUserUseCase: GetUserUsecase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getUserUseCase = GetUserUsecase(userRepository)
    }

    @After
    fun tearDown() {
        Mockito.framework().clearInlineMocks()
    }

    @Test
    //arrange
    fun testGetUserById() = runBlocking {
        val user = User(name = "Benjamin", email = "benjamin@mail.com", id = 1)
        Mockito.`when`(userRepository.getUserById(1)).thenReturn(user)

        //act
        val result = getUserUseCase.execute(1)

        //assert
        if (result != null) {
            assertEquals("Benjamin",result.name)
        }
    }


}