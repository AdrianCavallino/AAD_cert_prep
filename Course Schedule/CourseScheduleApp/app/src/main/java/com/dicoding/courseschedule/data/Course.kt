package com.dicoding.courseschedule.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

//TODO 1 : Define a local database table using the schema in app/schema/course.json
@Entity(tableName = "course")
data class Course(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @NotNull
    @ColumnInfo(name = "courseName")
    val courseName: String,

    @NotNull
    @ColumnInfo(name = "day")
    val day: Int,

    @NotNull
    @ColumnInfo(name = "startTime")
    val startTime: String,

    @NotNull
    @ColumnInfo(name = "endTime")
    val endTime: String,

    @NotNull
    @ColumnInfo(name = "lecturer")
    val lecturer: String,

    @NotNull
    @ColumnInfo(name = "note")
    val note: String
)
