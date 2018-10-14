package com.ptrprograms.zoo.animals

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ptrprograms.zoo.models.Animal

@Dao
interface AnimalsDao {
    @Query("SELECT * from animals ORDER BY id")
    fun getAnimals(): LiveData<List<Animal>>

    @Query("SELECT * FROM animals WHERE id = :id")
    fun getAnimal(id: String) : LiveData<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(animals: List<Animal>)
}