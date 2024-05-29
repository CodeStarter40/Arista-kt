package com.openclassrooms.arista.data.repository

import com.openclassrooms.arista.data.dao.UserDtoDao
import com.openclassrooms.arista.domain.model.User
import kotlinx.coroutines.flow.first

class UserRepository(private val userDao:UserDtoDao) {

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
            .first()
            .map {User.fromDto(it)}
    }

    suspend fun deleteUserById(user:User) {
        user.id?.let { userDao.deleteUserById(id = user.id,) }
    }
}