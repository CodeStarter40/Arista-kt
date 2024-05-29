package com.openclassrooms.arista.domain.model

import com.openclassrooms.arista.data.entity.UserDto

data class User (
    val id: Long? = null,
    var name: String,
    var email: String,
) {
    companion object {

        fun fromDto(dto: UserDto): User {
            return User(
                id = dto.id,
                name = dto.name,
                email = dto.email
            )
        }
    }

        fun toDto(): UserDto {
            return UserDto(
                id = this.id ?: 0,
                name = this.name,
                email = this.email
            )
        }
    }
