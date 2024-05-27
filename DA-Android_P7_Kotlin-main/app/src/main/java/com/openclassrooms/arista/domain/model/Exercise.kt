package com.openclassrooms.arista.domain.model

import com.openclassrooms.arista.data.entity.ExerciseDto
import java.time.LocalDateTime

data class Exercise(
    val id: Long? = null,
    val startTime: LocalDateTime,
    val duration: Int,
    val category: String,
    val quality: Int,
    val userId: Int
) {
    companion object {
        fun fromDto(dto: ExerciseDto): Exercise {
            return Exercise(
                id = dto.id,
                startTime = dto.startTime,
                duration = dto.duration,
                category = dto.category,
                quality = dto.quality,
                userId = dto.userId
            )
        }
    }

    fun toDto(): ExerciseDto {
        return ExerciseDto(
            id = this.id ?: 0,
            startTime = this.startTime,
            duration = this.duration,
            category = this.category,
            quality = this.quality,
            userId = this.userId
        )
    }
}