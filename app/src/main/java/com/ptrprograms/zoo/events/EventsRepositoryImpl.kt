package com.ptrprograms.zoo.events

class EventsRepositoryImpl constructor(private val eventsDao: EventsDao) : EventsRepository {

    override fun getEvents() = eventsDao.getEvents()

    override fun getEvent(id: String) = eventsDao.getEvent(id)

    companion object {
        @Volatile private var instance: EventsRepositoryImpl? = null

        fun getInstance(eventsDao: EventsDao) = instance ?: synchronized(this) {
            instance ?: EventsRepositoryImpl(eventsDao).also { instance = it }
        }
    }
}