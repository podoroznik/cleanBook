package com.example.readbook.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.readbook.domain.model.Book

@Database(entities = [Book::class], version = 6, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract val bookDatabaseDao: BookDatabseDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDatabase::class.java,
                        "book_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }

    }
}