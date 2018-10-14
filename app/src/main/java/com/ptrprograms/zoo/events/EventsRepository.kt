package com.ptrprograms.zoo.events

class EventsRepository private constructor(private val eventDao: EventDao) {

    fun getEvents() = eventDao.getEvents()

    fun getEvent(id: String) = eventDao.getEvent(id)

    companion object {
        @Volatile private var instance: EventsRepository? = null

        fun getInstance(eventDao: EventDao) = instance ?: synchronized(this) {
            instance ?: EventsRepository(eventDao).also { instance = it }
        }
    }
}