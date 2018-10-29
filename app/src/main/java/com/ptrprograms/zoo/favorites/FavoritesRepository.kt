package com.ptrprograms.zoo.favorites

import androidx.lifecycle.LiveData
import com.ptrprograms.zoo.models.FavoriteAnimal

interface FavoritesRepository {
    fun getFavorites() : LiveData<List<FavoriteAnimal>>
    fun addFavorite(favoriteAnimal: FavoriteAnimal)
    fun removeFavorite(favoriteAnimal: FavoriteAnimal)
    fun getFavorite(id: String) : LiveData<FavoriteAnimal>
}