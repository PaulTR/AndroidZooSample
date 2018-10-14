package com.ptrprograms.zoo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
        @PrimaryKey @ColumnInfo(name = "id") val eventId: String,
        val dayOfTheWeek: String,
        val date: String,
        val time: String,
        val title: String,
        val description: String,
        val imageUrl: String
)