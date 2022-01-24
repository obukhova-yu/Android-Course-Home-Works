package com.triare.room.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.triare.room.App
import com.triare.room.data.db.dao.UserDao
import com.triare.room.data.db.model.UserDbo

@Database(entities = [UserDbo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        App.context,
                        AppDatabase::class.java,
                        "room"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance!!
        }

    }

}

