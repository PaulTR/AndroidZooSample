package com.ptrprograms.zoo.events

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ptrprograms.zoo.models.Event

@Dao
interface EventsDao {
    @Query("SELECT * FROM events ORDER BY id DESC")
    fun getEvents(): LiveData<List<Event>>

    @Query("SELECT * FROM events WHERE id = :id")
    fun getEvent(id: String): LiveData<Event>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(events: List<Event>)
}