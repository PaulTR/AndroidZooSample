package com.ptrprograms.zoo.favorites

import androidx.lifecycle.LiveData
import com.ptrprograms.zoo.models.FavoriteAnimal

class FavoritesRepositoryImpl(private val favoritesDao: FavoritesDao) : FavoritesRepository {
    override fun getFavorites(): LiveData<List<FavoriteAnimal>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFavorite(favoriteAnimal: FavoriteAnimal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeFavorite(favoriteAnimal: FavoriteAnimal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavorite(id: String): LiveData<FavoriteAnimal> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}