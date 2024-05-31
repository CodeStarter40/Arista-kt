package com.openclassrooms.arista.data.repository

import com.openclassrooms.arista.data.dao.UserDtoDao
import com.openclassrooms.arista.domain.model.User
import kotlinx.coroutines.flow.first

class UserRepository(private val userDao:UserDtoDao) {

    suspend fun getAllUsers(): List<User> {
        return try {
            userDao.getAllUsers()
                .first()
                .map { User.fromDto(it) }
        } catch (e: Exception)
    { throw Exception("Erreur lors de la récuperation des users: ${e.message}")
        }
    }


    suspend fun getUserById(id: Long): User? {
        val userDto = userDao.getUserById(id)
        return try { userDto?.let { User.fromDto(it) }
    } catch (e: Exception)
    { throw Exception("Erreur lors de la récuperation de l'utilisateur: ${e.message}")
        }
    }

    suspend fun deleteUserById(user:User) {
        user.id?.let { userDao.deleteUserById(id = user.id,) }
    }
}