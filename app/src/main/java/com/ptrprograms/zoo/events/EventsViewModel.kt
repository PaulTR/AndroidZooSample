package com.ptrprograms.zoo.events

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ptrprograms.zoo.models.Event

class EventsViewModel internal constructor(
        private val repo : EventsRepository
) : ViewModel() {
    private val eventList = MediatorLiveData<List<Event>>()

    init {
        val liveEventList = repo.getEvents()

        eventList.addSource(liveEventList, eventList::setValue)
    }

    fun getEvents() = eventList

    class EventsViewModelFactory(private val repo: EventsRepository) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = EventsViewModel(repo) as T
    }
}