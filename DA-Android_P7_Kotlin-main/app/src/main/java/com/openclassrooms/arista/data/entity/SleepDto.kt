package com.openclassrooms.arista.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "sleep",foreignKeys = [ForeignKey(entity = UserDto::class, parentColumns = ["user_id"],childColumns = ["user_id"], onDelete = ForeignKey.CASCADE)])
data class SleepDto (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,


    @ColumnInfo(name = "start_time")
    var startTime: Long,


    @ColumnInfo(name = "duration")
    var duration: Int,


    @ColumnInfo(name = "quality")
    var quality: Int,

    @ColumnInfo(name = "user_id")
    var userId: Int //foreign key to UserDto
)