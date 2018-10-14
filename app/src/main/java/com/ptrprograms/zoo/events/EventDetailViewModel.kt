package com.ptrprograms.zoo.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ptrprograms.zoo.models.Event

class EventDetailViewModel(eventsRepository: EventsRepository,
                           private val eventId: String) : ViewModel() {
    val event : LiveData<Event>

    init {
        event = eventsRepository.getEvent(eventId)
    }
}