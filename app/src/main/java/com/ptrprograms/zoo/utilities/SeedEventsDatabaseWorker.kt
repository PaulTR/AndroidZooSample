package com.ptrprograms.zoo.utilities

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.ptrprograms.zoo.events.EventsDao
import com.ptrprograms.zoo.models.Event
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class SeedEventsDatabaseWorker(context: Context,
                               workerParams: WorkerParameters) : Worker(context, workerParams), KoinComponent {

    override fun doWork(): Result {
        val eventsDao: EventsDao by inject()
        val eventType = object : TypeToken<List<Event>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(EVENTS_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val eventList: List<Event> = Gson().fromJson(jsonReader, eventType)
            eventsDao.insertAll(eventList)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }

}