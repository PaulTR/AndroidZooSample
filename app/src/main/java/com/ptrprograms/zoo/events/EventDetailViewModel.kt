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

    class EventDetailViewModelFactory(
            private val eventsRepository: EventsRepository,
            private val eventId: String
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return EventDetailViewModel(eventsRepository, eventId) as T
        }
    }
}