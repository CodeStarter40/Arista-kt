package com.openclassrooms.arista.data.repository

import com.openclassrooms.arista.data.dao.ExerciseDtoDao
import com.openclassrooms.arista.domain.model.Exercise
import kotlinx.coroutines.flow.first

class ExerciseRepository(private val exerciseDao: ExerciseDtoDao) {


    // Get all exercises
    suspend fun getAllExercises(): List<Exercise> {
        return try {
            exerciseDao.getAllExercises()
            .first() // Collect the first emission of the Flow
            .map { Exercise.fromDto(it) } // Convert every DTO in Exercise
    } catch (e:Exception) {
            throw Exception("Erreur survenue lors de la récupération des exercices: ${e.message}")
        }
    }


    // Add a new exercise
    suspend fun addExercise(exercise: Exercise) {
        try {
            exerciseDao.insertExercise(exercise.toDto())
        } catch (e: Exception) {
            throw Exception("Erreur survenue lors de l'ajout de l'exercice: ${e.message}")
        }
    }


    // Delete an exercise
    suspend fun deleteExercise(exercise: Exercise) {
        try {
            exercise.id?.let {
                exerciseDao.deleteExerciseById(
                    id = exercise.id,
                )
            }
        } catch (e: Exception) {
            throw Exception("Erreur survenue lors de la suppression de l'exercice: ${e.message}")
        }
    }
}
