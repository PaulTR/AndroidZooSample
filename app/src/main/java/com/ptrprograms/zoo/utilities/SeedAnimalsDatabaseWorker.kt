package com.ptrprograms.zoo.utilities

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.ptrprograms.zoo.animals.AnimalsDao
import com.ptrprograms.zoo.models.Animal
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class SeedAnimalsDatabaseWorker(context: Context,
                                workerParams: WorkerParameters) : Worker(context, workerParams), KoinComponent {

    override fun doWork(): Result {
        val animalsDao: AnimalsDao by inject()
        val animalType = object : TypeToken<List<Animal>>() {}.type
        var jsonReader: JsonReader? = null

        return try {
            val inputStream = applicationContext.assets.open(ANIMALS_DATA_FILENAME)
            jsonReader = JsonReader(inputStream.reader())
            val animalList: List<Animal> = Gson().fromJson(jsonReader, animalType)
            animalsDao.insertAll(animalList)
            Worker.Result.SUCCESS
        } catch (ex: Exception) {
            Worker.Result.FAILURE
        } finally {
            jsonReader?.close()
        }
    }

}