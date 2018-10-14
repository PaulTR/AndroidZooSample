package com.ptrprograms.zoo.events

class EventsRepository private constructor(private val eventsDao: EventsDao) {

    fun getEvents() = eventsDao.getEvents()

    fun getEvent(id: String) = eventsDao.getEvent(id)

    companion object {
        @Volatile private var instance: EventsRepository? = null

        fun getInstance(eventsDao: EventsDao) = instance ?: synchronized(this) {
            instance ?: EventsRepository(eventsDao).also { instance = it }
        }
    }
}