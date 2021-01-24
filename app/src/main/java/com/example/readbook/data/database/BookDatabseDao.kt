package com.example.readbook.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.readbook.domain.model.Book

@Dao
interface BookDatabseDao {
    @Insert
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Query("SELECT * from book_table WHERE bookId = :key")
    fun get(key: Long): LiveData<Book>

    @Query("SELECT * from book_table order by bookId")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("DELETE FROM book_table WHERE bookId = :bookId")
    suspend fun deleteByBookId(bookId: Long)
}