package com.ptrprograms.zoo.animals

import androidx.lifecycle.LiveData
import com.ptrprograms.zoo.models.Animal

interface AnimalsRepository {
    fun getAnimals(): LiveData<List<Animal>>
    fun getAnimal(id: String): LiveData<Animal>
}