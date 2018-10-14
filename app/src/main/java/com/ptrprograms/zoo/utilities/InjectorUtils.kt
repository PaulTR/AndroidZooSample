package com.ptrprograms.zoo.utilities

import android.content.Context
import com.ptrprograms.zoo.events.EventDetailViewModel
import com.ptrprograms.zoo.events.EventsRepository
import com.ptrprograms.zoo.events.EventsViewModel

//TODO Replace this with Koin or Dagger2 - thinking Koin since it's lighter and entirely Kotlin
object InjectorUtils {
    private fun getEventsRepository(context: Context): EventsRepository {
        return EventsRepository.getInstance(AppDatabase.getInstance(context).eventsDao())
    }

    fun provideEventsViewModelFactory(context: Context) : EventsViewModel.EventsViewModelFactory {
        val repository = getEventsRepository(context)
        return EventsViewModel.EventsViewModelFactory(repository)
    }

    fun provideEventDetailViewModelFactory(context: Context, id: String) : EventDetailViewModel.EventDetailViewModelFactory {
        val repository = getEventsRepository(context)
        return EventDetailViewModel.EventDetailViewModelFactory(repository, id)
    }
}