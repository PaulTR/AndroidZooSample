package com.ptrprograms.zoo.events

import androidx.lifecycle.LiveData
import com.ptrprograms.zoo.models.Event

interface EventsRepository {
    fun getEvents(): LiveData<List<Event>>
    fun getEvent(id: String): LiveData<Event>
}