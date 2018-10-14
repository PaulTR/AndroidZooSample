package com.ptrprograms.zoo.animals

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.ptrprograms.zoo.models.Animal

class AnimalsViewModel internal constructor(repo : AnimalsRepository)
    : ViewModel() {
    private val animalList = MediatorLiveData<List<Animal>>()

    init {
        val liveAnimalList = repo.getAnimals()
        animalList.addSource(liveAnimalList, animalList::setValue)
    }

    fun getAnimals() = animalList
}