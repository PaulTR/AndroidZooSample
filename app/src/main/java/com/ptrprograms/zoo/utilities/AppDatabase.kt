package com.ptrprograms.zoo.utilities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ptrprograms.zoo.animals.AnimalsDao
import com.ptrprograms.zoo.events.EventsDao
import com.ptrprograms.zoo.favorites.FavoritesDao
import com.ptrprograms.zoo.models.Animal
import com.ptrprograms.zoo.models.Event
import com.ptrprograms.zoo.models.FavoriteAnimal

@Database(entities = [Event::class, Animal::class, FavoriteAnimal::class], version = 2, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventsDao(): EventsDao
    abstract fun animalsDao(): AnimalsDao
    abstract fun favoritesDao(): FavoritesDao
}
