package com.openclassrooms.arista.domain.model

import com.openclassrooms.arista.data.entity.ExerciseDto
import java.time.LocalDateTime
import java.time.ZoneOffset

data class Exercise(
    val id: Long? = null,
    val startTime: LocalDateTime,
    val duration: Int,
    val category: String,
    val intensity: Int,
    val userId: Long,
) {
    companion object {
        fun fromDto(dto: ExerciseDto): Exercise {
            return Exercise(
                id = dto.id,
                startTime = LocalDateTime.ofEpochSecond(dto.startTime / 1000, 0, ZoneOffset.UTC),
                duration = dto.duration,
                category = dto.category,
                intensity = dto.intensity,
                userId = dto.userId
            )
        }
    }

    fun toDto(): ExerciseDto {
        return ExerciseDto(
            id = this.id ?: 0,
            startTime = this.startTime.toEpochSecond(ZoneOffset.UTC) * 1000,
            duration = this.duration,
            category = this.category,
            intensity = this.intensity,
            userId = this.userId
        )
    }
}