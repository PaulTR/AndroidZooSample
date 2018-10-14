package com.ptrprograms.zoo.animals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ptrprograms.zoo.models.Animal

class AnimalDetailViewModel(animalsRepository: AnimalsRepository,
                            private val animalId: String) : ViewModel() {
    val animal : LiveData<Animal>

    init {
        animal = animalsRepository.getAnimal(animalId)
    }
}