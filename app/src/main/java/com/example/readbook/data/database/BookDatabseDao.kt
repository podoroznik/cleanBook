package com.example.readbook.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.readbook.domain.model.Book
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface BookDatabseDao {
    @Insert
    fun insert(book: Book)

    @Update
    fun update(book: Book)

    @Query("SELECT * from book_table WHERE bookId = :key")
    fun get(key: Long): Single<Book>

    @Query("SELECT * from book_table order by bookId")
    fun getAllBooks(): Single<List<Book>>

    @Query("DELETE FROM book_table WHERE bookId = :bookId")
    fun deleteByBookId(bookId: Long)
}