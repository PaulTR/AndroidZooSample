package com.ptrprograms.zoo.animals

class AnimalsRepositoryImpl(private val animalsDao: AnimalsDao) : AnimalsRepository {
    override fun getAnimal(id: String) = animalsDao.getAnimal(id)
    override fun getAnimals() = animalsDao.getAnimals()
}