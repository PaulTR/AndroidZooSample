package com.ptrprograms.zoo

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ptrprograms.zoo.animals.AnimalDetailViewModel
import com.ptrprograms.zoo.animals.AnimalsRepository
import com.ptrprograms.zoo.animals.AnimalsRepositoryImpl
import com.ptrprograms.zoo.animals.AnimalsViewModel
import com.ptrprograms.zoo.events.EventDetailViewModel
import com.ptrprograms.zoo.events.EventsRepository
import com.ptrprograms.zoo.events.EventsRepositoryImpl
import com.ptrprograms.zoo.events.EventsViewModel
import com.ptrprograms.zoo.favorites.FavoritesRepository
import com.ptrprograms.zoo.favorites.FavoritesRepositoryImpl
import com.ptrprograms.zoo.utilities.AppDatabase
import com.ptrprograms.zoo.utilities.DATABASE_NAME
import com.ptrprograms.zoo.utilities.SeedAnimalsDatabaseWorker
import com.ptrprograms.zoo.utilities.SeedEventsDatabaseWorker
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val koinModule = module {
    //TODO try retrieving a set of data from firebase
    //TODO look into replacing the worker with rx https://medium.com/androiddevelopers/room-rxjava-acb0cd4f3757
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val request = OneTimeWorkRequestBuilder<SeedEventsDatabaseWorker>().build()
                    WorkManager.getInstance().enqueue(request)
                }
            })
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val request = OneTimeWorkRequestBuilder<SeedAnimalsDatabaseWorker>().build()
                    WorkManager.getInstance().enqueue(request)
                }
            })
            .build()
    }

    single {
        get<AppDatabase>().eventsDao()
    }

    single {
        get<AppDatabase>().animalsDao()
    }

    single {
        get<AppDatabase>().favoritesDao()
    }

    single { EventsRepositoryImpl(get()) as EventsRepository }

    single { AnimalsRepositoryImpl(get()) as AnimalsRepository }

    single { FavoritesRepositoryImpl(get()) as FavoritesRepository }

    viewModel {
        EventsViewModel(get())
    }

    viewModel {
        (eventId : String) -> EventDetailViewModel(get(), eventId)
    }

    viewModel {
        AnimalsViewModel(get())
    }

    viewModel {
        (animalId: String) -> AnimalDetailViewModel(get(), animalId)
    }
}