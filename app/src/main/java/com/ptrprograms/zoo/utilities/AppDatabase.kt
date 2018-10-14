package com.ptrprograms.zoo.utilities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ptrprograms.zoo.events.EventsDao
import com.ptrprograms.zoo.models.Event

@Database(entities = [Event::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventsDao(): EventsDao
}
