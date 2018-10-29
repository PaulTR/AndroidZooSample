package com.ptrprograms.zoo.favorites

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ptrprograms.zoo.models.FavoriteAnimal

@Dao
interface FavoritesDao {
    @Query("SELECT * from favorites")
    fun getFavorites(): LiveData<List<FavoriteAnimal>>

    @Insert
    fun addFavorite(favoriteAnimal: FavoriteAnimal) : Long

    @Delete
    fun removeFavorite(favoriteAnimal: FavoriteAnimal)

    @Query("SELECT * from favorites where favorite_id = :id")
    fun getFavorite(id: String) : LiveData<FavoriteAnimal>
}