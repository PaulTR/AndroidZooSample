package com.ptrprograms.zoo.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animals")
data class Animal(
        @PrimaryKey @ColumnInfo(name = "id") val animalId: String,
        val commonName: String,
        val description: String,
        val imageUrl: String
)