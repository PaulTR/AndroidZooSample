package com.ptrprograms.zoo

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ptrprograms.zoo.events.EventDetailViewModel
import com.ptrprograms.zoo.events.EventsRepository
import com.ptrprograms.zoo.events.EventsRepositoryImpl
import com.ptrprograms.zoo.events.EventsViewModel
import com.ptrprograms.zoo.utilities.AppDatabase
import com.ptrprograms.zoo.utilities.DATABASE_NAME
import com.ptrprograms.zoo.utilities.SeedEventsDatabaseWorker
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val koinModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val request = OneTimeWorkRequestBuilder<SeedEventsDatabaseWorker>().build()
                    WorkManager.getInstance().enqueue(request)
                }
            })
            .build()
    }

    single {
        get<AppDatabase>().eventsDao()
    }

    single { EventsRepositoryImpl(get()) as EventsRepository }

    viewModel {
        EventsViewModel(get())
    }

    viewModel {
        (eventId : String) -> EventDetailViewModel(get(), eventId)
    }
}