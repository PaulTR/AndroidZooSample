package com.ptrprograms.zoo.utilities

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.ptrprograms.zoo.models.Event

class SeedEventsDatabaseWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val eventType = object : TypeToken<List<Event>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(EVENTS_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val eventList: List<Event> = Gson().fromJson(jsonReader, eventType)
            val database = AppDatabase.getInstance(applicationContext)
            database.eventsDao().insertAll(eventList)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }

}